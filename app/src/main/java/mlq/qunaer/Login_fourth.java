package mlq.qunaer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Login_fourth extends AppCompatActivity implements TextWatcher,View.OnClickListener,View.OnKeyListener{
    private EditText one;
    private EditText two;
    private EditText three;
    private EditText four;
    private EditText five;
    private EditText six;
    private ImageView back;
    private Button next;
    private String psd_first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_fourth);
        init();
        initListener();
        //改变登陆状态
    }
    private void init(){
        //接受第一次输入的密码
        Intent intent = getIntent();
        psd_first = intent.getStringExtra("password");
        //初始化
        one = (EditText) findViewById(R.id.loginFourth_psd_one);
        two = (EditText) findViewById(R.id.loginFourth_psd_two);
        three = (EditText) findViewById(R.id.loginFourth_psd_three);
        four = (EditText) findViewById(R.id.loginFourth_psd_four);
        five = (EditText) findViewById(R.id.loginFourth_psd_five);
        six = (EditText) findViewById(R.id.loginFourth_psd_six);
        //
        back = (ImageView) findViewById(R.id.loginFourth_iv_back);
        next = (Button) findViewById(R.id.loginFourth_btn_next);

    }
    private void initListener(){
        one.addTextChangedListener(this);
        two.addTextChangedListener(this);
        three.addTextChangedListener(this);
        four.addTextChangedListener(this);
        five.addTextChangedListener(this);
        six.addTextChangedListener(this);
        //
        two.setOnKeyListener(this);
        three.setOnKeyListener(this);
        four.setOnKeyListener(this);
        five.setOnKeyListener(this);
        six.setOnKeyListener(this);
        //
        back.setOnClickListener(this);
        next.setOnClickListener(this);
        next.setEnabled(false);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.toString().length() == 1) {
            if (one.isFocused()) {
                one.clearFocus();
                two.requestFocus();
                next.setBackgroundResource(R.drawable.button_unable);
                next.setEnabled(false);
            } else if (two.isFocused()) {
                two.clearFocus();
                three.requestFocus();
                next.setBackgroundResource(R.drawable.button_unable);
                next.setEnabled(false);
            } else if (three.isFocused()) {
                three.clearFocus();
                four.requestFocus();
                next.setBackgroundResource(R.drawable.button_unable);
                next.setEnabled(false);
            } else if (four.isFocused()) {
                four.clearFocus();
                five.requestFocus();
                next.setBackgroundResource(R.drawable.button_unable);
                next.setEnabled(false);
            } else if (five.isFocused()) {
                five.clearFocus();
                six.requestFocus();
                next.setBackgroundResource(R.drawable.button_unable);
                next.setEnabled(false);
            } else if (six.isFocused()) {
                next.setBackgroundResource(R.drawable.button_enable);
                next.setEnabled(true);
            }
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginFourth_iv_back:
                onBackPressed();
                break;
            case R.id.loginFourth_btn_next:
                String psd_second = one.getText().toString() + two.getText().toString() + three.getText().toString() + four.getText().toString()
                        + five.getText().toString() + six.getText().toString();
                if (psd_second.equals(psd_first)) {
                    Intent intent = new Intent(this, HomePage.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(this, "您输入的密码有误，请重新输入", Toast.LENGTH_SHORT).show();
                     one.setText(null);
                     two.setText(null);
                     three.setText(null);
                     four.setText(null);
                     five.setText(null);
                     six.setText(null);
                     one.requestFocus();
                }
        }

    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        switch (v.getId()) {
            case R.id.loginFourth_psd_one:
                if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                    one.setText(null);
                    next.setBackgroundResource(R.drawable.button_unable);
                    next.setEnabled(false);
                    return true;
                }
                return false;
            case R.id.loginFourth_psd_two:
                if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                    if(two.getText().toString().length()!=0){
                        two.setText(null);
                        next.setBackgroundResource(R.drawable.button_unable);
                        next.setEnabled(false);
                        return true;
                    }else {
                        one.requestFocus();
                        return true;
                    }
                }
                return false;
            case R.id.loginFourth_psd_three:
                if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                    if(three.getText().toString().length()!=0){
                        three.setText(null);
                        next.setBackgroundResource(R.drawable.button_unable);
                        next.setEnabled(false);
                        return true;
                    }else {
                        two.requestFocus();
                        return true;
                    }
                }
                return false;
            case R.id.loginFourth_psd_four:
                if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                    if(four.getText().toString().length()!=0){
                        four.setText(null);
                        next.setBackgroundResource(R.drawable.button_unable);
                        next.setEnabled(false);
                        return true;
                    }else {
                        three.requestFocus();
                        return true;
                    }
                }
                return false;
            case R.id.loginFourth_psd_five:
                if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                    if(five.getText().toString().length()!=0){
                        five.setText(null);
                        next.setBackgroundResource(R.drawable.button_unable);
                        next.setEnabled(false);
                        return true;
                    }else {
                        four.requestFocus();
                        return true;
                    }
                }
                return false;
            case R.id.loginFourth_psd_six:
                if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                    if(six.getText().toString().length()!=0){
                        six.setText(null);
                        next.setBackgroundResource(R.drawable.button_unable);
                        next.setEnabled(false);
                        return true;
                    }else {
                        five.requestFocus();
                        return true;
                    }
                }
                return false;
        }
        return false;

    }
}
