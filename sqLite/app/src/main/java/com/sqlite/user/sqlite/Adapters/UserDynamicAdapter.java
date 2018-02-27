package com.sqlite.user.sqlite.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sqlite.user.sqlite.Models.Users;
import com.sqlite.user.sqlite.R;

import java.util.ArrayList;

/**
 * Created by USER on 2/27/2018.
 */

public class UserDynamicAdapter extends RecyclerView.Adapter<UserDynamicAdapter.ViewHoldeDataUser> {

    public UserDynamicAdapter(ArrayList<Users> listUsers) {
        this.listUsers = listUsers;
    }

    ArrayList<Users> listUsers;

    @Override
    public ViewHoldeDataUser onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_rows, null, false);
        return new ViewHoldeDataUser(view);
    }

    @Override
    public void onBindViewHolder(ViewHoldeDataUser holder, int position) {
        holder.name.setText(listUsers.get(position).getName().toString());
        holder.email.setText(listUsers.get(position).getEmail().toString());
    }

    @Override
    public int getItemCount() {
        return listUsers.size();
    }

    public class ViewHoldeDataUser extends RecyclerView.ViewHolder {

        TextView name, email;
        public ViewHoldeDataUser(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.idName);
            email = (TextView) itemView.findViewById(R.id.idName);
        }
    }
}
