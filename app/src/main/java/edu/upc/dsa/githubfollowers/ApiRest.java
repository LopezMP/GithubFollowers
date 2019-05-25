package edu.upc.dsa.githubfollowers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.ListIterator;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiRest {
    @GET("users/{user}")
    Call<User> getuser(@Path("user") String user);

    @GET("users/{user}/followers")
    Call<List<User>> listfollowers(@Path("user") String user);
}
