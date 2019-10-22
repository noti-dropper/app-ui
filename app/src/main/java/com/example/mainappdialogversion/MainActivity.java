package com.example.mainappdialogversion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyDialogFragment_All all = new MyDialogFragment_All();
    MyDialogFragment_Positive positive = new MyDialogFragment_Positive();
    MyDialogFragment_Negative negative = new MyDialogFragment_Negative();


    public void onFragmentInteraction(Uri uri){

    }

    public void onNoteFragmentInteraction(String string){
        //All fragment= All.newInstance("","");



        // update the main content by replacing fragments



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn1Method(View view){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction tran = manager.beginTransaction();
        tran.replace(R.id.container, all);
        MyDialogFragment_All myDialogFragmentAll = new MyDialogFragment_All();
        myDialogFragmentAll.show(manager, "test");
    }


    public void btn2Method(View view){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction tran = manager.beginTransaction();
        tran.replace(R.id.container, positive);
        MyDialogFragment_Positive myDialogFragment_positive = new MyDialogFragment_Positive();
        myDialogFragment_positive.show(manager, "test");



    }


    public void btn3Method(View view){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction tran = manager.beginTransaction();
        tran.replace(R.id.container, negative);
        MyDialogFragment_Negative myDialogFragment_negative = new MyDialogFragment_Negative();
        myDialogFragment_negative.show(manager, "test");

    }




}
