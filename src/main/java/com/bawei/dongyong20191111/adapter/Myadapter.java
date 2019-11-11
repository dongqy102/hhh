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
 * @Time: 9:41
 * @Description:
 */
public class Myadapter extends RecyclerView.Adapter<Myadapter.Holder> {
     private Context context;
     private List<JsonBean.DataBean.VerticalListDataBean>list;

    public Myadapter(Context context, List<JsonBean.DataBean.VerticalListDataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
         View view=null;
         view=View.inflate(context,R.layout.layout1,null);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int i) {
        JsonBean.DataBean.VerticalListDataBean verticalListDataBean = list.get(i);
        holder.name.setText(verticalListDataBean.getTitle());
        holder.price.setText(verticalListDataBean.getPrice());
        NetGlide.logUrl(verticalListDataBean.getImageurl(),holder.imgg);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setItem != null) {
                    setItem.setItem(holder.imgg,i);
                }
            }
        });
    }

    public interface  setItem{
        void setItem(View view,int i);
    }
    private  setItem setItem;
    public  void setSetItem(setItem setItem){
        this.setItem=setItem;
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView imgg;
        TextView name,price;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imgg=itemView.findViewById(R.id.imgg);
            name=itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);
        }
    }
}
