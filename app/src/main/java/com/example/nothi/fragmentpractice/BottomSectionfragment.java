package com.example.nothi.fragmentpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by nothi on 2017-04-01.
 */



import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by nothi on 2017-04-01.
 */

public class BottomSectionfragment extends Fragment {//this is a fragment class
    //independently created to make fragment not activity
    //always need to extend frag

    //need Override oncreate view.
    TextView toplineonPicinF;

    TextView bottomlineonPicinF;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup containerfromVG, @Nullable Bundle savedInstanceState) {
        View customfragview = inflater.inflate(R.layout.picture_fragment, containerfromVG, false);//inflate means this is what is used for this fragement and for what view
        //inflate tells view what View IT IS. //what does the false means????

        //the arguments it takes are

        toplineonPicinF = (TextView) customfragview.findViewById(R.id.toptextmeme);
        //NOTE:  toplineonPicinF=(TextView)findViewById(R.id.toptextmeme); doesn't work!
        // because we are a fragement we don't have this.findViewById, we are not a View!!!
        bottomlineonPicinF = (TextView) customfragview.findViewById(R.id.bottomtextmeme);

        ///////////View view=inflater.inflate( R.layout.top_ection_fragment/layout, containerfromVG//ViewGroup, false);//which meanss???
        //now return a view
        return customfragview;

    }


    public void setTextonbottomPic(String top, String bottom) {
    //id are assigned onCreate
        toplineonPicinF.setText(top);
        bottomlineonPicinF.setText(bottom);
    }
}