package org.pursuit.fragmentinterfacecallbacksappfromscratch;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.pursuit.fragmentinterfacecallbacksappfromscratch.fragments.DisplayFragment;
import org.pursuit.fragmentinterfacecallbacksappfromscratch.fragments.InputFragment;
import org.pursuit.fragmentinterfacecallbacksappfromscratch.fragments.onInputFragmentInteraction;

import static org.pursuit.fragmentinterfacecallbacksappfromscratch.fragments.InputFragment.KEY;

public class MainActivity extends AppCompatActivity implements onInputFragmentInteraction {
 private TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        InputFragment inputFragment = InputFragment.newInstance("one","two","three");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container, inputFragment).commit();    }

    @Override
    public void onInputFragmentInteraction(String input, String input2, String input3) {

        DisplayFragment displayFragment = DisplayFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container, displayFragment)
                .addToBackStack(null).commit();

    }
}
