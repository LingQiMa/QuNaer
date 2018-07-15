package mlq.qunaer;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/12/10.
 */

public class Mine extends Activity implements View.OnClickListener{
    private ImageView back;
    private ListView listView;
    private CircleImageView head;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine);
        init();
        initListener();
        //
    }

    private void init() {
        back = (ImageView) findViewById(R.id.mine_iv_back);
        listView = (ListView) findViewById(R.id.mine_lv_listView);
        listView.setAdapter(new MineAdapter(this,getList()));
        head = (CircleImageView) findViewById(R.id.mine_civ_head);

    }
    private void initListener(){
        back.setOnClickListener(this);
        head.setOnClickListener(this);
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
            case R.id.mine_iv_back:
                onBackPressed();
                break;
            case R.id.mine_civ_head:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
        }
    }
}
