package com.skypan.helloworld.recyclerview;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.skypan.helloworld.R;

public class PuRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvPu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_recycler_view);
        mRvPu = (RecyclerView) findViewById(R.id.rv_pu);
        mRvPu.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mRvPu.addItemDecoration(new MyDecoration());
        mRvPu.setAdapter(new StaggeredGridAdapter(PuRecyclerViewActivity.this, new StaggeredGridAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(PuRecyclerViewActivity.this,"click:"+pos,Toast.LENGTH_SHORT).show();
            }
        }));
    }

    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap = getResources().getDimensionPixelSize(R.dimen.dividerHeight2);
            outRect.set(gap,gap,gap,gap);
        }
    }
}
