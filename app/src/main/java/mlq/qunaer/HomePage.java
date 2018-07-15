package mlq.qunaer;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;




/**
 * Created by lenovo on 2017/12/12.
 */

public class HomePage extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,View.OnClickListener,ViewPager.OnPageChangeListener{
    private RadioGroup radioGroup;
    private TextView zhoubian;
    private TextView jiudian;
    private RadioGroup topGroup;
    protected ViewPager topPager;
    //底部导航栏按钮
    private RadioGroup bottomradioGroup;
    private RadioButton homePage;
    private RadioButton order;
    private RadioButton discover;
    private RadioButton mine;
    private RadioButton serve;
    //
    Timer timer = new Timer();
    //
    private Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        getSupportActionBar().hide();
        init();
        initLisenner();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (topPager.getCurrentItem() == 8) {
                            topPager.setCurrentItem(0);
                        }else {
                            topPager.setCurrentItem(topPager.getCurrentItem() + 1);
                        }
                    }
                });
            }
        };
        timer.schedule(timerTask,3000,3000);
        //
        data= (Data) getApplication();
        Log.d("data", data.getA());

    }

    //线程
    private void init(){
        radioGroup = (RadioGroup) findViewById(R.id.home_rg_wanna_select);
        radioGroup.setOnCheckedChangeListener(this);
        zhoubian = (TextView) findViewById(R.id.home_tv_zhoubianyou);
        zhoubian.setTextColor(this.getColor(R.color.colorGreen));
        jiudian = (TextView) findViewById(R.id.home_tv_faxianjd);
        add(R.id.home_fl_wanna_frameLayout, new Home_Select_One());
        add(R.id.home_fl_bottom,new Home_ll_zhoubian());
        //初始化viewpager
        topGroup = (RadioGroup) findViewById(R.id.home_rg_radioGroup);
        topGroup.check(R.id.home_topButton_one);
        topPager = (ViewPager) findViewById(R.id.home_vp_topPic);
        //viewpager添加适配器
        topPager.setAdapter(new TopPagerAdapter(getSupportFragmentManager(),getList()));
        //topgroup监听
        topGroup.setOnCheckedChangeListener(this);
        //viewpager监听
        topPager.addOnPageChangeListener(this);
        //底部导航栏初始化
        bottomradioGroup = (RadioGroup) findViewById(R.id.main_rg_radioGroup);
        homePage = (RadioButton) findViewById(R.id.main_rb_homePage);
        order = (RadioButton) findViewById(R.id.main_rb_order);
        discover = (RadioButton) findViewById(R.id.main_rb_discover);
        serve = (RadioButton) findViewById(R.id.main_rb_serve);
        mine = (RadioButton) findViewById(R.id.main_rb_mine);

    }
    //初始化数据
    private List<android.support.v4.app.Fragment> getList(){
        List<android.support.v4.app.Fragment> list = new ArrayList<>();
        list.add(new Home_topic_One());
        list.add(new Home_topic_Two());
        list.add(new Home_topic_Three());
        list.add(new Home_topic_Four());
        list.add(new Home_topic_Five());
        list.add(new Home_topic_Six());
        list.add(new Home_topic_Seven());
        list.add(new Home_topic_Eight());
        list.add(new Home_topic_Nine());
        return list;
    }
    private void initLisenner(){
        zhoubian.setOnClickListener(this);
        jiudian.setOnClickListener(this);
        //底部导航栏监听
        homePage.setOnClickListener(this);
        discover.setOnClickListener(this);
        order.setOnClickListener(this);
        serve.setOnClickListener(this);
        mine.setOnClickListener(this);
        bottomradioGroup.setOnCheckedChangeListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
    //viewpager监听事件
    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                topGroup.check(R.id.home_topButton_one);
                break;
             case 1:
                topGroup.check(R.id.home_topButton_Two);
                break;
             case 2:
                topGroup.check(R.id.home_topButton_Three);
                break;
             case 3:
                topGroup.check(R.id.home_topButton_Four);
                break;
             case 4:
                topGroup.check(R.id.home_topButton_Five);
                break;
             case 5:
                topGroup.check(R.id.home_topButton_Six);
                break;
             case 6:
                topGroup.check(R.id.home_topButton_Seven);
                break;
             case 7:
                topGroup.check(R.id.home_topButton_Eight);
                break;
             case 8:
                topGroup.check(R.id.home_topButton_Nine);
                break;

        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class ButtonHolder{
        RadioButton one;
        RadioButton two;
        RadioButton three;
    }
    class TopButtonHolder{
        RadioButton one;
        RadioButton two;
        RadioButton three;
        RadioButton four;
        RadioButton five;
        RadioButton six;
        RadioButton seven;
        RadioButton eight;
        RadioButton nine;
    }
    //topButtons初始化与监听事件
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        ButtonHolder buttonHolder4=new ButtonHolder();
        buttonHolder4.one = (RadioButton) findViewById(R.id.home_rb_wanna_selectOne);
        buttonHolder4.one.setTextColor(this.getColor(R.color.colorGreen));
        buttonHolder4.two = (RadioButton) findViewById(R.id.home_rb_wanna_selectTwo);
        buttonHolder4.three = (RadioButton) findViewById(R.id.home_rb_wanna_selectThree);
        TopButtonHolder topButtonHolder = new TopButtonHolder();
        topButtonHolder.one = (RadioButton) findViewById(R.id.home_topButton_one);
        topButtonHolder.two = (RadioButton) findViewById(R.id.home_topButton_Two);
        topButtonHolder.three = (RadioButton) findViewById(R.id.home_topButton_Three);
        topButtonHolder.four = (RadioButton) findViewById(R.id.home_topButton_Four);
        topButtonHolder.five = (RadioButton) findViewById(R.id.home_topButton_Five);
        topButtonHolder.six = (RadioButton) findViewById(R.id.home_topButton_Six);
        topButtonHolder.seven = (RadioButton) findViewById(R.id.home_topButton_Seven);
        topButtonHolder.eight = (RadioButton) findViewById(R.id.home_topButton_Eight);
        topButtonHolder.nine = (RadioButton) findViewById(R.id.home_topButton_Nine);
        switch (checkedId) {
            case R.id.home_rb_wanna_selectOne:
                add(R.id.home_fl_wanna_frameLayout,new Home_Select_One());
                buttonHolder4.one.setTextColor(this.getColor(R.color.colorGreen));
                buttonHolder4.two.setTextColor(this.getColor(R.color.colorDefaultText));
                buttonHolder4.three.setTextColor(this.getColor(R.color.colorDefaultText));
                break;
            case R.id.home_rb_wanna_selectTwo:
                add(R.id.home_fl_wanna_frameLayout,new Home_Select_Two());
                buttonHolder4.one.setTextColor(this.getColor(R.color.colorDefaultText));
                buttonHolder4.two.setTextColor(this.getColor(R.color.colorGreen));
                buttonHolder4.three.setTextColor(this.getColor(R.color.colorDefaultText));
                break;
            case R.id.home_rb_wanna_selectThree:
                add(R.id.home_fl_wanna_frameLayout,new Home_Select_Three());
                buttonHolder4.one.setTextColor(this.getColor(R.color.colorDefaultText));
                buttonHolder4.two.setTextColor(this.getColor(R.color.colorDefaultText));
                buttonHolder4.three.setTextColor(this.getColor(R.color.colorGreen));
                break;
            case R.id.home_topButton_one:
                topPager.setCurrentItem(0);
                break;
            case R.id.home_topButton_Two:
                topPager.setCurrentItem(1);
                break;
            case R.id.home_topButton_Three:
                topPager.setCurrentItem(2);
                break;
            case R.id.home_topButton_Four:
                topPager.setCurrentItem(3);
                break;
            case R.id.home_topButton_Five:
                topPager.setCurrentItem(4);
                break;
            case R.id.home_topButton_Six:
                topPager.setCurrentItem(5);
                break;
            case R.id.home_topButton_Seven:
                topPager.setCurrentItem(6);
                break;
            case R.id.home_topButton_Eight:
                topPager.setCurrentItem(7);
                break;
            case R.id.home_topButton_Nine:
                topPager.setCurrentItem(8);
                break;
            case R.id.home_tv_zhoubianyou:
                zhoubian.setTextColor(this.getColor(R.color.colorGreen));
                jiudian.setTextColor(this.getColor(R.color.colorDefaultText));
                break;
            case R.id.home_tv_faxianjd:
                jiudian.setTextColor(this.getColor(R.color.colorGreen));
                zhoubian.setTextColor(this.getColor(R.color.colorDefaultText));
        }
    }
    private void add( int frameLayoutId ,android.support.v4.app.Fragment fragment){
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(frameLayoutId, fragment).commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_tv_zhoubianyou:
                zhoubian.setTextColor(this.getColor(R.color.colorGreen));
                jiudian.setTextColor(this.getColor(R.color.colorDefaultText));
                add(R.id.home_fl_bottom, new Home_ll_zhoubian());
                break;
            case R.id.home_tv_faxianjd:
                zhoubian.setTextColor(this.getColor(R.color.colorDefaultText));
                jiudian.setTextColor(this.getColor(R.color.colorGreen));
                add(R.id.home_fl_bottom, new Home_ll_jiudian());
                break;
            //activity跳转方法
            case R.id.main_rb_order:
                if (data.getA().equals("logged")) {
                    Intent intent = new Intent(this, Order_logged.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(this, Order.class);
                    startActivity(intent);
                }
                    break;
            case R.id.main_rb_discover:
                Intent intent3 = new Intent(this, Serve.class);
                startActivity(intent3);
                break;
            case R.id.main_rb_serve:
                    Intent intent1 = new Intent(this, Discover.class);
                    startActivity(intent1);
                break;
            case R.id.main_rb_mine:
                if (data.getA().equals("logged")) {
                    Intent intent = new Intent(this, Mine_logged.class);
                    startActivity(intent);
                }else {
                    Intent intent2 = new Intent(this, Mine.class);
                    startActivity(intent2);
                }
                break;
        }
    }
}
