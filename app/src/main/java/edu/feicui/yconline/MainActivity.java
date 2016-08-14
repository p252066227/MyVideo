package edu.feicui.yconline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.feicuiedu.videoplayer.full.VideoViewActivity;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private Button btnLocal,btnNews,btnLikes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLocal = (Button) findViewById(R.id.btnLocal);

        btnLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                demoPlay();
            }
        });
    }

    @Override public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
    }

    public void demoPlay(){
        // 开启VideoViewActivity进行视频播放
        VideoViewActivity.open(this, getTestVideo1());
    }

    private String getTestVideo1(){
        return "http://o9ve1mre2.bkt.clouddn.com/raw_%E6%B8%A9%E7%BD%91%E7%94%B7%E5%8D%95%E5%86%B3%E8%B5%9B.mp4";
    }
}
