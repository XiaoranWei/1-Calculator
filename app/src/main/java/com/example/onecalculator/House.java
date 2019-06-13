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

public class House extends AppCompatActivity {

  private static final String TAG = "House";
  private TextView moneyw;
  private TextView yeary;
  private TextView ir;
  private Button huansuan;
  private TextView answer;
  private Button restart;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_house);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    initView();
    initListener();
  }

  private void initListener() {
    huansuan.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        String smoneyw = moneyw.getText().toString();
        String syeary = yeary.getText().toString();
        String sir = ir.getText().toString();
        if (TextUtils.isEmpty(smoneyw)) {
          moneyw.setError("不能为空 ");
          return;
        }
        if (TextUtils.isEmpty(syeary)) {
          yeary.setError("不能为空 ");
          return;
        }
        if (TextUtils.isEmpty(sir)) {
          ir.setError("不能为空 ");
          return;
        }
        restart.setOnClickListener(this);
        int id = v.getId();
        String str1 = moneyw.getText().toString();
        String str2 = yeary.getText().toString();
        String str3 = ir.getText().toString();
        double num1 = Double.parseDouble(str1);
        double num2 = Double.parseDouble(str2);
        double num3 = Double.parseDouble(str3);
        double num4 = num1 * 10000;
        double num5 = num2 * 12;
        double num6 = num3 * 0.01;
        double num7 = Math.pow(1 + num6 / 12, num5);
        double num8 = ((num4 * (num3 / 12) * num7) / (num7 - 1)) / 100;
        double num9 = num8 * num5;
        double num10 = num9 - num4;
        DecimalFormat df = new DecimalFormat("##0.000");
        switch (id) {
          case R.id.btn_huansuan: {
            answer.setText(
                "贷款总额：" + num4 + "\n" + "还款总额:" + df.format(num9) + "\n" + "支付利息:" + df.format(
                    num10) + "\n" + "贷款月数:" + num5 + "\n" + "月均还款:" + df.format(num8));
          }
          break;
          case R.id.btn_restart: {
            moneyw.setText("");
            yeary.setText("");
            ir.setText("");
            answer.setText("");
          }
          break;
        }
      }
    });
  }

  private void initView() {
    moneyw = this.findViewById(R.id.et_moneyw);
    yeary = this.findViewById(R.id.et_yeary);
    ir = this.findViewById(R.id.et_ir);
    huansuan = this.findViewById(R.id.btn_huansuan);
    answer = this.findViewById(R.id.tv_answer);
    restart = this.findViewById(R.id.btn_restart);
    moneyw.setInputType(EditorInfo.TYPE_CLASS_PHONE);
    yeary.setInputType(EditorInfo.TYPE_CLASS_PHONE);
    ir.setInputType(EditorInfo.TYPE_CLASS_PHONE);
  }
}
