package mlq.qunaer;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lenovo on 2017/12/9.
 */

public class Discover extends Activity implements View.OnClickListener{
    private TextView order;
    private TextView product;
    private ImageView back;
    private Data data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discover);
        init();
        initListener();
        //
        data = (Data) getApplication();
        //
        FragmentManager fragmentManager1 = getFragmentManager();
        FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
        if (data.getA().equals("logged")) {
            fragmentTransaction1.replace(R.id.dis_fl_frameLayout, new dis_pro_logged()).commit();
        }else {
            fragmentTransaction1.replace(R.id.dis_fl_frameLayout, new dis_product()).commit();
        }
    }
    private void init(){
        order = (TextView) findViewById(R.id.dis_tv_order);
        product = (TextView) findViewById(R.id.dis_tv_pro);
        back = (ImageView) findViewById(R.id.dis_iv_back);
    }
    private void initListener(){
        order.setOnClickListener(this);
        product.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dis_tv_order:
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if (data.getA().equals("logged")) {
                    fragmentTransaction.replace(R.id.dis_fl_frameLayout, new dis_order_logged()).commit();
                }else {
                    fragmentTransaction.replace(R.id.dis_fl_frameLayout, new dis_order()).commit();
                }
                order.setTextColor(getColor(R.color.colorGreen));
                order.setBackgroundResource(R.drawable.dis_title_white);
                product.setTextColor(Color.WHITE);
                product.setBackgroundResource(R.drawable.dis_title_green);
                break;
            case R.id.dis_tv_pro:
                FragmentManager fragmentManager1 = getFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                if (data.getA().equals("logged")) {
                    fragmentTransaction1.replace(R.id.dis_fl_frameLayout, new dis_pro_logged()).commit();
                }else {
                    fragmentTransaction1.replace(R.id.dis_fl_frameLayout, new dis_product()).commit();
                }
                product.setTextColor(getColor(R.color.colorGreen));
                product.setBackgroundResource(R.drawable.dis_title_white);
                order.setTextColor(Color.WHITE);
                order.setBackgroundResource(R.drawable.dis_title_green);
                break;
            case R.id.dis_iv_back:
                onBackPressed();
                break;
        }
    }
}
