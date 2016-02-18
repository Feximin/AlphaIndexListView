package com.feximin.alphaindexlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neo on 16/2/17.
 */
public abstract class BaseAlphaIndexAdapter<T extends AlphaIndexAble> extends BaseAdapter {
    protected List<T> mData = new ArrayList<>();
    protected LayoutInflater mInflater;
    public BaseAlphaIndexAdapter(Context context){
        this.mInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
