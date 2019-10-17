package com.innomalist.taxi.rider.activities.travel.fragments;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.innomalist.taxi.common.models.Review;
import com.innomalist.taxi.rider.R;
import com.innomalist.taxi.rider.databinding.FragmentReviewBinding;


public class ReviewDialog extends DialogFragment {
    FragmentReviewBinding binding;

    private onReviewFragmentInteractionListener mListener;

    public ReviewDialog() {
        // Required empty public constructor
    }

    public static ReviewDialog newInstance() {
        ReviewDialog fragment = new ReviewDialog();
        /*Bundle args = new Bundle();
        args.putSerializable(ARG_ADDRESS, param1);
        fragment.setArguments(args);*/
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    public View onCreateDialogView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_review, container, false);
        return binding.getRoot();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle(R.string.review_dialog_title);
        View view = onCreateDialogView(getActivity().getLayoutInflater(), null, null);
        onViewCreated(view, null);
        alertDialogBuilder.setView(view);

        alertDialogBuilder.setPositiveButton(getString(R.string.alert_ok), (dialog, which) -> {
            mListener.onReviewTravelClicked(new Review(binding.ratingBar.getNumStars() * 20, binding.reviewText.getText().toString()));
        });
        alertDialogBuilder.setNegativeButton(getString(R.string.alert_cancel), (dialog, which) -> {
            if (dialog != null) {
                dialog.dismiss();
            }
        });

        return alertDialogBuilder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onReviewFragmentInteractionListener) {
            mListener = (onReviewFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement onEditAddressInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface onReviewFragmentInteractionListener {
        void onReviewTravelClicked(Review review);
    }
}
