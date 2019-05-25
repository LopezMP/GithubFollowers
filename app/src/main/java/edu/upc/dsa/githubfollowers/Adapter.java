package edu.upc.dsa.githubfollowers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context context;
    private List<User> userList;

    public Adapter(Context context, List<User> userList){
        this.context=context;
        this.userList=userList;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView txtname;
        public ImageView imageView2;
        public View layout;

        public MyViewHolder(View itemView) {
            super(itemView);
            layout=itemView;
            txtname= itemView.findViewById(R.id.txtname);
            imageView2=itemView.findViewById(R.id.imageView2);
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       LayoutInflater inflater=LayoutInflater.from(context);
       View v= inflater.inflate(R.layout.row_layout, viewGroup, false);
       MyViewHolder vh= new MyViewHolder(v);
       return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.txtname.setText(userList.get(i).login);
    }

    @Override
    public int getItemCount() {
        if (userList != null)
            return userList.size();
        else
        return 0;
    }
}
