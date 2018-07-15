package mlq.qunaer;

import android.content.Intent;
import android.net.sip.SipAudioCall;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static mlq.qunaer.LoginActivity.isMobileNumber;

/**
 * Created by lenovo on 2017/12/26.
 */

public class Login_register extends AppCompatActivity implements View.OnClickListener,TextWatcher,PickerScrollView.onSelectListener{
    private ImageView back;
    private ImageView advance;
    private TextView country;
    private TextView countryNumber;
    private EditText editText;
    private Button next;
    private RelativeLayout piker_rl;
    private PickerScrollView pickerScrollView;
    private String[] id;
    private String[] areaId;
    private String[] name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        init();
        initListener();
        initData();

    }

    private void init(){
        back = (ImageView) findViewById(R.id.login_register_iv_back);
        advance = (ImageView) findViewById(R.id.login_register_iv_advance);
        country = (TextView) findViewById(R.id.login_register_tv_country);
        countryNumber = (TextView) findViewById(R.id.login_register_tv_countryNumber);
        editText = (EditText) findViewById(R.id.login_register_ev_phoneNumber);
        next = (Button) findViewById(R.id.login_register_btn_next);
        piker_rl = (RelativeLayout) findViewById(R.id.login_register_rl_picker);
        piker_rl.setVisibility(View.INVISIBLE);
        pickerScrollView = (PickerScrollView) findViewById(R.id.login_register_psv_pickerScrollView);
    }
    private void initListener(){
        back.setOnClickListener(this);
        advance.setOnClickListener(this);
        next.setOnClickListener(this);
        editText.addTextChangedListener(this);
        pickerScrollView.setOnSelectListener(this);
    }
    private void initData(){
        List<Pickers> list = new ArrayList<>();
        id = new String[]{"1", "2", "3", "4", "5", "6"};
        name = new String[]{"中国", "美国", "日本", "英国", "德国", "韩国"};
        areaId=new String[]{"86","01","81","44","349","82"};
        for (int i=0;i<name.length;i++){
            list.add(new Pickers(name[i],id[i]));
        }
        //设置数据，默认选择第一条
        pickerScrollView.setData(list);
        pickerScrollView.setSelected(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_register_iv_back:
                onBackPressed();
                break;
            case R.id.login_register_iv_advance:
                if (!piker_rl.isShown()) {
                    piker_rl.setVisibility(View.VISIBLE);
                }else {
                    piker_rl.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.login_register_btn_next:
                //正则表达式判断是否是手机号
                String number=editText.getText().toString();
                if(isMobileNumber(number)) {
                    Intent intent = new Intent(this, Login_second.class);
                    //传递区号和手机号
                    String s = countryNumber.getText().toString() + " " + editText.getText().toString();
                    intent.putExtra("countryAndPhone", s);
                    startActivity(intent);
                }else {
                    Toast.makeText(this, "您输入的不是手机号，请重新输入", Toast.LENGTH_SHORT).show();
                    editText.setText(null);
                }
                break;

        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (editText.getText().length() == 11) {
            next.setBackgroundResource(R.drawable.button_enable);
            next.setEnabled(true);
        }else {
            next.setBackgroundResource(R.drawable.button_unable);
            next.setEnabled(false);
        }
    }
    private String s;
    @Override
    public void onSelect(Pickers pickers) {
        s=pickers.getShowConetnt().toString().trim();
        if(s.equals("中国")){
            countryNumber.setText("+86");
            country.setText("中国");

        }
        if(s.equals("美国")){
            countryNumber.setText("+01");
            country.setText("美国");

        }
        if(s.equals("日本")){
            countryNumber.setText("+81");
            country.setText("日本");

        }
        if(s.equals("英国")){
            countryNumber.setText("+44");
            country.setText("英国");

        }
        if(s.equals("德国")){
            countryNumber.setText("+349");
            country.setText("德国");

        }
        if(s.equals("韩国")){
            countryNumber.setText("+82");
            country.setText("韩国");

        }
    }
}
