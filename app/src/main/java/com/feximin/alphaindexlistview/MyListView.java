package com.feximin.alphaindexlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neo on 16/2/18.
 */
public class MyListView extends ListView {
    private List<OnScrollListener> mOnScrollListenerList = new ArrayList<>(1);
    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void addOnScrollListener(OnScrollListener l) {
        mOnScrollListenerList.add(l);
    }

    private void init(){
        setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                for(OnScrollListener listener : mOnScrollListenerList){
                    if(listener != null) listener.onScrollStateChanged(view, scrollState);
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                for(OnScrollListener listener : mOnScrollListenerList){
                    if(listener != null) listener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
                }

            }
        });
    }

}
