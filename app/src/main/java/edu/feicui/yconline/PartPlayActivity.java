package edu.feicui.yconline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.feicuiedu.videoplayer.part.SimpleVideoView;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/15.
 */
public class PartPlayActivity extends AppCompatActivity{

    private SimpleVideoView simpleVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_play);

        simpleVideoView = (SimpleVideoView) findViewById(R.id.simpleVideoPlayer);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
        simpleVideoView.setVideoPath(getTestVideo1());
    }

    @Override
    protected void onResume() {
        super.onResume();
        simpleVideoView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        simpleVideoView.onPasuse();
    }

    private String getTestVideo1(){
        return "http://o9ve1mre2.bkt.clouddn.com/raw_%E6%B8%A9%E7%BD%91%E7%94%B7%E5%8D%95%E5%86%B3%E8%B5%9B.mp4";
    }


}
