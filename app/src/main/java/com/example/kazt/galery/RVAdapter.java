package com.example.kazt.galery;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kazt on 17/07/17.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {
    private List<String> listVideo = new ArrayList<>();
    private Context c;

    public RVAdapter(List<String> list, Context context) {
        this.listVideo = list;
        this.c = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_inflate, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Bitmap thumbail = ThumbnailUtils.createVideoThumbnail(listVideo.get(position), MediaStore.Video.Thumbnails.FULL_SCREEN_KIND);
        holder.ivInflateImage.setImageBitmap(thumbail);
        holder.ivInflateImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, VideoPlayer.class);
                intent.putExtra("video", listVideo.get(position));
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listVideo.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivInflateImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivInflateImage = (ImageView) itemView.findViewById(R.id.iv_inflate_img);
        }
    }
}
