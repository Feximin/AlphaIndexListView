package com.feximin.alphaindexlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private TextView mTxtAlpha;
    private BaseAlphaIndexAdapter<Entity> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mListView = (ListView) findViewById(R.id.list_view);
        this.mTxtAlpha = (TextView) findViewById(R.id.txt_alpha);
        TextView txt = new TextView(this);
        txt.setTextSize(30);
        txt.setText("Header");
//        this.mListView.addHeaderView(txt);
        this.mAdapter = new AdapterTest(this);
        this.mListView.setAdapter(mAdapter);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int height = mTxtAlpha.getHeight();
                if(height == 0) return;
                View child = view.getChildAt(0);
                if(child == null) return;
                Entity cur = mAdapter.getItem(firstVisibleItem);
                Entity next = mAdapter.getItem(firstVisibleItem + 1);
                String curAlpha = cur.getAlpha();
                String nextAlpha = next.getAlpha();
                int marginTop = 0;
                int bottom = child.getBottom();
                if(!curAlpha.equals(nextAlpha)){
                    int m = bottom - height;
                    if(m < 0) marginTop = m;
                }
                MarginLayoutParams params = (MarginLayoutParams) mTxtAlpha.getLayoutParams();
                if(params.topMargin != marginTop) {
                    params.topMargin = marginTop;
                    mTxtAlpha.requestLayout();
                    mTxtAlpha.setText(curAlpha);
                }
            }
        });
    }
}
