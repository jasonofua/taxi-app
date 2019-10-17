package com.innomalist.taxi.driver.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.CountDownTimer;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.innomalist.taxi.driver.R;
import com.innomalist.taxi.driver.databinding.CardRequestBinding;
import com.innomalist.taxi.common.models.Request;
import com.innomalist.taxi.common.components.LoadingDialog;
import com.innomalist.taxi.common.components.SlideableCardsViewPager.CardAdapter;
import com.innomalist.taxi.common.events.AcceptOrderEvent;
import com.innomalist.taxi.common.utils.CommonUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class RequestCardsAdapter extends PagerAdapter implements CardAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<CardView> mViews;
    private float mBaseElevation;
    private CardRequestBinding binding;

    public RequestCardsAdapter(Context context) {
        this.context = context;
        mViews = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        if (CommonUtils.requests != null)
            return CommonUtils.requests.size();
        else
            return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        //View view = inflater.inflate(R.layout.card_request, container, false);
        binding = DataBindingUtil.inflate(inflater,R.layout.card_request,container,false);
        container.addView(binding.getRoot());
        container.setTag(CommonUtils.requests.get(position));
        bind(CommonUtils.requests.get(position), binding.getRoot());
        if (mBaseElevation == 0)
            mBaseElevation = binding.cardView.getCardElevation();
        binding.cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        binding.progressTimeout.setMax(CommonUtils.timeOut);
        binding.textFrom.setSelected(true);
        binding.textTo.setSelected(true);
        final CountDownTimer countDownTimer = new CountDownTimer(CommonUtils.timeOut, 50) {
            @Override
            public void onTick(long millisUntilFinished) {
                //((Request) container.getTag()).travel.timeout = (int)millisUntilFinished;
                binding.progressTimeout.setProgress((int) millisUntilFinished);
            }

            @Override
            public void onFinish() {
                Request request = (Request) container.getTag();
                if (request != null) {
                    ((ViewPager) container).setAdapter(null);
                    CommonUtils.requests.remove(request);
                    ((ViewPager) container).setAdapter(RequestCardsAdapter.this);
                }
            }
        }.start();
        binding.buttonDecline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                countDownTimer.onFinish();
            }
        });
        if (mViews.size() <= position)
            mViews.add(position, binding.cardView);
        else
            mViews.set(position, binding.cardView);
        return binding.getRoot();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    public int removeView(ViewPager viewPager, int position) {
        viewPager.setAdapter(null);
        mViews.remove(position);
        viewPager.setAdapter(this);
        return position;
    }

    private void bind(final Request item, View view) {
        binding.setRequest(item);
        binding.buttonAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new AcceptOrderEvent(item.travel.getId(),item.cost));
                LoadingDialog.showWithTimer(context, context.getString(R.string.waiting_passenger), 20);
            }
        });
        binding.executePendingBindings();
    }
}
