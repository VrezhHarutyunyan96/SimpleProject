package com.example.zimadtask.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zimadtask.R;
import com.example.zimadtask.constants.AppConstants;
import com.example.zimadtask.model.Result;
import com.example.zimadtask.view.activity.DetailItemActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerItemAdapter extends RecyclerView.Adapter<RecyclerItemAdapter.ViewHolder>{

    private Context context;
    private ArrayList<Result> arrayList;

    public RecyclerItemAdapter(Context context, ArrayList<Result> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result data = arrayList.get(position);
        holder.tvTitle.setText(data.getTitle());
        Picasso.with(context)
                .load(data.getUrl())
                .into(holder.imgViewContent);
        onItemClick(holder,data);
    }

    private void onItemClick(ViewHolder holder, final Result result) {
        if (holder != null) {
            holder.rootClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String imageUrl = result.getUrl();
                    String title = result.getTitle();
                    Intent intent = new Intent(context, DetailItemActivity.class);
                    intent.putExtra(AppConstants.DETAIL_IMAGE, imageUrl);
                    intent.putExtra(AppConstants.DETAIL_TITLE,title);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgViewContent;
        private TextView tvTitle;
        private ConstraintLayout rootClick;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgViewContent= itemView.findViewById(R.id.imageViewContent);
            tvTitle= itemView.findViewById(R.id.textTitle);
            rootClick  = itemView.findViewById(R.id.rootClick);
        }
    }
}
