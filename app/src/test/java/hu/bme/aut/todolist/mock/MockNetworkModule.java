package hu.bme.aut.todolist.mock;

import javax.inject.Singleton;

import dagger.Provides;
import hu.bme.aut.todolist.network.TaskApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MockNetworkModule {

    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create());

    }

    @Provides
    @Singleton
    public TaskApi provideTaskApi(Retrofit.Builder retrofitBuilder) {
        return new MockTaskApi();
    }
}
