package mlq.qunaer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Order_logged extends AppCompatActivity implements View.OnClickListener{
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_logged);
        init();
        initListener();
    }
    private void init(){
        back = (ImageView) findViewById(R.id.order_logged_iv_back);
    }
    private void initListener(){
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.order_logged_iv_back:
                onBackPressed();
                break;
        }
    }
}
