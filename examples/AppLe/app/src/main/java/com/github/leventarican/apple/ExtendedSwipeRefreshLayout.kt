package com.github.leventarican.apple

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

/**
 * Remember that SwipeRefreshLayout only supports a single ListView or GridView child.
 *
 * override canChildScrollUp() for non-direct views to use nested layouts
 *
 * see also: https://github.com/android/views-widgets-samples/tree/main/SwipeRefreshMultipleViews
 */
class ExtendedSwipeRefreshLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : SwipeRefreshLayout(context, attrs) {

    var viewToScroll: View? = null

    override fun canChildScrollUp(): Boolean {
        return viewToScroll?.canScrollVertically(-1) ?: super.canChildScrollUp()
    }
}