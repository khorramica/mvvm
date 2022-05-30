package ir.finto.mvvmproject.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ir.finto.mvvmproject.R;
import ir.finto.mvvmproject.model.Items;

public class PagingItemAdapter extends PagedListAdapter<Items, PagingItemAdapter.MyViewHolder> {

    Context context;

    public PagingItemAdapter(Context context) {
        super(DIFF_CALLBACk);
        this.context = context;
    }

    private static DiffUtil.ItemCallback<Items> DIFF_CALLBACk = new DiffUtil.ItemCallback<Items>() {
        @Override
        public boolean areItemsTheSame(@NonNull Items oldItem, @NonNull Items newItem) {
            return oldItem.answer_id == newItem.answer_id;
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Items oldItem, @NonNull Items newItem) {
            return newItem.equals(oldItem);
        }
    };

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_paging,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //Items items =getItem(position);
        Items items = getItem(position);

        holder.txtname.setText(items.owner.display_name);
        Picasso.get().load(items.owner.profile_image).into(holder.img_profile);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtname;
        ImageView img_profile;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtname = itemView.findViewById(R.id.txt_name_paging);
            img_profile = itemView.findViewById(R.id.img_Profile);

        }
    }
}
