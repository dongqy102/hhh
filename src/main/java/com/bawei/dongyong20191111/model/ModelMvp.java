package com.bawei.dongyong20191111.model;

import com.bawei.dongyong20191111.contates.Icontates;
import com.bawei.dongyong20191111.net.NetVolley;

/**
 * @auther:董青勇
 * @Date: 2019/11/11
 * @Time: 9:16
 * @Description:
 */
public class ModelMvp implements  Icontates.Imodel {


    @Override
    public void getInfo(String url, final Icontates.MyCallBack myCallBack) {
        NetVolley.getInstance().doGet(url, new NetVolley.MyCallBack() {
            @Override
            public void onSccess(String json) {
                 myCallBack.onSccess(json);
            }

            @Override
            public void onErrorSccess(String error) {
                myCallBack.onErrorSccess(error);
            }
        });
    }

    @Override
    public void postInfo(String url, Icontates.MyCallBack myCallBack) {

    }
}
