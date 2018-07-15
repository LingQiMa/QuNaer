package mlq.qunaer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Mine_logged extends AppCompatActivity implements View.OnClickListener{
    private ListView listView;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_logged);
        init();
    }
    private void init() {
        back = (ImageView) findViewById(R.id.mine_logged_iv_back);
        back.setOnClickListener(this);
        listView = (ListView) findViewById(R.id.mine_logged_lv_listView);
        listView.setAdapter(new MineAdapter(this,getList()));

    }
    private List<Mine_item> getList(){
        List<Mine_item> list = new ArrayList<>();
        Mine_item mine_item = new Mine_item(R.mipmap.mine_list_order, "我的订单");
        list.add(mine_item);
        mine_item = new Mine_item(R.mipmap.mine_list_huiyuan,"我的会员");
        list.add(mine_item);
        mine_item = new Mine_item(R.mipmap.mine_list_tuikuan, "我的退款");
        list.add(mine_item);
        mine_item = new Mine_item(R.mipmap.mine_list_fapiao, "我的发票");
        list.add(mine_item);
        return list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mine_logged_iv_back:
                onBackPressed();
                break;
        }
    }
}
