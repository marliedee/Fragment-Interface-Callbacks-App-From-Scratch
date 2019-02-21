package org.pursuit.fragmentinterfacecallbacksappfromscratch.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.pursuit.fragmentinterfacecallbacksappfromscratch.R;
import org.w3c.dom.Text;


public class DisplayFragment extends Fragment {
    private static final String KEY = "Bundles";
    private View rootView;
    private TextView textView;
    private String textFromEditText;

    public DisplayFragment() {
    }

    public static DisplayFragment newInstance() {
        DisplayFragment displayFragment = new DisplayFragment();
        return displayFragment;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_display, container, false);
        textView = rootView.findViewById(R.id.textView);
        Bundle bundle = getArguments();
        textFromEditText = bundle.getString(KEY);
        textView.setText(textFromEditText);

        return rootView;
    }

}
