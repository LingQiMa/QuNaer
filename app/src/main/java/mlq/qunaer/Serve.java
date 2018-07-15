package mlq.qunaer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.Time;
import java.util.*;
import java.util.Timer;

/**
 * Created by lenovo on 2017/12/17.
 */

public class Serve extends AppCompatActivity implements View.OnClickListener{
    private ImageView back;
    public int a = 60;
    private TextView second;
    Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.serve);
        getSupportActionBar().hide();
        init();
        timer.schedule(task, 1, 1000);
    }

    private void init() {
        second = (TextView) findViewById(R.id.serve_tv_second);
        back = (ImageView) findViewById(R.id.serve_iv_back);
        back.setOnClickListener(this);
    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    a--;
                    Integer b = new Integer(a);
                    second.setText(b.toString());
                }
            });

        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.serve_iv_back:
                onBackPressed();
                break;
        }
    }
}
