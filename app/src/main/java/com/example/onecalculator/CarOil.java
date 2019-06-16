package com.example.onecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.pm.ActivityInfo;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.text.DecimalFormat;

public class CarOil extends AppCompatActivity {
  private static final String TAG = "CarOil";

  private TextView kkmeter;
  private TextView liter;
  private TextView yuan;
  private TextView answer;
  private Button restart;
  private Button huansuan;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_car_oil);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    initView();
    initListener();
  }

  private void initListener() {
    huansuan.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        String skkmeter = kkmeter.getText().toString();
        String sliter = liter.getText().toString();
        String syuan = yuan.getText().toString();
        if (TextUtils.isEmpty(skkmeter)) {
          kkmeter.setError("不能为空 ");
          return;
        }
        if (TextUtils.isEmpty(sliter)) {
          liter.setError("不能为空 ");
          return;
        }
        if (TextUtils.isEmpty(syuan)) {
          yuan.setError("不能为空 ");
          return;
        }
        restart.setOnClickListener(this);
        int id = v.getId();
        String str1 = kkmeter.getText().toString();
        String str2 = liter.getText().toString();
        String str3 = yuan.getText().toString();
        double num1 = Double.parseDouble(str1);
        double num2 = Double.parseDouble(str2);
        double num3 = Double.parseDouble(str3);
        DecimalFormat df = new DecimalFormat("0.00");
        double num4 = num1 / num2;
        double num5 = num2 / num1;
        double num6 = num5 * num3;
        switch (id) {
          case R.id.btn_huansuan: {
            answer.setText("每公升油跑："
                + df.format(num4)
                + "公里\n"
                + "每一公里需"
                + df.format(num5)
                + "公升\n"
                + "每一公里需"
                + df.format(num6)
                + "元");
          }
          break;
          case R.id.btn_restart: {
            kkmeter.setText("");
            liter.setText("");
            yuan.setText("");
            answer.setText("");
          }
          break;
        }
      }
    });
  }

  private void initView() {
    kkmeter = this.findViewById(R.id.et_kkmeter);
    liter = this.findViewById(R.id.et_liter);
    yuan = this.findViewById(R.id.et_yuan);
    huansuan = this.findViewById(R.id.btn_huansuan);
    answer = this.findViewById(R.id.tv_answer);
    restart = this.findViewById(R.id.btn_restart);
    kkmeter.setInputType(EditorInfo.TYPE_CLASS_PHONE);
    liter.setInputType(EditorInfo.TYPE_CLASS_PHONE);
    yuan.setInputType(EditorInfo.TYPE_CLASS_PHONE);
  }
}
