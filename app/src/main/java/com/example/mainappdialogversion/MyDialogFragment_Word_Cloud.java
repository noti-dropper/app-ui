package com.example.mainappdialogversion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

public class MyDialogFragment_Word_Cloud extends DialogFragment {

    ImageView imageView;





        // this method create view for your Dialog
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            //inflate layout with recycler view
            View v = inflater.inflate(R.layout.fragment_world_cloud, container, false);
            imageView = (ImageView) v.findViewById(R.id.imagewordcloud);
            //서버에서 이미지 가져온후 밑의 메서드로 이미지 설정
            // imageView.setImageBitmap();
            return v;
        }








    }


