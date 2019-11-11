package com.bawei.dongyong20191111.bace;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bawei.dongyong20191111.contates.Icontates;

/**
 * @auther:董青勇
 * @Date: 2019/11/11
 * @Time: 9:19
 * @Description:
 */
public abstract class BaceActivity <P extends BacePresenter> extends AppCompatActivity implements Icontates.Iview {
     public  P mpresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(provideLayoutId()!=0){
             setContentView(provideLayoutId());
             mpresenter=initPresenter();
            if (mpresenter != null) {
                mpresenter.attch(this);
            }
             initView();
             initData();
             setCoDing();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mpresenter != null) {
            mpresenter.deAttch();
            mpresenter=null;
        }
    }

    protected abstract void setCoDing();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P initPresenter();

    protected abstract int provideLayoutId();
}
