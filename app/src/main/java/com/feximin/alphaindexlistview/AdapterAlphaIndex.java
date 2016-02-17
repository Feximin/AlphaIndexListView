package com.feximin.alphaindexlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neo on 16/2/17.
 */
public class AdapterAlphaIndex extends BaseAdapter {
    private List<String> mData = new ArrayList<>();
    private LayoutInflater mInflater;
    public AdapterAlphaIndex(Context context){
        this.mInflater = LayoutInflater.from(context);
        List<String> data = new ArrayList<>();
        data.add("aao");
        data.add("大");
        data.add("锰");
        data.add("说说说");
        data.add("阿狸");
        data.add("式风");
        data.add("好烦");
        data.add("式不");
        data.add("杨之不");
        data.add(" 朸");
        data.add(" 好的工");
        data.add(" 到艰");
        data.add(" -88梦回");
        data.add("23盞");
        data.add("没有");
        data.add("苯22为");
        data.add("工0");
        data.add("林式");
        data.add("中华人民共和国");
        data.add("唑");
        data.add("炗");
        data.add("35盞");
        data.add("没");
        data.add("外皮");
        data.add("--＝");
        data.add("2 男");
        data.add("仍五");
        data.add("柬辩");
        data.add("东风");
        data.add("哈哈");
        data.add("就这样");
        data.add("没有什么");
        data.add("金星");
        data.add("回忆");
        data.add("轴流风机");
        data.add("胶鞋车");
        data.add("极");
        data.add("攀炎来");
        data.add("枯");
        data.add("耸因");
        data.add("东风");
        data.add("火机");
        data.add("可以用");
        data.add("丁耻");
        data.add("杰曙光");
        data.add("啃尼烟");
        data.add("杭州");
        data.add("小滑");
        data.add("纱");
        data.add("");
        data.add("     ");

        data = Tool.sort(data);
        mData.addAll(data);


    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public String getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) convertView = mInflater.inflate(R.layout.item_list, null);
        TextView txtIndex = (TextView) convertView.findViewById(R.id.txt_alpha);
        TextView txtName = (TextView) convertView.findViewById(R.id.txt_name);
        String name = getItem(position);
        txtName.setText(name);
        boolean showIndex;
        String alpha = convert(Tool.getStringFirstAlpha(name));

        if(position == 0){
            showIndex = true;
        }else{
            String last = convert(Tool.getStringFirstAlpha(getItem(position - 1)));
            showIndex = !alpha.equals(last);
        }
        txtIndex.setText(alpha);
        txtIndex.setVisibility(showIndex?View.VISIBLE:View.GONE);
        return convertView;
    }

    private String convert(String alpha){
        if(!alpha.matches("[A-Z]")) alpha = "#";
        return alpha;
    }
}
