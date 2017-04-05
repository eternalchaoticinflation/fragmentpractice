package com.example.nothi.fragmentpractice;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by nothi on 2017-04-01.
 */

public class TopSectionfragment extends Fragment{//this is a fragment class
    //independently created to make fragment not activity
    //always need to extend frag

    //need Override oncreate view.
    private EditText firstline;
    private EditText secondline;
    private Button  topFragB;
    //instead of creating custom buttons in the main activity, use a interface that just listens for action
    //this way it translates whenever you need to use the fragment
    TopSectionfragmentCustomListener topfragmentDirector;
    public interface TopSectionfragmentCustomListener    {
        public void createTextonpic(String top, String bottom);//interface force to make, meth

    }
    @Override
    public void onAttach(Context contextfromseedActivity){//this is TopSectionfragment class
        super.onAttach(contextfromseedActivity); //onattach activity is depreated???
        //use Context contextfromFrag from Fragment superclass.
        // the Activity the fragment is attached to passes a reference to said Activity on the FRAGMENT.
        //Frag attached to activityM
        //activityM passes reference to fragment through onAttach.
        // attached to. It will be attached to Mainactivity, so onAttach passes a reference to MainActivity
        //to the Fragment!!
        //will be used in the mainactivity later.

        //an call createTextonpic()!!! also overrride.

        try{
            topfragmentDirector=(TopSectionfragmentCustomListener)contextfromseedActivity;//this is mainActivity
            //Context can poly into TopSectionfragmentCustomListener?????
            //BECAUSE MainActivity is PASSED TO THE FRAGEMENT!!!!
            //and MAINACTIVITY IS a TopSectionfragmentCustomListener,
            // because Mainactivity implements TopSectionfragmentCustomListener interface!!!!

        }
        catch(ClassCastException e){
            throw new ClassCastException(contextfromseedActivity.toString());//from object superclass
        }
    }
    @Override
    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup containerfromVG, @Nullable Bundle savedInstanceState) {
        View customfragview=inflater.inflate(R.layout.top_ection_fragment, containerfromVG, false);//inflate means this is what is used for this fragement and for what view

        firstline=(EditText)customfragview.findViewById(R.id.fragmenttopinput);//use our View
        secondline=(EditText)customfragview.findViewById(R.id.fragmenttopinput2);
        topFragB=(Button)customfragview.findViewById(R.id.fragmentbutton);
        //inflate tells view what View IT IS. //what does the false means????
        topFragB.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick (View v){
                        buttonClicked(v);
                    }
                }
        );

        //the arguments it takes are

        ///////////View view=inflater.inflate( R.layout.top_ection_fragment/layout, containerfromVG//ViewGroup, false);//which meanss???
    //now return a view
        return customfragview;

    }
    public void buttonClicked(View view){
        //topfragmentDirector concretefiy
        //firstline is foundbyid and secondline is found byid
        //and then the onclicke listener is created

        //MainActivity has been CASTED to  topfragmentDirector!!!
        topfragmentDirector.createTextonpic(firstline.getText().toString(), secondline.getText().toString());
        //eventually it will be override
        //TopSectionfragmentCustomListener topfragmentDirector an Interface can just exist and
        //and implement this method, like how a superclass exists,
        // i;m sure the class that polymorphs into TopSectionfragmentCustomListener has to be concrete.
        //MainAcitivy is concrete, and polymorphs into TopSectionfragmentCustomListener!!!!!

    }

}
