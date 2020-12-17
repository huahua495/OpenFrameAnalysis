package com.hs.openframeanalysis;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class GlideUtils {

    public static void  loadImage(Context context,String url,ImageView targetView){

        Glide.with(context)
//                .asBitmap()
                .load(url)
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
                .override(300,300)  //指定图片尺寸
                .fitCenter()                    //指定图片缩放类型
                .centerCrop()                   //指定图片缩放类型
                .skipMemoryCache(true)          //跳过内存缓存
                .diskCacheStrategy(DiskCacheStrategy.NONE)  //跳过磁盘缓存
                .diskCacheStrategy(DiskCacheStrategy.DATA)  //
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)//仅仅缓存原来的全分辨率的图像
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存所有版本的图像
                .priority(Priority.HIGH)//指定图片加载的优先级


                .into(targetView);



    }
}



