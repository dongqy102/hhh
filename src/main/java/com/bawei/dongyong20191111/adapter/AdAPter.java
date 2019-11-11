package com.bawei.dongyong20191111.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.dongyong20191111.R;
import com.bawei.dongyong20191111.json.JsonBean;
import com.bawei.dongyong20191111.net.NetGlide;

import java.util.List;

/**
 * @auther:董青勇
 * @Date: 2019/11/11
 * @Time: 9:58
 * @Description:
 */
public class AdAPter extends RecyclerView.Adapter<AdAPter.Holder> {
     private Context context;
     private List<JsonBean.DataBean.GridDataBean> list;

    public AdAPter(Context context, List<JsonBean.DataBean.GridDataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
         View view=null;
         view=View.inflate(context,R.layout.layout2,null);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int i) {
        JsonBean.DataBean.GridDataBean gridDataBean = list.get(i);
         holder.name.setText(gridDataBean.getTitle());
         holder.price.setText(gridDataBean.getPrice());
        NetGlide.logUrl(gridDataBean.getImageurl(),holder.imgg);
         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (setIt != null) {
                     setIt.setIt(holder.itemView,i);
                 }
             }
         });
    }
       public  interface  setIt{
        void  setIt(View view,int i);
       }
       private  setIt setIt;
    public  void setSetIt(setIt setIt){
         this.setIt=setIt;
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder  extends RecyclerView.ViewHolder{
        ImageView imgg;
        TextView name,price;

        public Holder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);
            imgg=itemView.findViewById(R.id.imgg);
        }
    }
}
