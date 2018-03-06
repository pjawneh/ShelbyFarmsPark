package io.github.pjawneh.shelbyfarmspark;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by pjawneh on 2/23/2018.
 */

public class ExpListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> listHeader;
    private HashMap<String, List<String>> listChild;

    public ExpListAdapter(Context context, List<String> listHeader,
                          HashMap<String, List<String>> listChild){
        this.context = context;
        this.listHeader = listHeader;
        this.listChild = listChild;
    }
    @Override
    public int getGroupCount() {
        return this.listHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listChild.get(this.listHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listChild.get(this.listHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
        View convertView, ViewGroup parent) {
            String headerTitle = (String) getGroup(groupPosition);
            if (convertView == null) {
                LayoutInflater vInflater = (LayoutInflater) this.context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = vInflater.inflate(R.layout.list_group, null);
            }

            TextView listHeaderLBL = convertView.findViewById(R.id.listGroup);
            listHeaderLBL.setText(headerTitle);
            return convertView;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_item, null);
        }

        TextView txtListChild = convertView.findViewById(R.id.listItem);
        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
