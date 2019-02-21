package org.pursuit.fragmentinterfacecallbacksappfromscratch.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.pursuit.fragmentinterfacecallbacksappfromscratch.R;

public class InputFragment extends Fragment {

    private View rootView;
    private onInputFragmentInteraction mListener;
    private EditText inputEditTextOne;
    private EditText inputEditTextTwo;
    private EditText inputEditTextThree;
    private Button inputSubmitButton;
    private String inputOne;
    private String inputTwo;
    private String inputThree;
    public static String KEY = "input";


    public InputFragment() {
    }

    public static InputFragment newInstance(String One, String Two, String Three) {
        InputFragment inputFragment = new InputFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY, One);
        bundle.putString(KEY, Two);
        bundle.putString(KEY, Three);
        inputFragment.setArguments(bundle);
        return inputFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_input, container, false);


        inputEditTextOne = rootView.findViewById(R.id.input_edittext_one);
        inputEditTextTwo = rootView.findViewById(R.id.input_edittext_two);
        inputEditTextThree = rootView.findViewById(R.id.input_edittext_three);
        inputSubmitButton = rootView.findViewById(R.id.input_button);

        inputSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputOne = inputEditTextOne.getText().toString();
                inputTwo = inputEditTextTwo.getText().toString();
                inputThree = inputEditTextThree.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString(KEY, inputOne);
                bundle.putString(KEY, inputTwo);
                bundle.putString(KEY, inputThree);


                if (mListener != null) {
                    mListener.onInputFragmentInteraction(inputOne, inputTwo, inputThree);
                }

            }
        });


        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onInputFragmentInteraction) {
            mListener = (onInputFragmentInteraction) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnInputFragmentInteraction");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
