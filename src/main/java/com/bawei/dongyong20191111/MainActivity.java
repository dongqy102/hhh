package com.bawei.dongyong20191111;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.dongyong20191111.adapter.AdAPter;
import com.bawei.dongyong20191111.adapter.Myadapter;
import com.bawei.dongyong20191111.bace.BaceActivity;
import com.bawei.dongyong20191111.bace.BacePresenter;
import com.bawei.dongyong20191111.json.JsonBean;
import com.bawei.dongyong20191111.net.NetGlide;
import com.bawei.dongyong20191111.net.NetStates;
import com.bawei.dongyong20191111.presenter.PresenterMvp;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

public class MainActivity extends BaceActivity {

    private String url="http://blog.zhaoliang5156.cn/api/shop/jingdong.json";
    private XBanner xbanner;
    private RecyclerView rv;
    private RecyclerView rvv;

    @Override
    protected void setCoDing() {

    }

    @Override
    protected void initData() {
         if(NetStates.getInstance().hasNet(this)){
           mpresenter.start(url);
         }else {
             Toast.makeText(this, "没有网络", Toast.LENGTH_SHORT).show();
         }
    }

    @Override
    protected void initView() {
        //初始化控件
       xbanner=findViewById(R.id.xbanner);
       rv=findViewById(R.id.rv);
       rvv=findViewById(R.id.rvv);
       //普通列表
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
         rvv.setLayoutManager(layoutManager);
     //网格列表
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
      rv.setLayoutManager(gridLayoutManager);

    }

    @Override
    protected BacePresenter initPresenter() {
        return new PresenterMvp();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSccess(String json) {
       //解析数据
        JsonBean jsonBean = new Gson().fromJson(json, JsonBean.class);
        JsonBean.DataBean data = jsonBean.getData();
        final List<JsonBean.DataBean.HorizontalListDataBean> horizontalListData = data.getHorizontalListData();
        List<JsonBean.DataBean.VerticalListDataBean> verticalListData = data.getVerticalListData();
        List<JsonBean.DataBean.GridDataBean> gridData = data.getGridData();

        xbanner.setBannerData(horizontalListData);
        xbanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                NetGlide.logUrl(horizontalListData.get(position).getImageurl(), (ImageView) view);
            }
        });
        //设置适配器
        Myadapter myadapter = new Myadapter(this,verticalListData);
        rvv.setAdapter(myadapter);
        myadapter.setSetItem(new Myadapter.setItem() {
            @Override
            public void setItem(View view, int i) {
                Toast.makeText(MainActivity.this, "点击了"+i+"张图片", Toast.LENGTH_SHORT).show();
            }
        });

        //设置适配器
        AdAPter adAPter = new AdAPter(this,gridData);
         rv.setAdapter(adAPter);
         adAPter.setSetIt(new AdAPter.setIt() {
             @Override
             public void setIt(View view, int i) {
                 Toast.makeText(MainActivity.this, "点击了"+i+"张图片", Toast.LENGTH_SHORT).show();

             }
         });


    }

    @Override
    public void onError(String error) {

    }


}
