package com.bawei.dongyong20191111.contates;

/**
 * @auther:董青勇
 * @Date: 2019/11/11
 * @Time: 9:09
 * @Description:
 */
public interface Icontates {

    interface  MyCallBack{
        void onSccess(String json);
        void onErrorSccess(String error);
    }

    interface  Imodel{
        void  getInfo(String url,MyCallBack myCallBack);
        void  postInfo(String url,MyCallBack myCallBack);
    }
    interface Iview{
        void onSccess(String json);
        void onError(String error);
    }
    interface Ipresenter{
        void start(String url);
    }

}
