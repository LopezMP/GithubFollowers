package edu.upc.dsa.githubfollowers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Followers extends AppCompatActivity {

    private TextView trepos;
    private TextView tfollowing;
    private User user;
    private Context context;
    private ImageView Iavatar;
    private ApiRest apiRest;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<User> userList;

    private MyAdapter recyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers);

        trepos = findViewById(R.id.txtrepositories);
        tfollowing = findViewById(R.id.txtfollowing);
        Iavatar=findViewById(R.id.imageView);

        Intent intent = getIntent();
        user = new User( intent.getStringExtra("login"), intent.getStringExtra("avatar"), intent.getStringExtra("following"), intent.getStringExtra("repos"));

try{
    recyclerView=findViewById(R.id.recycler_view);
    recyclerView.setHasFixedSize(true);

}
catch (Exception e){
    Log.e("error: ", e.getMessage());

}
getlist();
        Usuario();


    }

    private void Usuario(){
        String avatar= user.avatar_url;
        tfollowing.setText("Following:" +user.following);
        trepos.setText("Repos:"+user.public_repos);
        Picasso.with(getApplicationContext()).load(avatar).into(Iavatar);

    }
    private void getlist(){
        apiRest= Api.connection();
        Call<List<User>> call = apiRest.listfollowers(user.login);
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                userList= response.body();
                recyclerAdapter = new MyAdapter(getApplicationContext(), userList);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }
}
