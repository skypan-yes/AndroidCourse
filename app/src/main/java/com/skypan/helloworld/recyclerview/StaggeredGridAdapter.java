package com.skypan.helloworld.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.skypan.helloworld.R;

/**
 * Created by skypan on 2017/9/2.
 */

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.LinearViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public StaggeredGridAdapter(Context context, OnItemClickListener listener){
        this.mContext = context;
        this.mListener = listener;
    }

    @Override
    public StaggeredGridAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_staggered_grid_recyclerview_item,parent,false));
    }

    @Override
    public void onBindViewHolder(StaggeredGridAdapter.LinearViewHolder holder, final int position) {
        if(position % 2 != 0){
            holder.imageView.setImageResource(R.drawable.image1);
        }else{
            holder.imageView.setImageResource(R.drawable.image2);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public LinearViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv);
        }
    }

    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
