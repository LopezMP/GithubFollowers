package edu.upc.dsa.githubfollowers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiRest apiRest;
    private TextView tuser;
    private String user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tuser = findViewById(R.id.user);
    }

    public void Explore(View view){
       try {
           user = tuser.getText().toString();
           apiRest= Api.connection();

           Call<User> call = apiRest.getuser(user);
           call.enqueue(new Callback<User>() {
               @Override
               public void onResponse(Call<User> call, Response<User> response) {
                   if (response.code()==200){
                       Intent intent = new Intent(getApplicationContext(), Followers.class);
                       intent.putExtra("login", response.body().login);
                       intent.putExtra("avatar", response.body().avatar_url);
                       intent.putExtra("following", response.body().following);
                       intent.putExtra("repos", response.body().public_repos);
                       startActivity(intent);
                   }
                   else {
                       Context context = getApplicationContext();
                       int duration = Toast.LENGTH_SHORT;
                       CharSequence text = "Error";
                       Toast toast = Toast.makeText(context, text, duration);
                       toast.show();
                   }
               }

               @Override
               public void onFailure(Call<User> call, Throwable t) {

               }
           });
       }
       catch (Exception e){
           Context context = getApplicationContext();
           int duration = Toast.LENGTH_SHORT;
            CharSequence text = e.getMessage();
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
           Log.e("Error", e.getMessage());

        }

    }
}
