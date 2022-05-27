package ir.finto.mvvmproject.adapter;

import android.content.Context;
import android.content.pm.LabeledIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.finto.mvvmproject.R;
import ir.finto.mvvmproject.databinding.ActivityDataBindingSimplePart01Binding;
import ir.finto.mvvmproject.databinding.ItemUsersBinding;
import ir.finto.mvvmproject.model.Users;

public class userAdapter extends RecyclerView.Adapter<userAdapter.MyViewHolder> {

    Context context;
    List<Users> data;

    public userAdapter(Context context, List<Users> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        ItemUsersBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_users, parent, false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.setUserItem(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ItemUsersBinding binding;

        public MyViewHolder(@NonNull ItemUsersBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
