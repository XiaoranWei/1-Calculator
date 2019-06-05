package com.example.onecalculator;

import android.content.res.Configuration;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private static final String TAG = "MainActivity";
  private TextView result;
  private TextView clear;
  private TextView positiveornegative;
  private TextView divide;
  private TextView percent;
  private TextView seven;
  private TextView eight;
  private TextView nine;
  private TextView time;
  private TextView four;
  private TextView five;
  private TextView six;
  private TextView minus;
  private TextView one;
  private TextView two;
  private TextView three;
  private TextView plus;
  private TextView zero;
  private TextView point;
  private TextView equal;

  boolean empty;
  double num1, num2, num5, num8;
  String symbol;
  private GestureDetector Detector;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

    initView();
    initClick();
    result.setText("0");
    Detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
      @Override
      public boolean onDown(MotionEvent e) {
        return false;
      }

      @Override
      public void onShowPress(MotionEvent e) {

      }

      @Override
      public boolean onSingleTapUp(MotionEvent e) {
        return false;
      }

      @Override
      public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
      }

      @Override
      public void onLongPress(MotionEvent e) {

      }

      @Override
      public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        String s = result.getText().toString();
        if (result.getText() == "click \"+\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"—\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"x\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"÷\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "please restart") {
          result.setText("please restart");
        } else if ((e1.getX() - e2.getX()) > 50 || (e2.getX() - e1.getX()) > 50) {
          if (result.getText() == "0") {
            result.setText("please restart");
          } else {
            result.setText(s.substring(0, s.length() - 1));
          }
          if (s.length() == 1) {
            result.setText("0");
          }
        }
        return false;
      }
    });
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    return Detector.onTouchEvent(event);
  }

  @Override public void onConfigurationChanged (Configuration newConfig){
    super.onConfigurationChanged(newConfig);
    setContentView(R.layout.activity_main);
    initView();
    initClick();
    result.setText("0");
  }



  private void initView() {
    result = this.findViewById(R.id.tv_result);
    clear = this.findViewById(R.id.tv_clear);
    positiveornegative = this.findViewById(R.id.tv_positiveornegative);
    percent = this.findViewById(R.id.tv_percent);
    divide = this.findViewById(R.id.tv_divide);
    seven = this.findViewById(R.id.tv_seven);
    eight = this.findViewById(R.id.tv_eight);
    nine = this.findViewById(R.id.tv_nine);
    time = this.findViewById(R.id.tv_time);
    four = this.findViewById(R.id.tv_four);
    five = this.findViewById(R.id.tv_five);
    six = this.findViewById(R.id.tv_six);
    minus = this.findViewById(R.id.tv_minus);
    one = this.findViewById(R.id.tv_one);
    two = this.findViewById(R.id.tv_two);
    three = this.findViewById(R.id.tv_three);
    plus = this.findViewById(R.id.tv_plus);
    zero = this.findViewById(R.id.tv_zero);
    point = this.findViewById(R.id.tv_point);
    equal = this.findViewById(R.id.tv_equal);
  }

  private void initClick() {
    clear.setOnClickListener(this);
    positiveornegative.setOnClickListener(this);
    divide.setOnClickListener(this);
    percent.setOnClickListener(this);
    seven.setOnClickListener(this);
    eight.setOnClickListener(this);
    nine.setOnClickListener(this);
    time.setOnClickListener(this);
    four.setOnClickListener(this);
    five.setOnClickListener(this);
    six.setOnClickListener(this);
    minus.setOnClickListener(this);
    one.setOnClickListener(this);
    two.setOnClickListener(this);
    three.setOnClickListener(this);
    plus.setOnClickListener(this);
    zero.setOnClickListener(this);
    point.setOnClickListener(this);
    equal.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    int id = v.getId();
    String str = result.getText().toString();
    switch (id) {
      case R.id.tv_clear: {
        if (empty) {
          empty = false;
        }
        str = "";
        result.setText("0");
      }
      break;
      case R.id.tv_positiveornegative: {
        if (result.getText() == "") {
          result.setText("please restart");
        } else if (result.getText() == "click \"+\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"—\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"x\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"÷\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "please restart") {
          result.setText("please restart");
        } else {
          num5 = Double.parseDouble(str);
          getPositiveornegative();
        }
      }
      break;
      case R.id.tv_percent: {
        if (result.getText() == "") {
          result.setText("please restart");
        } else if (result.getText() == "click \"+\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"—\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"x\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"÷\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "please restart") {
          result.setText("please restart");
        } else {
          num8 = Double.parseDouble(str);
          getPercent();
        }
      }
      break;
      case R.id.tv_divide: {
        if (result.getText() == "") {
          result.setText("click \"÷\" twice, please restart");
        } else if (result.getText() == "click \"+\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"—\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"x\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"÷\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "please restart") {
          result.setText("please restart");
        } else if (result.getText() != "") {
          num1 = Double.parseDouble(str);
          symbol = "÷";
          result.setText("");
        }
      }
      break;
      case R.id.tv_seven:
      case R.id.tv_eight:
      case R.id.tv_nine:
      case R.id.tv_four:
      case R.id.tv_five:
      case R.id.tv_six:
      case R.id.tv_one:
      case R.id.tv_two:
      case R.id.tv_three: {
        if (result.getText() == "click \"+\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"—\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"x\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"÷\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "please restart") {
          result.setText("please restart");
        } else {
          if (empty) {
            empty = false;
            str = "";
            result.setText("");
          }
          if (result.getText() == "0") {
            result.setText(((TextView) v).getText());
          } else {
            result.setText(str + ((TextView) v).getText());
          }
        }
      }
      break;
      case R.id.tv_time: {
        if (result.getText() == "") {
          result.setText("click \"x\" twice, please restart");
        } else if (result.getText() == "click \"+\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"—\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"x\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"÷\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "please restart") {
          result.setText("please restart");
        } else if (result.getText() != "") {
          num1 = Double.parseDouble(str);
          symbol = "x";
          result.setText("");
        }
      }
      break;
      case R.id.tv_minus: {
        if (result.getText() == "") {
          result.setText("click \"—\" twice, please restart");
        } else if (result.getText() == "click \"+\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"—\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"x\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"÷\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "please restart") {
          result.setText("please restart");
        } else if (result.getText() != "") {
          num1 = Double.parseDouble(str);
          symbol = "—";
          result.setText("");
        }
      }
      break;
      case R.id.tv_plus: {
        if (result.getText() == "") {
          result.setText("click \"+\" twice, please restart");
        } else if (result.getText() == "click \"+\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"—\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"x\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"÷\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "please restart") {
          result.setText("please restart");
        } else if (result.getText() != "") {
          num1 = Double.parseDouble(str);
          symbol = "+";
          result.setText("");
        }
      }
      break;
      case R.id.tv_zero: {
        if (result.getText() == "click \"+\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"—\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"x\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"÷\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "please restart") {
          result.setText("please restart");
        } else {
          if (empty) {
            empty = false;
            str = "";
            result.setText("");
          }
          if (result.getText() == "0") {
            result.setText(((TextView) v).getText());
          } else {
            result.setText(str + ((TextView) v).getText());
          }
        }
      }
      break;
      case R.id.tv_point: {
        if (result.getText() == "click \"+\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"—\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"x\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"÷\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "please restart") {
          result.setText("please restart");
        } else {
          if (empty) {
            empty = false;
            str = "";
            result.setText("");
          }
          result.setText(str + ((TextView) v).getText());
        }
      }
      break;
      case R.id.tv_equal: {
        if (result.getText() == "click \"+\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"—\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"x\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "click \"÷\" twice, please restart") {
          result.setText("please restart");
        } else if (result.getText() == "please restart") {
          result.setText("please restart");
        } else {
          num2 = Double.parseDouble(str);
          getResult();
        }
      }
      break;
    }
  }

  public void getPositiveornegative() {
    double num6 = 0 - num5;
    int num7;
    if (num6 % 1 == 0) {
      num7 = (int) num6;
      result.setText("" + num7);
    } else {
      result.setText("" + num6);
    }
  }

  public void getPercent() {
    double num9;
    num9 = num8 / 100;
    result.setText("" + num9);
  }

  public void getResult() {
    double num3;
    int num4;
    if (symbol == "÷") {
      num3 = num1 / num2;
    } else if (symbol == "x") {
      num3 = num1 * num2;
    } else if (symbol == "—") {
      num3 = num1 - num2;
    } else if (symbol == "+") {
      num3 = num1 + num2;
    } else {
      num3 = 0;
    }

    if (num3 % 1 == 0) {
      num4 = (int) num3;
      result.setText("" + num4);
    } else {
      result.setText("" + num3);
    }
  }
}