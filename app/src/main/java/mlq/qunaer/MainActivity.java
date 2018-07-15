package mlq.qunaer;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,RadioGroup.OnCheckedChangeListener{
    private RadioGroup radioGroup;
    private RadioButton homePage;
    private RadioButton order;
    private RadioButton discover;
    private RadioButton mine;
    private RadioButton serve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        init();
        initListener();
    }
    private void init(){
        radioGroup = (RadioGroup) findViewById(R.id.main_rg_radioGroup);
        homePage = (RadioButton) findViewById(R.id.main_rb_homePage);
        order = (RadioButton) findViewById(R.id.main_rb_order);
        discover = (RadioButton) findViewById(R.id.main_rb_discover);
        serve = (RadioButton) findViewById(R.id.main_rb_serve);
        mine = (RadioButton) findViewById(R.id.main_rb_mine);
    }
    private void initListener(){
        homePage.setOnClickListener(this);
        discover.setOnClickListener(this);
        order.setOnClickListener(this);
        serve.setOnClickListener(this);
        mine.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_rb_homePage:
               homePage.setTextColor(this.getColor(R.color.colorGreen));

                break;
            case R.id.main_rb_order:
                order.setTextColor(this.getColor(R.color.colorGreen));
                Intent intent = new Intent(this, Order.class);
                startActivity(intent);
                break;
            case R.id.main_rb_discover:
                discover.setTextColor(this.getColor(R.color.colorGreen));
                Intent intent3 = new Intent(this, Serve.class);
                startActivity(intent3);
                break;
            case R.id.main_rb_serve:
                serve.setTextColor(this.getColor(R.color.colorGreen));
                Intent intent1 = new Intent(this, Discover.class);
                startActivity(intent1);
                break;
            case R.id.main_rb_mine:
                mine.setTextColor(this.getColor(R.color.colorGreen));
                Intent intent2 = new Intent(this, Mine.class);
                startActivity(intent2);
                break;

        }

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.main_rb_discover:
                homePage.setTextColor(this.getColor(R.color.colorDefaultText));
                mine.setTextColor(this.getColor(R.color.colorDefaultText));
                order.setTextColor(this.getColor(R.color.colorDefaultText));
                serve.setTextColor(this.getColor(R.color.colorDefaultText));
                break;
            case R.id.main_rb_homePage:
                discover.setTextColor(this.getColor(R.color.colorDefaultText));
                homePage.setTextColor(this.getColor(R.color.colorDefaultText));
                order.setTextColor(this.getColor(R.color.colorDefaultText));
                serve.setTextColor(this.getColor(R.color.colorDefaultText));
                break;
            case R.id.main_rb_mine:
                discover.setTextColor(this.getColor(R.color.colorDefaultText));
                homePage.setTextColor(this.getColor(R.color.colorDefaultText));
                order.setTextColor(this.getColor(R.color.colorDefaultText));
                serve.setTextColor(this.getColor(R.color.colorDefaultText));
                break;
            case R.id.main_rb_order:
                discover.setTextColor(this.getColor(R.color.colorDefaultText));
                homePage.setTextColor(this.getColor(R.color.colorDefaultText));
                mine.setTextColor(this.getColor(R.color.colorDefaultText));
                serve.setTextColor(this.getColor(R.color.colorDefaultText));
                break;
            case R.id.main_rb_serve:
                discover.setTextColor(this.getColor(R.color.colorDefaultText));
                homePage.setTextColor(this.getColor(R.color.colorDefaultText));
                mine.setTextColor(this.getColor(R.color.colorDefaultText));
                order.setTextColor(this.getColor(R.color.colorDefaultText));
                break;
        }
    }
}
