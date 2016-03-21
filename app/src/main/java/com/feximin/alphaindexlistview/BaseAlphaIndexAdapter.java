package com.feximin.alphaindexlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neo on 16/2/17.
 */
public abstract class BaseAlphaIndexAdapter<T extends AlphaIndexAble> extends BaseAdapter {
    protected List<T> mData = new ArrayList<>();
    private TextView mTxtTopAlpha;
    protected LayoutInflater mInflater;
    public BaseAlphaIndexAdapter(Context context, TextView topAlpha){
        this.mInflater = LayoutInflater.from(context);
        this.mTxtTopAlpha = topAlpha;
    }
    public TextView getTopAlphaView(){
        return this.mTxtTopAlpha;
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
