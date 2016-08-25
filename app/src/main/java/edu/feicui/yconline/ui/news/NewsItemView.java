package edu.feicui.yconline.ui.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.feicui.yconline.R;
import edu.feicui.yconline.commons.CommonUtils;
import edu.feicui.yconline.entity.NewsEntity;
import edu.feicui.yconline.ui.base.BaseItemView;

/**
 * Created by Administrator on 2016/8/21.
 */
public class NewsItemView extends BaseItemView<NewsEntity> {

//    @BindView(R.id.textureView)
    TextureView textureView;
//    @BindView(R.id.ivPreview)
    ImageView ivPreview;
//    @BindView(R.id.tvNewsTitle)
    TextView tvNewsTitle;
//    @BindView(R.id.tvCreatedAt)
    TextView tvCreatedAt;
//    @BindView(R.id.progressBar)
    ProgressBar progressBar;
//    @BindView(R.id.ivPlay)
    ImageView ivPlay;

    private NewsEntity newsEntity;

    public NewsItemView(Context context) {
        super(context);
    }

    @Override protected void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_news, this, true);
        ButterKnife.bind(this);
    }

    @Override protected void bindModel(NewsEntity newsEntity) {
        this.newsEntity = newsEntity;
        textureView = (TextureView) findViewById(R.id.textureView);
        ivPreview = (ImageView) findViewById(R.id.ivPreview);
        tvNewsTitle = (TextView) findViewById(R.id.tvNewsTitle);
        tvCreatedAt = (TextView) findViewById(R.id.tvCreatedAt);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        ivPlay = (ImageView) findViewById(R.id.ivPlay);

        // 初始视图状态
        tvNewsTitle.setVisibility(View.VISIBLE);
        ivPreview.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        ivPlay.setVisibility(View.VISIBLE);
        // 设置标题,创建时间和预览图
        tvNewsTitle.setText(newsEntity.getNewsTitle());
        tvNewsTitle.setText(newsEntity.getNewsTitle());
        tvCreatedAt.setText(CommonUtils.format(newsEntity.getCreatedAt()));
        // 设置预览图像
//        String url = CommonUtils.encodeUrl(newsEntity.getPreviewUrl());
//        Picasso.with(getContext()).load(url).into(ivPreview);
    }

    @OnClick(R.id.tvCreatedAt)
    public void navigateToComments(){
//        CommentsActivity.open(getContext(), newsEntity);
    }

}
