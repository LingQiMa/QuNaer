package mlq.qunaer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lenovo on 2017/12/10.
 */

public class MineAdapter extends BaseAdapter {
    private List<Mine_item> list;
    private Context context;

    public MineAdapter(Context context, List<Mine_item> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.mine_list_item, parent, false);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.mine_list_textView);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.mine_list_imageView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        Mine_item mine_item=list.get(position);
        viewHolder.imageView.setImageResource(mine_item.getImageId());
        viewHolder.textView.setText(mine_item.getName());
        return convertView;
    }

    class ViewHolder{
        TextView textView;
        ImageView imageView;
    }
}
