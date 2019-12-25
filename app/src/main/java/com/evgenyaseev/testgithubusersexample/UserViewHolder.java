package com.evgenyaseev.testgithubusersexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    ImageView avatar;
    TextView name;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        avatar = itemView.findViewById(R.id.user_avatar_image);
        name = itemView.findViewById(R.id.user_name);
    }

}
