package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity {
    private Button calculatorButton;
    private EditText weightEditText;
    private RadioButton manRadioButton;
    private RadioButton womanRadioButton;
    private TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculatorButton= (Button) findViewById(R.id.calculator);
        weightEditText = (EditText) findViewById(R.id.weight);
        manRadioButton = (RadioButton) findViewById(R.id.man);
        womanRadioButton = (RadioButton) findViewById(R.id.woman);
        resultTextView = (TextView) findViewById(R.id.result);
    }
    @Override
    protected void onStart(){
        super.onStart();
        registerEvent();
    }
    private void registerEvent(){
        calculatorButton.setOnClickListener(new View.OnClickListener() {
@Override
            public void onClick(View v) {
                if (!weightEditText.getText().toString().trim().equals("")) {
                    Double weight = Double.parseDouble(weightEditText.getText().toString());
                    StringBuffer sb = new StringBuffer();
                    if (manRadioButton.isChecked() || womanRadioButton.isChecked()) {

                        sb.append("男性身高标准：");
                        double result = evaluateHeight(weight, "男");
                        sb.append((int) result + "厘米");
                    }
                    if (womanRadioButton.isChecked()) {
                        sb.append("女性标准身高：");
                        double result = evaluateHeight(weight, "女");
                        sb.append((int) result + "厘米");
                    }
                    resultTextView.setText(sb.toString());
                } else {

                }
            }
        });
    }
    private double evaluateHeight(double weight,String sex){
        double height;
        if(sex=="男"){
            height=170-(62-weight)/0.6;
        }else{
            height=158-(52-weight)/0.5;
        }
        return height;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
