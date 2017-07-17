package com.example.rjt.backtoschool.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rjt.backtoschool.R;
import com.example.rjt.backtoschool.models.MainPageItem;
import com.example.rjt.backtoschool.models.MainPageItemsList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by zhangwenpurdue on 7/16/2017.
 */

public class MainPageCardApater extends RecyclerView.Adapter<MainPageViewHolder> {
    private Context mContext;
    ArrayList<Integer> pics = new ArrayList<>();
    public MainPageCardApater(Context context) {
        this.mContext = context;

    }
    @Override
    public MainPageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_page, parent, false);
        final MainPageViewHolder holder = new MainPageViewHolder(view);
        addIcons();
        return holder;
    }

    @Override
    public void onBindViewHolder(MainPageViewHolder holder, int position) {
        MainPageItem mainPageItem = MainPageItemsList.getmInstance().get(position);
        holder.mTextView.setText("fdsfds");
        Picasso.with(mContext).load(pics.get(position)).into(holder.mImageView);


    }

    @Override
    public int getItemCount() {
        return pics.size();
    }
    void addIcons() {
        pics.add(R.drawable.pic1);
        pics.add(R.drawable.pic2);
        pics.add(R.drawable.pic3);
        pics.add(R.drawable.pic4);
        pics.add(R.drawable.pic5);
        pics.add(R.drawable.pic6);



    }

}
class MainPageViewHolder extends RecyclerView.ViewHolder{
    ImageView mImageView;
    TextView mTextView;
    public MainPageViewHolder(View itemView) {
        super(itemView);
        mImageView = (ImageView) itemView.findViewById(R.id.pic);
        mTextView = (TextView) itemView.findViewById(R.id.name);
    }
}
