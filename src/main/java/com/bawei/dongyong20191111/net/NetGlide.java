package com.bawei.dongyong20191111.net;

import android.widget.ImageView;

import com.bawei.dongyong20191111.R;
import com.bawei.dongyong20191111.app.AppUrl;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;

/**
 * @auther:董青勇
 * @Date: 2019/11/11
 * @Time: 8:57
 * @Description:
 */
public class NetGlide {
     public static void logUrl(String temUrl, ImageView imageView){
         Glide.with(AppUrl.context)
                 .load(temUrl)
                 .priority(Priority.HIGH)
                 .placeholder(R.drawable.ic_launcher_background)
                 .error(R.drawable.ic_launcher_foreground)
                 .into(imageView);
     }


}
