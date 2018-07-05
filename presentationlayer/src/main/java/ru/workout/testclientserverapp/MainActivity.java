package ru.workout.testclientserverapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.workout.testclientserverapp.ui.first_screen.FirstFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            changeFragment(FirstFragment.newInstance());
        }
    }

    public void changeFragment(Fragment newFragment) {
        boolean isInBackStack = getSupportFragmentManager().findFragmentById(R.id.fragment_container) != null;

        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, newFragment);

        if(isInBackStack) {
            fragmentTransaction.addToBackStack(newFragment.getClass().getSimpleName());
        }

        fragmentTransaction.commit();
    }
}
