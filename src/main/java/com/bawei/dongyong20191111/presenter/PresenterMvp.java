package com.bawei.dongyong20191111.presenter;

import com.bawei.dongyong20191111.bace.BacePresenter;
import com.bawei.dongyong20191111.contates.Icontates;
import com.bawei.dongyong20191111.model.ModelMvp;

/**
 * @auther:董青勇
 * @Date: 2019/11/11
 * @Time: 9:17
 * @Description:
 */
public class PresenterMvp extends BacePresenter {
    public ModelMvp modelMvp;

    @Override
    protected void initModel() {
        modelMvp = new ModelMvp();
    }

    @Override
    public void start(String url) {
        modelMvp.getInfo(url, new Icontates.MyCallBack() {
            @Override
            public void onSccess(String json) {
                getView().onSccess(json);
            }

            @Override
            public void onErrorSccess(String error) {
                getView().onError(error);
            }
        });
    }
}
