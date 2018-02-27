package com.sqlite.user.sqlite.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sqlite.user.sqlite.R;

import java.util.ArrayList;

/**
 * Created by USER on 2/27/2018.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolderData> {
    ArrayList<String> listData;

    public UserAdapter(ArrayList<String> listData) {
        this.listData = listData;
    }

    @Override
    public ViewHolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.users_list, null, false);

        return new ViewHolderData(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderData holder, int position) {
        holder.fillData(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolderData extends RecyclerView.ViewHolder {

        TextView result;

        public ViewHolderData(View itemView) {
            super(itemView);

            result =  (TextView) itemView.findViewById(R.id.idDataUser);
        }

        public void fillData(String data) {
            result.setText(data);
        }
    }
}
