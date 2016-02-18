package com.feximin.alphaindexlistview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neo on 16/2/18.
 */
public class AdapterTest extends BaseAlphaIndexAdapter<Entity> {
    public AdapterTest(Context context) {
        super(context);
        List<Entity> data = new ArrayList<>();
        data.add(new Entity("aao"));
        data.add(new Entity("大"));
        data.add(new Entity("锰"));
        data.add(new Entity("说说说"));
        data.add(new Entity("阿狸"));
        data.add(new Entity("式风"));
        data.add(new Entity("好烦"));
        data.add(new Entity("式不"));
        data.add(new Entity("杨之不"));
        data.add(new Entity(" 朸"));
        data.add(new Entity(" 好的工"));
        data.add(new Entity(" 到艰"));
        data.add(new Entity(" -88梦回"));
        data.add(new Entity("23盞"));
        data.add(new Entity("没有"));
        data.add(new Entity("苯22为"));
        data.add(new Entity("工0"));
        data.add(new Entity("林式"));
        data.add(new Entity("中华人民共和国"));
        data.add(new Entity("唑"));
        data.add(new Entity("炗"));
        data.add(new Entity("35盞"));
        data.add(new Entity("没"));
        data.add(new Entity("外皮"));
        data.add(new Entity("--＝"));
        data.add(new Entity("2 男"));
        data.add(new Entity("仍五"));
        data.add(new Entity("柬辩"));
        data.add(new Entity("东风"));
        data.add(new Entity("哈哈"));
        data.add(new Entity("就这样"));
        data.add(new Entity("没有什么"));
        data.add(new Entity("金星"));
        data.add(new Entity("回忆"));
        data.add(new Entity("轴流风机"));
        data.add(new Entity("胶鞋车"));
        data.add(new Entity("极"));
        data.add(new Entity("攀炎来"));
        data.add(new Entity("枯"));
        data.add(new Entity("耸因"));
        data.add(new Entity("东风"));
        data.add(new Entity("火机"));
        data.add(new Entity("可以用"));
        data.add(new Entity("丁耻"));
        data.add(new Entity("杰曙光"));
        data.add(new Entity("啃尼烟"));
        data.add(new Entity("杭州"));
        data.add(new Entity("小滑"));
        data.add(new Entity("纱"));
        data.add(new Entity(""));
        data.add(new Entity("     "));

        data = Tool.sort(data);
        mData.addAll(data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) convertView = mInflater.inflate(R.layout.item_list, null);
        TextView txtIndex = (TextView) convertView.findViewById(R.id.txt_alpha);
        TextView txtName = (TextView) convertView.findViewById(R.id.txt_name);
        Entity en = getItem(position);
        txtName.setText(en.getName());
        boolean showIndex;
        String alpha = getItem(position).getAlpha();

        if(position == 0){
            showIndex = true;
        }else{
            String last = getItem(position - 1).getAlpha();
            showIndex = !alpha.equals(last);
        }
        txtIndex.setText(alpha);
        txtIndex.setVisibility(showIndex?View.VISIBLE:View.GONE);
        return convertView;
    }

}
