package edu.feicui.yconline;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import edu.feicui.yconline.ui.local.LocalVideoFragment;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private Button btnLocal,btnNews,btnLikes;
    private ViewPager viewPager;

    private final FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new LocalVideoFragment();
                case 1:
                    return new LocalVideoFragment();
                case 2:
                    return new LocalVideoFragment();
                default:
                    throw new RuntimeException("不存在的数据");
            }
        }
        @Override
        public int getCount() {
            return 3;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLocal = (Button) findViewById(R.id.btnLocal);
        btnNews = (Button) findViewById(R.id.btnNews);
        btnLikes = (Button) findViewById(R.id.btnLikes);
        viewPager = (ViewPager) findViewById(R.id.viewPager11);

        viewPager.setAdapter(adapter);
        // 对ViewPager进行监听(为了在Pager切换时，下方Button的切换)
        viewPager.addOnPageChangeListener(this);

        btnLocal.setOnClickListener(listener);
        btnNews.setOnClickListener(listener);
        btnLikes.setOnClickListener(listener);


        // 首次进入默认选中在线新闻
        btnNews.setSelected(true);

    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);

    }


    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
//            public void chooseFragment(View view)
            switch (view.getId()){
                case R.id.btnNews:
                    viewPager.setCurrentItem(0, false);
                    return;
                case R.id.btnLocal:
                    viewPager.setCurrentItem(1, false);
                    return;
                case R.id.btnLikes:
                    viewPager.setCurrentItem(2, false);
            }
        }
    };

//    public void demoPlay(){
//        // 开启VideoViewActivity进行视频播放
//        VideoViewActivity.open(this, getTestVideo1());
//    }

//    private String getTestVideo1(){
//        return "http://o9ve1mre2.bkt.clouddn.com/raw_%E6%B8%A9%E7%BD%91%E7%94%B7%E5%8D%95%E5%86%B3%E8%B5%9B.mp4";
//    }





    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
    @Override
    public void onPageSelected(int position) {
        btnNews.setSelected(position == 0);
        btnLocal.setSelected(position == 1);
        btnLikes.setSelected(position == 2);
    }
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
