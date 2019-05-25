package edu.upc.dsa.githubfollowers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    private Context context;
    private List<User> userList;

    public MyAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder myViewHolder, final int i) {
        if (userList.get(i).avatar_url != null)
            Picasso.with(context).load(userList.get(i).avatar_url).into(myViewHolder.imageView2);

        if (userList.get(i).login != null)
            myViewHolder.txtname.setText(userList.get(i).login);
        else
            myViewHolder.txtname.setText("Not defined");
    }

    @Override
    public int getItemCount() {
        if (userList != null)
            return userList.size();
        else
            return 0;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtname;
        private ImageView imageView2;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtname= itemView.findViewById(R.id.txtname);
            imageView2=itemView.findViewById(R.id.imageView2);
        }
    }
}