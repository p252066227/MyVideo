package edu.feicui.yconline.ui.base;

import android.content.Context;
import android.widget.FrameLayout;

/**
 * Created by Administrator on 2016/8/21.
 */
public abstract class BaseItemView<Model> extends FrameLayout {

    public BaseItemView(Context context) {
        super(context);
        initView();
    }

    /** 初始化当前视图*/
    protected abstract void initView();

    /** 将实体数据设计到当前视图上*/
    protected abstract void bindModel(Model model);
}