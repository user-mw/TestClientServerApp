package ru.workout.testclientserverapp.utils;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.workout.datalayer.BuildConfig;
import ru.workout.datalayer.api.ITestApi;

// toDo: This class is not using anymore. Just to remind how it was before.

public class ApiUtils {
    private static Gson mGson;
//    private static OkHttpClient mClient;
//    private static Retrofit mRetrofitInstance;
    private static ITestApi mTestApi;

    private static OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient().newBuilder();
        clientBuilder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

        //mClient = clientBuilder.build();

        return clientBuilder.build();
    }

    private static Retrofit getRetrofitInstance() {
        if(mGson == null) {
            mGson = new Gson();
        }

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.MAIN_URL)
                //.client(new OkHttpClient.Builder().build())
                .addConverterFactory(GsonConverterFactory.create(mGson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static ITestApi getApiInstance() {
//        if(mTestApi == null) {
//            mTestApi = getRetrofitInstance().create(ITestApi.class);
//        }

        mTestApi = getRetrofitInstance().create(ITestApi.class);

        return mTestApi;
    }
}
