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

public class Run extends AppCompatActivity {
  private static final String TAG = "Run";

  private TextView kmeter;
  private TextView minute;
  private TextView second;
  private TextView answer;
  private Button restart;
  private Button huansuan;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_run);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    initView();
    initListener();
  }

  private void initListener() {
    huansuan.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        String skmeter = kmeter.getText().toString();
        String sminute = minute.getText().toString();
        String ssecond = second.getText().toString();
        if (TextUtils.isEmpty(skmeter)) {
          kmeter.setError("不能为空 ");
          return;
        }
        if (TextUtils.isEmpty(sminute)) {
          minute.setError("不能为空 ");
          return;
        }
        if (TextUtils.isEmpty(ssecond)) {
          second.setError("不能为空 ");
          return;
        }
        restart.setOnClickListener(this);
        int id = v.getId();
        String str1 = kmeter.getText().toString();
        String str2 = minute.getText().toString();
        String str3 = second.getText().toString();
        double num1 = Double.parseDouble(str1);
        double num2 = Double.parseDouble(str2);
        double num3 = Double.parseDouble(str3);
        double num0 = num3 / 60;
        double num4 = (60 / (num2 + num0)) * num1;
        double num5 = num4 / 60;
        double num6 = num5 / 60 * 1000;

        double num7 = 1 / num5;
        int num8 = (int) num7;
        double num9 = (num7 - num8) * 60;
        int num22, num23;
        if (num8 >= 60) {
          num22 = num8 / 60;
          num23 = num8 - num22 * 60;
        } else {
          num22 = 0;
          num23 = num8;
        }

        double num10 = num7 * 5;
        int num11 = (int) num10;
        double num12 = (num10 - num11) * 60;
        int num30, num31;
        if (num11 >= 60) {
          num30 = num11 / 60;
          num31 = num11 - num30 * 60;
        } else {
          num30 = 0;
          num31 = num11;
        }

        double num13 = num7 * 10;
        int num14 = (int) num13;
        double num15 = (num13 - num14) * 60;
        int num28, num29;
        if (num14 >= 60) {
          num28 = num14 / 60;
          num29 = num14 - num28 * 60;
        } else {
          num28 = 0;
          num29 = num14;
        }

        double num16 = num7 * (42.195 / 2);
        int num17 = (int) num16;
        double num18 = (num16 - num17) * 60;
        int num26, num27;
        if (num17 >= 60) {
          num26 = num17 / 60;
          num27 = num17 - num26 * 60;
        } else {
          num26 = 0;
          num27 = num17;
        }

        double num19 = num7 * 42.195;
        int num20 = (int) num19;
        double num21 = (num19 - num20) * 60;
        int num24, num25;
        if (num20 >= 60) {
          num24 = num20 / 60;
          num25 = num20 - num24 * 60;
        } else {
          num24 = 0;
          num25 = num20;
        }
        DecimalFormat df = new DecimalFormat("##0.000");
        DecimalFormat dff = new DecimalFormat("0");
        switch (id) {
          case R.id.btn_huansuan: {
            answer.setText("1公里用时"
                + num22 + "时" + num23 + "分"
                + dff.format(num9)
                + "秒\n"
                + "5公里用时" + num30 + "时"
                + num31
                + "分"
                + dff.format(num12)
                + "秒\n"
                + "10公里用时" + num28 + "时"
                + num29
                + "分"
                + dff.format(num15)
                + "秒\n"
                + "半程马拉松用时" + num26 + "时"
                + num27
                + "分"
                + dff.format(num18)
                + "秒\n"
                + "全程马拉松用时" + num24 + "时"
                + num25
                + "分"
                + dff.format(num21)
                + "秒\n"
                +
                "配速： "
                + df.format(num4)
                + "公里/小时\n"
                + "配速： "
                + df.format(num5)
                + "公里/分\n"
                + "配速： "
                + df.format(num6)
                + "米/秒");
          }
          break;
          case R.id.btn_restart: {
            kmeter.setText("");
            minute.setText("");
            second.setText("");
            answer.setText("");
          }
          break;
        }
      }
    });
  }

  private void initView() {
    kmeter = this.findViewById(R.id.et_kmeter);
    minute = this.findViewById(R.id.et_minute);
    second = this.findViewById(R.id.et_second);
    huansuan = this.findViewById(R.id.btn_huansuan);
    answer = this.findViewById(R.id.tv_answer);
    restart = this.findViewById(R.id.btn_restart);
    kmeter.setInputType(EditorInfo.TYPE_CLASS_PHONE);
    minute.setInputType(EditorInfo.TYPE_CLASS_PHONE);
    second.setInputType(EditorInfo.TYPE_CLASS_PHONE);
  }
}
