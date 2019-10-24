package com.example.mainappdialogversion;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstOpen extends AppCompatActivity {

    public static final int sub = 1001; /*다른 액티비티를 띄우기 위한 요청코드(상수)*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_open);


        //  db로 보낼 like, hate 키워드 스티링에 저장
        EditText editText1 = (EditText) findViewById(R.id.editText_like) ;
        final String keyword_like = editText1.getText().toString() ;

        EditText editText2 = (EditText) findViewById(R.id.editText_hate) ;
        String keyword_hate = editText2.getText().toString() ;





        Button button = (Button)findViewById(R.id.FirstBtn); /*메인 액팁비티로 넘어가는 버튼*/

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(intent, sub);//액티비티 띄우기
                System.out.println(keyword_like);
            }
        });

    }




}
