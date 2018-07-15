package mlq.qunaer;

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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher,PickerScrollView.onSelectListener{
    private String[] id;
    private String[] areaId;
    private String[] name;
    private Button next;
    private ImageView back;
    private TextView conutry;
    private TextView conuntryNumber;
    private EditText editText;
    private RelativeLayout picker_rl;
    private PickerScrollView pickerScrollView;
    private ImageView advance;
    private TextView register;
    private Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        initListener();
        initData();
        //
        data = (Data) getApplication();
        data.setA("This is LoginActivity");
        Log.d("data", data.getA());
    }
    private void init(){
        back = (ImageView) findViewById(R.id.login_iv_back);
        conutry = (TextView) findViewById(R.id.login_tv_country);
        conuntryNumber = (TextView) findViewById(R.id.login_tv_countryNumber);
        picker_rl = (RelativeLayout) findViewById(R.id.login_rl_picker);
        picker_rl.setVisibility(View.INVISIBLE);
        next = (Button) findViewById(R.id.login_btn_next);
        next.setEnabled(false);
        editText = (EditText) findViewById(R.id.login_ev_phoneNumber);
        pickerScrollView = (PickerScrollView) findViewById(R.id.login_psv_pickerScrollView);
        advance = (ImageView) findViewById(R.id.login_iv_advance);
        register = (TextView) findViewById(R.id.login_tv_register);

    }
    private void initListener(){
        back.setOnClickListener(this);
        pickerScrollView.setOnSelectListener(this);
        editText.addTextChangedListener(this);
        advance.setOnClickListener(this);
        next.setOnClickListener(this);
        register.setOnClickListener(this);

    }
    //为picker设置数据
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
            case R.id.login_iv_back:
                onBackPressed();
                break;
            case R.id.login_iv_advance:
                if (!picker_rl.isShown()) {
                    picker_rl.setVisibility(View.VISIBLE);
                }else {
                    picker_rl.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.login_btn_next:
                //正则表达式判断是否是手机号
                String number=editText.getText().toString();
                if(isMobileNumber(number)) {
                    Intent intent = new Intent(this, Login_second.class);
                    //传递区号和手机号
                    String s = conuntryNumber.getText().toString() + " " + editText.getText().toString();
                    intent.putExtra("countryAndPhone", s);
                    startActivity(intent);
                }else {
                    Toast.makeText(this, "您输入的不是手机号，请重新输入", Toast.LENGTH_SHORT).show();
                    editText.setText(null);
                }
                break;
            case R.id.login_tv_register:
                Intent intent = new Intent(this, Login_register.class);
                startActivity(intent);
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
            conuntryNumber.setText("+86");
            conutry.setText("中国");

        }
        if(s.equals("美国")){
            conuntryNumber.setText("+01");
            conutry.setText("美国");

        }
        if(s.equals("日本")){
            conuntryNumber.setText("+81");
            conutry.setText("日本");

        }
        if(s.equals("英国")){
            conuntryNumber.setText("+44");
            conutry.setText("英国");

        }
        if(s.equals("德国")){
            conuntryNumber.setText("+349");
            conutry.setText("德国");

        }
        if(s.equals("韩国")){
            conuntryNumber.setText("+82");
            conutry.setText("韩国");

        }
    }
    public static final boolean isMobileNumber(String number){
        Pattern p=Pattern.compile("^1[34578]\\d{9}$");
        Matcher m = p.matcher(number);
        return m.matches();
    }
}
