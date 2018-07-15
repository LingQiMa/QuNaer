package mlq.qunaer;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Order extends AppCompatActivity implements View.OnClickListener {
    private ImageView back;
    private Button login;
    private Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);
        getSupportActionBar().hide();
        init();
        initListener();
        //
        data = (Data) getApplication();
        data.setA("This is Order");
        Log.d("data", data.getA());
    }
    private void init(){
        back = (ImageView) findViewById(R.id.order_iv_back);
        login = (Button) findViewById(R.id.od_btn_login);
    }
    private void initListener(){
        back.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.order_iv_back:
                onBackPressed();
                break;
            case R.id.od_btn_login:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
        }
    }
}
