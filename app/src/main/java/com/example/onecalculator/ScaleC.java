package com.example.onecalculator;

import android.content.pm.ActivityInfo;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.text.DecimalFormat;

public class ScaleC extends AppCompatActivity {
  private static final String TAG = "ScaleC";
  private TextView tens;
  private TextView twos;
  private TextView sixteens;
  private Button restart;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scale_c);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    initView();
    initListener();
  }

  private void initListener() {
    restart.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        String stens = tens.getText().toString();
        String stwos = twos.getText().toString();
        String ssixteens = sixteens.getText().toString();
        if (TextUtils.isEmpty(stens)==false||TextUtils.isEmpty(stwos)==false||TextUtils.isEmpty(ssixteens)==false) {
          String str1 = tens.getText().toString();
          String str2 = twos.getText().toString();
          String str3 = sixteens.getText().toString();
          str1=str2=str3;
        }
      }
    });
  }

  private void initView() {
    tens = this.findViewById(R.id.et_tens);
    twos = this.findViewById(R.id.et_twos);
    sixteens= this.findViewById(R.id.et_sixteens);
    restart=this.findViewById(R.id.btn_restart);
    tens.setInputType(EditorInfo.TYPE_CLASS_PHONE);
    twos.setInputType(EditorInfo.TYPE_CLASS_PHONE);
    sixteens.setInputType(EditorInfo.TYPE_CLASS_PHONE);
  }
}

