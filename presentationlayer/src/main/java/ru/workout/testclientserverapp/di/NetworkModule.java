package ru.workout.testclientserverapp.di;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.workout.datalayer.BuildConfig;
import ru.workout.datalayer.api.ITestApi;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient().newBuilder();
        clientBuilder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

        return clientBuilder.build();
    }

    @Provides
    @Singleton
    Gson provideGsonInstance() {
        return new Gson();
    }

    @Provides
    Retrofit provideRetrofitInstance(Gson gsonInstance, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.MAIN_URL)
                // for interceptors
                //.client(client)
                .addConverterFactory(GsonConverterFactory.create(gsonInstance))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    ITestApi provideApi(Retrofit retrofitInstance) {
        return retrofitInstance.create(ITestApi.class);
    }
}
