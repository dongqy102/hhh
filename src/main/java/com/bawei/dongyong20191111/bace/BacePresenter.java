package com.bawei.dongyong20191111.bace;

import com.bawei.dongyong20191111.contates.Icontates;

import java.lang.ref.WeakReference;

/**
 * @auther:董青勇
 * @Date: 2019/11/11
 * @Time: 9:12
 * @Description:
 */
public abstract class BacePresenter <V extends Icontates.Iview> implements Icontates.Ipresenter {
    public BacePresenter() {
        initModel();
    }

    protected abstract void initModel();
    public WeakReference<V>weakReference;

    //绑定
    protected  void attch(V v){
        weakReference=new WeakReference<>(v);
    }
    //解除
    protected  void deAttch(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference=null;
        }
    }

    protected  V getView(){
        return weakReference.get();
    }

}
