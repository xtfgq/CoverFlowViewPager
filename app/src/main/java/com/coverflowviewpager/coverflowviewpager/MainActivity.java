package com.coverflowviewpager.coverflowviewpager;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private CoverFlowViewPager mCover;
    private int[] weekIcons = new int[]{R.drawable.week1, R.drawable.week2, R.drawable.week3, R.drawable.week4, R.drawable.week5, R.drawable.week6, R.drawable.week7, R.drawable.week8,
            R.drawable.week9, R.drawable.week10, R.drawable.week11, R.drawable.week12, R.drawable.week13, R.drawable.week14, R.drawable.week15, R.drawable.week16, R.drawable.week17, R.drawable.week18,
            R.drawable.week19, R.drawable.week20, R.drawable.week21, R.drawable.week22, R.drawable.week23, R.drawable.week24, R.drawable.week25, R.drawable.week26, R.drawable.week27, R.drawable.week28,
            R.drawable.week29, R.drawable.week30, R.drawable.week31, R.drawable.week32, R.drawable.week33, R.drawable.week34, R.drawable.week35, R.drawable.week36, R.drawable.week37, R.drawable.week38, R.drawable.week39, R.drawable.week40};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCover = (CoverFlowViewPager) findViewById(R.id.cover);

        // 初始化数据
        List<View> list = new ArrayList<>();
        for(int i = 0;i<weekIcons.length;i++){
            ImageView img = new ImageView(this);
            img.setImageResource(weekIcons[i]);
//            img.setBackgroundColor(Color.parseColor("#"+getRandColorCode()));
            list.add(img);
        }
        //设置显示的数据
        mCover.setViewList(list);
        // 设置滑动的监听，该监听为当前页面滑动到中央时的索引
        mCover.setOnPageSelectListener(new OnPageSelectListener() {
            @Override
            public void select(int position) {
                Toast.makeText(getApplicationContext(),position+"",Toast.LENGTH_SHORT).show();
            }
        });
    }
    /**
     * 获取随机颜色，便于区分
     * @return
     */
    public static String getRandColorCode(){
        String r,g,b;
        Random random = new Random();
        r = Integer.toHexString(random.nextInt(256)).toUpperCase();
        g = Integer.toHexString(random.nextInt(256)).toUpperCase();
        b = Integer.toHexString(random.nextInt(256)).toUpperCase();

        r = r.length()==1 ? "0" + r : r ;
        g = g.length()==1 ? "0" + g : g ;
        b = b.length()==1 ? "0" + b : b ;

        return r+g+b;
    }
}
