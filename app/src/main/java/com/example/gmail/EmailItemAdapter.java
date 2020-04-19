package com.example.gmail;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmailItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    List<ItemModel> listItem;

    public EmailItemAdapter(List<ItemModel> listItem) {
        this.listItem = listItem;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent,false);
        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //khi 1 view được hiển thị, hàm này sẽ đc gọi
        EmailViewHolder viewHolder = (EmailViewHolder) holder;
        ItemModel item = listItem.get(position);
        viewHolder.img.setText(item.getCapId().substring(0,1));
        Drawable background = viewHolder.img.getBackground();
        background.setColorFilter(new PorterDuffColorFilter(item.getColor(), PorterDuff.Mode.SRC_ATOP));
        viewHolder.cap.setText(item.getCapId());
        viewHolder.time.setText(item.getTimeId());
        viewHolder.text1.setText(item.getText1Id());
        viewHolder.text2.setText(item.getText2Id());
        if (item.isSelected())
            viewHolder.star.setImageResource(R.drawable.ic_star_favorite);
        else
            viewHolder.star.setImageResource(R.drawable.ic_star_normal);


    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }


    class EmailViewHolder extends RecyclerView.ViewHolder{

        TextView img ;
        TextView cap;
        TextView time ;
        TextView text1 ;
        TextView text2 ;
        ImageView star;

        public EmailViewHolder(@NonNull View itemView) {
            super(itemView);

            img =itemView.findViewById(R.id.img);
            cap = itemView.findViewById(R.id.caption);
            time = itemView.findViewById(R.id.time);
            text1 = itemView.findViewById(R.id.content1);
            text2 = itemView.findViewById(R.id.content2);
            star = itemView.findViewById(R.id.star);

            star.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isSelected = listItem.get(getAdapterPosition()).isSelected();
                    listItem.get(getAdapterPosition()).setSelected(!isSelected);
                    notifyDataSetChanged();
                }
            });
        }
    }
}
