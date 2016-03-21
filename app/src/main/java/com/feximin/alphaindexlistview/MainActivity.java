package com.feximin.alphaindexlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MyListView mListView;
    private BaseAlphaIndexAdapter<Entity> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mListView = (MyListView) findViewById(R.id.list_view);
        TextView txtAlpha = (TextView) findViewById(R.id.txt_alpha);
        this.mAdapter = new AdapterTest(this, txtAlpha);
        this.mListView.setAdapter(mAdapter);
    }
}
