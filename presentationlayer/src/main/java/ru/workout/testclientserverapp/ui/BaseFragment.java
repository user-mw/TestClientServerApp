package ru.workout.testclientserverapp.ui;

import android.support.v4.app.Fragment;

import ru.workout.testclientserverapp.MainActivity;

public class BaseFragment extends Fragment {
    protected final void changeFragment(Fragment newFragment) {
        if(getActivity() != null) {
            ((MainActivity)getActivity()).changeFragment(newFragment);
        }
    }
}
