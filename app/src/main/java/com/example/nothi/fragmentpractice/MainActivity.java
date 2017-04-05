package com.example.nothi.fragmentpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TopSectionfragment.TopSectionfragmentCustomListener{
    //using implements TopSectionfragment.TopSectionfragmentCustomListener
    //instead of implements TopSectionfragmentCustomListener,
    // because TopSectionfragmentCustomListener is INSIDE TopSectionfragment


    //INSTEAD OF

   //[ TextView toplineonPic;]
    //[ TextView bottomlineonPic;]

    //and in ON CREATE
    //and  toplineonPic=(TextView)findViewById(R.id.toptextmeme);
    //bottomlineonPic=(TextView)this.findViewById(R.id.bottomtextmeme);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //toplineonPic=(TextView)findViewById(R.id.toptextmeme);
        //bottomlineonPic=(TextView)this.findViewById(R.id.bottomtextmeme);
        //WE JUST use createTexonpic
        //ADDITIONALLY
        //From topfragment onAttach(Context contextfromseedActivity)
        //topfragmentDirector=(TopSectionfragmentCustomListener)contextfromseedActivity;
        //
    }

    @Override
    public void createTextonpic(String top, String bottom) {//from TopSectionfragment.TopSectionfragmentCustomListener
        //    public void buttonClicked(View view){
        //topfragmentDirector concretefiy
        //firstline is foundbyid and secondline is found byid
        //and then the onclicke listener is created

        //onAttach MainActivity has been CASTED to TopSectionfragmentCustomListener topfragmentDirector!!!
        //topfragmentDirector has a createTextonpic that does:
        //topfragmentDirector.createTextonpic(firstline.getText().toString(), secondline.getText().toString());
//
        //SINCE it has been CAST to topfragmentDirector, when it USES createTextonpic in top fragment
        //it gets firstline and second line as agruments

        //now we need the bottom fragment
        //main activiy XML has as fragments TopSection and BottomSection
       //create and use Fragments like Buttons or Views or Widgets
        BottomSectionfragment bottomfrag=(BottomSectionfragment)this.getSupportFragmentManager().findFragmentById(R.id.fragment2);
        //since I didnt brother giving it a name, it is called fragment2
        //it is seen on the activity_main_xml. design
        //now pass in top and bottom
        bottomfrag.setTextonbottomPic(top, bottom); //from TopSectionfragment.TopSectionfragmentCustomListener
        //overriden MainActivity pass argue on to Topfragment
        //  topfragmentDirector.createTextonpic(firstline.getText().toString(), secondline.getText().toString());

        //public void buttonClicked(View view){ and in onclick in set onclicklistner

        //from topfragment onAttach(Context contextfromseedActivity)
        //topfragmentDirector=(TopSectionfragmentCustomListener)contextfromseedActivity;
        //Context can poly into TopSectionfragmentCustomListener?????
        //BECAUSE MainActivity is PASSED TO THE FRAGEMENT!!!!
        //and MAINACTIVITY IS a TopSectionfragmentCustomListener,
        // because Mainactivity implements TopSectionfragmentCustomListener interface!!!!
        //topfragmentDirector.createTextonpic(firstline.getText().toString(), secondline.getText().toString());
        //

    }
}
