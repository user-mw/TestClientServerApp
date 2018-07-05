package ru.workout.testclientserverapp.di;

import dagger.Subcomponent;
import ru.workout.testclientserverapp.ui.first_screen.FirstFragment;

@IFragmentScope
@Subcomponent(modules = {FirstScreenModule.class, RepositoryModule.class, ServiceModule.class})
public interface IFirstScreenComponent {
    void inject(FirstFragment fragment);
}
