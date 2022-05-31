package ir.finto.mvvmproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.finto.mvvmproject.R;
import ir.finto.mvvmproject.RoomDB.Information;
import ir.finto.mvvmproject.interFace.onDeleteItems;

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.MyViewHplder> {

    Context context;
    List<Information> data;
    onDeleteItems listener;

    public InformationAdapter(Context context, List<Information> data, onDeleteItems listener) {
        this.context = context;
        this.data = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHplder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_information, parent, false);

        return new MyViewHplder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHplder holder, int position) {
        if (data != null) {
            holder.SetInformation(data.get(position).getUsername(), position);
            holder.setListener();
        }
    }

    public void Insert(List<Information> information) {
        data = information;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHplder extends RecyclerView.ViewHolder {

        TextView txtUserName;
        ImageView imgDelete;
        int position;

        public MyViewHplder(@NonNull View itemView) {
            super(itemView);

            txtUserName = itemView.findViewById(R.id.txt_Uname);
            imgDelete = itemView.findViewById(R.id.img_Delete);
        }

        public void SetInformation(String username, int position) {
            txtUserName.setText(username);
            this.position = position;
        }

        public void setListener() {
            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    listener.onDelete(data.get(position));
                }
            });

        }
    }
}
