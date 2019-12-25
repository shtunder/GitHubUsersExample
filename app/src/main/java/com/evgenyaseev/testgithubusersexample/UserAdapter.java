package com.evgenyaseev.testgithubusersexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter {

    private List<User> users;

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user, viewGroup, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        UserViewHolder holder = (UserViewHolder) viewHolder;
        holder.name.setText(users.get(position).getName());
        Glide.with(holder.avatar)
                .load(users.get(position).getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
