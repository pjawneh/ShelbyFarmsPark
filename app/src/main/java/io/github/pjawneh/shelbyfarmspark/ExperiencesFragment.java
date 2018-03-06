package io.github.pjawneh.shelbyfarmspark;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by pjawneh on 2/23/2018.
 */

public class ExperiencesFragment extends Fragment {
    ExpandableListAdapter listAdapter;
    ExpandableListView expandableListView;
    List<String> listHeader;
    HashMap<String, List<String>> listChild;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.experiences_list, container, false);
        expandableListView = mView.findViewById(R.id.expListView);

        prepareListData();

        listAdapter = new ExpListAdapter(getActivity(), listHeader,listChild);
        expandableListView.setAdapter(listAdapter);

        return mView;
    }

    private void prepareListData() {
        listHeader = new ArrayList<>();
        listChild = new HashMap<>();

        //Headers
        listHeader.add("For Kids");
        listHeader.add("On Foot");
        listHeader.add("On Wheels");
        listHeader.add("On Horseback");
        listHeader.add("In The Trees");
        listHeader.add("For Dogs");
        listHeader.add("On The Water");
        listHeader.add("In The Open");
        listHeader.add("For Your Tastebuds");
        listHeader.add("ADA Access");

        //Child data
        List<String> forKids = new ArrayList<>();
        forKids.add("Woodland Discovery Playground");
        forKids.add("Water Play Sprayground");

        List<String> onFoot = new ArrayList<>();
        onFoot.add("Trails");
        onFoot.add("Shelby Farms Greenline");

        List<String> onWheels = new ArrayList<>();
        onWheels.add("Shelby Farms Greenline");
        onWheels.add("Bike Rentals");
        onWheels.add("Bike Repair Stations");
        onWheels.add("BMX Track");

        List<String> theWater = new ArrayList<>();
        theWater.add("Boat + Board Rentals");
        theWater.add("Bring Your Own Boat");
        theWater.add("Fishing");

        List<String> theOpen = new ArrayList<>();
        theOpen.add("Disk Golf");
        theOpen.add("Paintball + Laser Tag");

        listChild.put(listHeader.get(0), forKids);
        listChild.put(listHeader.get(1), onFoot);
        listChild.put(listHeader.get(2), onWheels);
        listChild.put(listHeader.get(3), theWater);
        listChild.put(listHeader.get(4), theOpen);
    }
}
