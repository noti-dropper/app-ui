package com.example.mainappdialogversion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import Dialog.MyDialogFragment_All;
import Dialog.MyDialogFragment_Negative;
import Dialog.MyDialogFragment_Positive;

public class MainActivity extends AppCompatActivity {

    MyDialogFragment_All all = new MyDialogFragment_All();
    MyDialogFragment_Positive positive = new MyDialogFragment_Positive();
    MyDialogFragment_Negative negative = new MyDialogFragment_Negative();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 모든 알림 보여주는 버튼

    public void btn1Method(View view){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction tran = manager.beginTransaction();
        tran.replace(R.id.container, all);
        MyDialogFragment_All myDialogFragmentAll = new MyDialogFragment_All();
        myDialogFragmentAll.show(manager, "test");
    }


    // 선호 알림 보여주는 버튼


    public void btn2Method(View view){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction tran = manager.beginTransaction();
        tran.replace(R.id.container, positive);
        MyDialogFragment_Positive myDialogFragment_positive = new MyDialogFragment_Positive();
        myDialogFragment_positive.show(manager, "test");



    }



    // 비선호 알림 보여주는 버튼


    public void btn3Method(View view){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction tran = manager.beginTransaction();
        tran.replace(R.id.container, negative);
        MyDialogFragment_Negative myDialogFragment_negative = new MyDialogFragment_Negative();
        myDialogFragment_negative.show(manager, "test");

    }



}
