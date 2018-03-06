package io.github.pjawneh.shelbyfarmspark;

import android.content.Context;
import android.content.Intent;
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

public class HomeFragment extends Fragment {
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
        private ImageView activityImg;
        private TextView activityTitle;
        MainActivity mainActivity = new MainActivity();
        Fragment exploreFrag = new ExploreFragment();
        Fragment mapFrag = new MapFragment();
        Fragment joinFrag = new JoinFragment();
        Fragment aboutFrag = new AboutFragment();


        private ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.home_frag, parent, false));
            activityImg = itemView.findViewById(R.id.homeImageView);
            activityTitle = itemView.findViewById(R.id.actionTitle);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();

                    switch (getAdapterPosition()) {
                        case 0: //Explore
                            Intent exploreIntent = new Intent(context, MainActivity.class);
                            context.startActivity(exploreIntent);
                            break;
                        case 1: //Map
                            Intent mapIntent = new Intent(context, MainActivity.class);
                            context.startActivity(mapIntent);
                            break;
                        case 2: //Join
                            Intent joinIntent = new Intent(context, MainActivity.class);
                            context.startActivity(joinIntent);
                            break;
                        case 3: //About
                            Intent aboutIntent = new Intent(context, MainActivity.class);
                            context.startActivity(aboutIntent);
                            break;
                        default:
                            HomeActivity home = new HomeActivity();
                            break;
                    }

                }
            });
        }
    }

    /**
     * Adapter to display recycler view per instructions
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 4;
        private final String[] mActivity;
        private final Drawable[] mActivityImg;

        private ContentAdapter(Context context) {
            Resources rsc = context.getResources();
            mActivity = rsc.getStringArray(R.array.home_actions);
            TypedArray a = rsc.obtainTypedArray(R.array.home_pictures);
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
            holder.activityImg.setImageDrawable(mActivityImg[position % mActivityImg.length]);
            holder.activityTitle.setText(mActivity[position % mActivity.length]);
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }
}
