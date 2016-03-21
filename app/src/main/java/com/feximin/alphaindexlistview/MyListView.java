package com.feximin.alphaindexlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Neo on 16/2/18.
 */
public class MyListView extends ListView {
    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private TextView mTxtTopAlpha;

    @Override
    public void setAdapter(ListAdapter adapter) {
        if (!(adapter instanceof BaseAlphaIndexAdapter)){
            throw new IllegalArgumentException("adapter should be a sub class of BaseAlphaIndexAdapter");
        }
        this.mTxtTopAlpha = ((BaseAlphaIndexAdapter) adapter).getTopAlphaView();
        super.setAdapter(adapter);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mTxtTopAlpha == null) return;
        if (getAdapter().getCount() <= 1) return;                   //如果只有一个count则不需要考虑
        int firstVisibleItem = getFirstVisiblePosition();           //包含了headerView在内
        int headerCount = getHeaderViewsCount();
        boolean ok = headerCount > 0 && firstVisibleItem < headerCount;    //如果第一条是headerView，mTxtTopAlpha不需要显示
        mTxtTopAlpha.setVisibility(ok?GONE:VISIBLE);
        if (ok) return;
        int height = mTxtTopAlpha.getHeight();
        if(height == 0) return;
        View child = getChildAt(0);
        if(child == null) return;
        AlphaIndexAble cur = (AlphaIndexAble) getAdapter().getItem(firstVisibleItem);
        AlphaIndexAble next = (AlphaIndexAble) getAdapter().getItem(firstVisibleItem + 1);
        String curAlpha = cur.getAlpha();
        String nextAlpha = next.getAlpha();
        int marginTop = 0;
        int bottom = child.getBottom();
        if(!curAlpha.equals(nextAlpha)){
            int m = bottom - height;
            if(m < 0) marginTop = m;
        }
        MarginLayoutParams params = (MarginLayoutParams) mTxtTopAlpha.getLayoutParams();
        if(params.topMargin != marginTop) {
            params.topMargin = marginTop;
            mTxtTopAlpha.requestLayout();
            mTxtTopAlpha.setText(curAlpha);
        }
    }
}
