package com.example.mainappdialogversion;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import Dialog.MyDialogFragment_All;
import Dialog.MyDialogFragment_Negative;
import Dialog.MyDialogFragment_Positive;

public class MainActivity extends AppCompatActivity {

    MyDialogFragment_All all = new MyDialogFragment_All();
    MyDialogFragment_Positive positive = new MyDialogFragment_Positive();
    MyDialogFragment_Negative negative = new MyDialogFragment_Negative();


    ImageView WordCloudImg;
    ProgressBar progressBar;
    String TAG = "오류";



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG, "1");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        Log.d(TAG, "2");
        WordCloudImg = (ImageView) findViewById(R.id.WordCloudImg);
        progressBar = (ProgressBar) findViewById(R.id.loading_wordcloudimg);


        Log.d(TAG, "3");
        String url = "http://noti-drawer.run.goorm.io/api/get-wordcloud";
        String jsonData = "{\"안드로이드\": 7,\n" +
                "\"앱\": 6,\n" +
                "\"전역\": -4,\n" +
                "\"태블릿\": -2," +
                "\"커피\": -2}";
        Log.d(TAG, "4");
        GetImageAsync getImg = new GetImageAsync(url, jsonData);
        Log.d(TAG, "5");
        getImg.execute();
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

    public class GetImageAsync extends AsyncTask<Void, Void, Bitmap> {

        String url;
        String jsonData;

        // Constructor
        public GetImageAsync(String url, String jsonData) {
            this.jsonData = jsonData;
            this.url = url;
        }

        @Override
        protected Bitmap doInBackground(Void... voids) {
            // 비동기 처리 후 결과값을 리턴
            // 이 메소드가 끝난 후에 onPostExecute()가 실행됨
            return new ApiCommUtil().requestImg(url, jsonData);
            // :TODO: 이미지 가져오는 부분
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            super.onPostExecute(result);
            // 서버 통신 후 처리 완료
            // 받아온 값은 result에 저장되며 JSON 타입으로 저장됨
            // 올바르지 못한 값을 받아왔을 때, 빈 String 값이 나옴

            if (result==null) {


            }


            else {

                WordCloudImg.setImageBitmap(result);
                progressBar.setVisibility(View.GONE);
            }

        }
    }



}
