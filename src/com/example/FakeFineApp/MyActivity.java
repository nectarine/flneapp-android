package com.example.FakeFineApp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MyActivity extends Activity
{

    AlertDialog dialog;
            /**
             * Called when the activity is first created.
             */
    @Override
    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        TextView textView = new TextView(this);
        textView.setText("가짜 앱입니다. 이 앱은 정부의 말도 안되는 보안 정책에 항의하기 위해 만들어졌습니다");
        builder.setView(textView);
        dialog = builder.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialog.dismiss();
                finish();
            }
        }).setNegativeButton("정보 보기", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.flneapps.co.kr/download.html")));
                finish();
            }
        }).create();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!dialog.isShowing()){
                    dialog.show();
                }
            }
        }, 2000);
    }

}
