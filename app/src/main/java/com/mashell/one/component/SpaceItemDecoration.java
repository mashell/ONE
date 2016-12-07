package com.mashell.one.component;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by mashell on 16/12/7.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public SpaceItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.right = space;
        outRect.top = space;
        outRect.left = space;
        outRect.bottom = space;
    }

}
