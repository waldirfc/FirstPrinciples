package com.convictvs.edisone.firstprinciples.fragments;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.convictvs.edisone.firstprinciples.R;
import com.convictvs.edisone.firstprinciples.activities.StudoActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ScriptureFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ScriptureFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScriptureFragment extends DialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters
    private String murl_scripture = "";
    private WebView mwebview_scripture;
    private ImageButton mbutton_close;

    //private OnFragmentInteractionListener mListener;

    public ScriptureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle("Escritura");

        getDialog().setCancelable(true);
        //getDialog().requestWindowFeature(STYLE_NORMAL);

        View view = inflater.inflate(R.layout.fragment_scripture, container);

        murl_scripture = getArguments().getString(StudoActivity.ARG_URL_SCRITURE);
        mwebview_scripture = (WebView) view.findViewById(R.id.webView_escritura);
        mwebview_scripture.loadUrl(murl_scripture);

        mbutton_close = (ImageButton) view.findViewById(R.id.imageButton_close);
        mbutton_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        return view;
    }
/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.dialog);

    }*/
/*
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
*/
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
/*    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
