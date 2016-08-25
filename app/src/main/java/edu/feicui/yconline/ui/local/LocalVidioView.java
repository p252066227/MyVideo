package edu.feicui.yconline.ui.local;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.feicuiedu.videoplayer.full.VideoViewActivity;

import butterknife.ButterKnife;
import edu.feicui.yconline.R;

/**
 * Created by Administrator on 2016/8/15.
 */
public class LocalVidioView extends FrameLayout{

    private ImageView ivPreview; // 视频预览图
    private TextView tvVideoName; // 视频名称
    private RelativeLayout item_Rlayout;

    private String filePath; // 本地视频文件路径

    public LocalVidioView(Context context) {
        this(context, null);
    }

    public LocalVidioView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LocalVidioView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }




    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_local_video, this, true);
        ivPreview = (ImageView) findViewById(R.id.ivPreview);
        tvVideoName = (TextView) findViewById(R.id.tvVideoName);
        item_Rlayout = (RelativeLayout) findViewById(R.id.item_Rlayout);
        item_Rlayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // 全屏播放
                VideoViewActivity.open(getContext(), filePath);
            }
        });

        ButterKnife.bind(this);
    }


    public void bind(Cursor cursor){
        filePath = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA));
        String videoName = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DISPLAY_NAME));
        tvVideoName.setText(videoName);
        // 清除old预览图
        ivPreview.setImageBitmap(null);
    }




    @UiThread
    public void setPreview(@NonNull Bitmap bitmap){
        ivPreview.setImageBitmap(bitmap);
    }

    public void setPreview(final String filePath,final Bitmap bitmap){
        if(!filePath.equals(this.filePath))return;
        post(new Runnable() {
            @Override public void run() {
                // 二次确认
                if(!filePath.equals(LocalVidioView.this.filePath))return;
                ivPreview.setImageBitmap(bitmap);
            }
        });
    }

    public String getFilePath() {
        return filePath;
    }
}
