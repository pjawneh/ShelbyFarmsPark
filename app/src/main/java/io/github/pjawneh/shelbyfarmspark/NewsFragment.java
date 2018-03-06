package io.github.pjawneh.shelbyfarmspark;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pjawneh on 2/23/2018.
 */

public class NewsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;

    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView blogImg;
        private TextView blogTitle;
        private TextView descTitle;

        private ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.news_frag, parent, false));
            blogImg = itemView.findViewById(R.id.newsImg);
            blogTitle = itemView.findViewById(R.id.ruleCat);
            descTitle = itemView.findViewById(R.id.descText);

        }
    }

    /**
     * Adapter to display recycler view per instructions
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 7;
        private final String[] mActivity;
        private final String[] mDescription;
        private final Drawable[] mActivityImg;

        private ContentAdapter(Context context) {
            Resources rsc = context.getResources();
            mActivity = rsc.getStringArray(R.array.blog_titles);
            mDescription = rsc.getStringArray(R.array.blog_desc);
            TypedArray a = rsc.obtainTypedArray(R.array.blog_pics);
            mActivityImg = new Drawable[a.length()];
            for (int i = 0; i < mActivityImg.length; i++){
                mActivityImg[i] = a.getDrawable(i);
            }
            a.recycle();
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.blogImg.setImageDrawable(mActivityImg[position % mActivityImg.length]);
            holder.blogTitle.setText(mActivity[position % mActivity.length]);
            holder.descTitle.setText(mDescription[position % mDescription.length]);
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }
}
