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
  private TextView eights;
  private TextView sixteens;
  private Button restart;
  private Button huansuan;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scale_c);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    initView();
    initListener();
  }

  private void initListener() {
    huansuan.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        restart.setOnClickListener(this);
        String stwos = twos.getText().toString();
        String seights = eights.getText().toString();
        String stens = tens.getText().toString();
        String ssixteens = sixteens.getText().toString();
        String temp = null, num1 = null, num2 = null, num3 = null, num4 = null;
        int id = v.getId();
        switch (id) {
          case R.id.btn_huansuan: {
            if (TextUtils.isEmpty(stwos) == false) {
              temp = twos.getText().toString();
              num3 = Integer.valueOf(temp, 2).toString();
              num2 = Integer.toOctalString(Integer.parseInt(num3));
              num4 = Integer.toHexString(Integer.parseInt(num3));
              eights.setText(num2);
              tens.setText(num3);
              sixteens.setText(num4.toUpperCase());
            } else if (TextUtils.isEmpty(seights) == false) {
              temp = eights.getText().toString();
              num3 = Integer.valueOf(temp, 8).toString();
              num1 = Integer.toBinaryString(Integer.parseInt(num3));
              num4 = Integer.toHexString(Integer.parseInt(num3));
              twos.setText(num1);
              tens.setText(num3);
              sixteens.setText(num4.toUpperCase());
            } else if (TextUtils.isEmpty(stens) == false) {
              num3 = tens.getText().toString();
              num1 = Integer.toBinaryString(Integer.parseInt(num3));
              num2 = Integer.toOctalString(Integer.parseInt(num3));
              num4 = Integer.toHexString(Integer.parseInt(num3));
              twos.setText(num1);
              eights.setText(num2);
              sixteens.setText(num4.toUpperCase());
            } else if (TextUtils.isEmpty(ssixteens) == false) {
              temp = sixteens.getText().toString();
              num3 = Integer.valueOf(temp, 16).toString();
              num1 = Integer.toBinaryString(Integer.parseInt(num3));
              num2 = Integer.toOctalString(Integer.parseInt(num3));
              twos.setText(num1);
              eights.setText(num2);
              tens.setText(num3);
              sixteens.setText(temp.toUpperCase());
            }
          }
          break;
          case R.id.btn_restart: {
            twos.setText("");
            eights.setText("");
            tens.setText("");
            sixteens.setText("");
          }
          break;
        }
      }
    });
  }

  private void initView() {
    tens = this.findViewById(R.id.et_tens);
    twos = this.findViewById(R.id.et_twos);
    eights = this.findViewById(R.id.et_eights);
    sixteens = this.findViewById(R.id.et_sixteens);
    restart = this.findViewById(R.id.btn_restart);
    huansuan = this.findViewById(R.id.btn_huansuan);
    tens.setInputType(EditorInfo.TYPE_CLASS_PHONE);
    twos.setInputType(EditorInfo.TYPE_CLASS_PHONE);
    eights.setInputType(EditorInfo.TYPE_CLASS_PHONE);
    //sixteens.setInputType(EditorInfo.TYPE_CLASS_PHONE);
  }
}

