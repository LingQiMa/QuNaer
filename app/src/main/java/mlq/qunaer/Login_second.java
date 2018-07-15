package mlq.qunaer;

import android.app.ActivityManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Login_second extends AppCompatActivity implements TextWatcher,View.OnClickListener{
    private TextView number;
    private EditText yanzhengma;
    private Button next;
    private TextView second;
    private ImageView back;
    static Integer i=60;
    Timer timer = new Timer();
    String randomText;
    private Data data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_second);
       init();
        initListener();
        //给出验证码
        randomText=RandomNumber.createRandomText();
        Toast.makeText(this, "您的验证码为"+randomText, Toast.LENGTH_SHORT).show();
        //线程

        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        second.setText(i.toString());
                        i--;
                    }
                });
            }
        };
        timer.schedule(timerTask, 0, 1000);
        //
        data = (Data) getApplication();
        data.setA("This is Login_second");
        Log.d("data", data.getA());
    }
    private void init(){
        //接收数据并设置
        Intent intent=getIntent();
        number = (TextView) findViewById(R.id.loginSecond_tv_countryAndPhone);
        number.setText(intent.getStringExtra("countryAndPhone"));

        yanzhengma = (EditText) findViewById(R.id.loginSecond_et_yanzhengma);
        yanzhengma.requestFocus();
        next = (Button) findViewById(R.id.loginSecond_btn_next);
        next.setEnabled(false);
        second = (TextView) findViewById(R.id.loginSecond_tv_second);
        back = (ImageView) findViewById(R.id.loginSecond_iv_back);
    }
    private void initListener(){
        yanzhengma.addTextChangedListener(this);
        next.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (yanzhengma.getText().toString().length() == 4) {
            next.setBackgroundResource(R.drawable.button_enable);
            next.setEnabled(true);
        }else {
            next.setBackgroundResource(R.drawable.button_unable);
            next.setEnabled(false);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginSecond_btn_next:
                if (yanzhengma.getText().toString().equals(randomText)) {
                    Intent intent = new Intent(this, Login_third.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(this, "您的验证码有误，请重新输入", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.loginSecond_iv_back:
                onBackPressed();
                break;
        }
    }
}
