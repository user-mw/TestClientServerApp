package ru.workout.testclientserverapp.di;

import dagger.Subcomponent;
import ru.workout.testclientserverapp.ui.second_screen.SecondFragment;

@IFragmentScope
@Subcomponent(modules = {RepositoryModule.class, ServiceModule.class})
public interface ISecondScreenComponent {
    void inject(SecondFragment fragment);
}
