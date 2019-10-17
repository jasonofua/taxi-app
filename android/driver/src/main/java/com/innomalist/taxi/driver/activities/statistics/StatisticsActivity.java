package com.innomalist.taxi.driver.activities.statistics;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.View;

import com.innomalist.taxi.driver.R;
import com.innomalist.taxi.driver.databinding.ActivityStatisticsBinding;
import com.innomalist.taxi.driver.events.GetStatisticsEvent;
import com.innomalist.taxi.driver.events.GetStatisticsResultEvent;
import com.innomalist.taxi.driver.events.PaymentRequestEvent;
import com.innomalist.taxi.driver.events.PaymentRequestResultEvent;
import com.innomalist.taxi.driver.models.Report;
import com.innomalist.taxi.driver.activities.statistics.charts.IncomeLineChart;
import com.innomalist.taxi.common.components.BaseActivity;
import com.innomalist.taxi.common.interfaces.AlertDialogEvent;
import com.innomalist.taxi.common.utils.AlertDialogBuilder;
import com.innomalist.taxi.common.utils.AlerterHelper;
import com.innomalist.taxi.common.utils.CommonUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Locale;

public class StatisticsActivity extends BaseActivity {
    ActivityStatisticsBinding binding;
    IncomeLineChart incomeLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_statistics);
        binding.setDriver(CommonUtils.driver);
        initializeToolbar(getString(R.string.title_activity_statistics));
        binding.tabDate.addOnTabSelectedListener(tabSelectedListener);
        eventBus.post(new GetStatisticsEvent(GetStatisticsEvent.QueryTime.DAILY));
        binding.tabDate.setEnabled(false);
    }

    TabLayout.OnTabSelectedListener tabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            eventBus.post(new GetStatisticsEvent(GetStatisticsEvent.QueryTime.get(tab.getPosition() + 1)));
            binding.tabDate.setEnabled(false);
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onChartUpdated(GetStatisticsResultEvent event) {
        if (event.hasError()) {
            event.showError(StatisticsActivity.this, result -> {
                if (result == AlertDialogBuilder.DialogResult.RETRY)
                    eventBus.post(new GetStatisticsEvent(GetStatisticsEvent.QueryTime.get(binding.tabDate.getSelectedTabPosition() + 1)));
                else
                    binding.tabDate.setEnabled(true);
            });
            return;
        }
        binding.chart.dismissAllTooltips();
        binding.chart.reset();
        if (event.reports != null && event.reports.size() != 0) {
            ArrayList<String> labels = new ArrayList<>();
            for (Report report : event.reports) {
                labels.add(report.getDate());
            }
            String[] mLabels = labels.toArray(new String[0]);
            ArrayList<Float> data = new ArrayList<>();
            for (Report report : event.reports) {
                data.add(report.getAmount());
            }
            float[] mValues = new float[data.size()];
            int i = 0;
            for (Float f : data) {
                mValues[i++] = (f != null ? f : Float.NaN); // Or whatever default you want.
            }
            incomeLineChart = new IncomeLineChart(binding.chart, StatisticsActivity.this);
            incomeLineChart.init(mLabels, mValues);
        }
        if (event.stats != null) {
            binding.incomeText.setText(event.stats.getAmount() != null ? getString(R.string.unit_money, event.stats.getAmount()) : "-");
            binding.serviceText.setText(event.stats.getServices() != 0 ? String.format(Locale.getDefault(), "%d", event.stats.getServices()) : "-");
            binding.ratingText.setText(event.stats.getRating() != null ? String.format(Locale.getDefault(), "%.0f %%", event.stats.getRating()) : "-");
        } else {
            binding.incomeText.setText("-");
            binding.serviceText.setText("-");
            binding.ratingText.setText("-");
        }
        binding.tabDate.setEnabled(true);
    }

    public void onPaymentRequestClicked(View view) {
        binding.buttonPaymentRequest.setEnabled(false);
        eventBus.post(new PaymentRequestEvent());
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPaymentRequestResult(PaymentRequestResultEvent event){
        if(event.hasError()){
            binding.buttonPaymentRequest.setEnabled(true);
            event.showAlert(StatisticsActivity.this);
        }
        else
            AlerterHelper.showInfo(StatisticsActivity.this,getString(R.string.message_payment_request_sent));
    }
}
