package vincent.ultimategymapp.listener;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Vincent on 2016-09-08.
 */
public class RecyclerViewItemClickListener implements RecyclerView.OnItemTouchListener{

    /**
     * Un listener pour les items de recycleview
     */
    public interface OnItemClickListener {

        /**
         * Caller quand un item est cliqué
         *
         * @param childView Vue de l'item qui est cliqué.
         * @param position  Position de l'item qui est cliqué.
         */
        void onItemClick(View childView, int position);

        /**
         * Caller quand un item est pressé
         *
         * * @param childView Vue de l'item qui est gardé enfoncé.
         * @param position  Position de l'item qui est gardé enfoncé..
         */
        void onItemLongPress(View childView, int position);
    }

    @Nullable
    private View childView;

    private final OnItemClickListener listener;
    private GestureDetector gestureDetector;
    private int childViewPosition;

    public RecyclerViewItemClickListener(Context context, OnItemClickListener listener) {
        gestureDetector = new GestureDetector(context, new GestureListener());
        this.listener = listener;
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        childView = rv.findChildViewUnder(e.getX(), e.getY());
        childViewPosition = rv.getChildAdapterPosition(childView);

        return childView != null && gestureDetector.onTouchEvent(e);
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        //
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        //
    }

    protected class GestureListener extends GestureDetector.SimpleOnGestureListener {
        // http://developer.android.com/training/gestures/detector.html#detect


        @Override
        public boolean onSingleTapUp(MotionEvent event) {
            if (childView != null) {
                listener.onItemClick(childView, childViewPosition);
            }

            return true;
        }

        @Override
        public void onLongPress(MotionEvent event) {
            if (childView != null) {
                listener.onItemLongPress(childView, childViewPosition);
            }
        }

        @Override
        public boolean onDown(MotionEvent event) {
            return true;
        }
    }
}
