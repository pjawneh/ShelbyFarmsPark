package io.github.pjawneh.shelbyfarmspark;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by pjawneh on 2/28/2018.
 */

public class RulesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //private TextView ruleTitle;
        private TextView descText;

        private ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.rules_frag, parent, false));
            //ruleTitle = itemView.findViewById(R.id.ruleCat);
            descText = itemView.findViewById(R.id.ruleText);

        }
    }

    /**
     * Adapter to display recycler view per instructions
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 7;
        //private final String[] ruleCategory;
        private final String[] mDescription;

        private ContentAdapter(Context context) {
            Resources rsc = context.getResources();
            //ruleCategory = rsc.getStringArray(R.array.rule_titles);
            mDescription = rsc.getStringArray(R.array.rule_desc);
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            //holder.ruleTitle.setText(ruleCategory[position % ruleCategory.length]);
            holder.descText.setText(mDescription[position % mDescription.length]);
        }

        @Override
        public int getItemCount() {
            return mDescription.length;
        }
    }
}
