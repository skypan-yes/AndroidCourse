package com.skypan.helloworld.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skypan.helloworld.R;

/**
 * Created by skypan on 2017/9/2.
 */

public class HorAdapter extends RecyclerView.Adapter<HorAdapter.LinearViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public HorAdapter(Context context, OnItemClickListener listener){
        this.mContext = context;
        this.mListener = listener;
    }

    @Override
    public HorAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_hor_item,parent,false));
    }

    @Override
    public void onBindViewHolder(HorAdapter.LinearViewHolder holder, final int position) {
        holder.textView.setText("Hello");
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

        private TextView textView;

        public LinearViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
