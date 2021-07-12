package com.rudrashisdutta.birthdayprobability.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rudrashisdutta.birthdayprobability.R;
import com.rudrashisdutta.birthdayprobability.logic.Logic;
import com.rudrashisdutta.birthdayprobability.logic.LogicInterface;

public class MainActivity extends AppCompatActivity implements OutputInterface{

    public final static String LOG_TAG = MainActivity.class.getCanonicalName();
    private LogicInterface mLogic;
    private EditText mOutput;
    private EditText mSize;
    private TextView mCount;
    protected Button mProcessButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLogic = new Logic(this);
        initializeUI();
    }


    private void initializeUI(){
        setContentView(R.layout.activity_main);
        mOutput = (EditText) findViewById(R.id.outputET);
        mSize = (EditText) findViewById(R.id.editTextGroupSize);
        mCount = (TextView) findViewById(R.id.editTextCount);
        mProcessButton = (Button) findViewById(R.id.button);
    }
    public void buttonPressed(View buttonPress) {
        resetText();
        mLogic.process();
    }
    private void addToEditText(String string) {
        mOutput.setText(String.format("%s%s", mOutput.getText(), string));
    }
    public int getSize(){
        int value = 0;
        final String strValue =
                mSize.getText().toString();

        if (!strValue.isEmpty())
            value = Integer.parseInt(strValue);
        return value;
    }
    public int getCount(){
        int value = 0;
        final String strValue =
                mCount.getText().toString();

        if (!strValue.isEmpty())
            value = Integer.parseInt(strValue);
        return value;
    }
    @Override
    public void print(String text) {
        Log.d(LOG_TAG, "print(String)");
        addToEditText(text);
    }
    @Override
    public void print(char _char) {
        print("" + _char);
    }
    @Override
    public void println(String text) {
        Log.d(LOG_TAG,"println(String)");
        addToEditText(text + "\n");
    }
    @Override
    public void println(char _char) {
        println("" + _char);
    }
    @Override
    public void resetText() {
        mOutput.setText("");
    }
    @Override
    public void log(String logText) {
        Log.d(Logic.TAG, logText);
    }
    @Override
    public void makeAlertToast(String alertText) {
        Toast.makeText(this,alertText,Toast.LENGTH_LONG).show();
    }
}