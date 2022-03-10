package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText DisplayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayText = findViewById(R.id.Input);
        DisplayText.setShowSoftInputOnFocus(false);

        DisplayText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.display).equals(DisplayText.getText().toString()))
                {
                    DisplayText.setText("");
                }
            }
        });
    }
    private void updateText(String strToAdd){
        String oldStr = DisplayText.getText().toString();
        int cursorPos = DisplayText.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        if(getString(R.string.display).equals(DisplayText.getText().toString())){
            DisplayText.setText(strToAdd);

        }
        else{
            DisplayText.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            /*DisplayText.setSelection(cursorPos + 1);*/
        }
        DisplayText.setSelection(cursorPos + 1);

    }
    public void zeroBTN(View view){
        updateText("0");
    }
    public void oneBTN(View view){
        updateText("1");
    }
    public void twoBTN(View view){
        updateText("2");
    }
    public void threeBTN(View view){
        updateText("3");
    }
    public void fourBTN(View view){
        updateText("4");
    }
    public void fiveBTN(View view){
        updateText("5");
    }
    public void sixBTN(View view){
        updateText("6");
    }
    public void sevenBTN(View view){
        updateText("7");
    }
    public void eightBTN(View view){
        updateText("8");
    }
    public void nineBTN(View view){
        updateText("9");
    }
    public void cancelBTN(View view){
        DisplayText.setText("");
    }
    public void multiplyBTN(View view){
        updateText("*");
    }
    public void divideBTN(View view){
        updateText("/");
    }
    public void addBTN(View view){
        updateText("+");
    }
    public void subtractBTN(View view){
        updateText("-");
    }
    public void equalsBTN(View view){
        updateText("=");
    }
    public void exponentBTN(View view){
        updateText("^");
    }
    public void parenthesesBTN(View view){
        int cursorPos = DisplayText.getSelectionStart();
        int openPar = 0;
        int closedPar = 0;
        int textlen = DisplayText.getText().length();

        for(int i =0 ; i<cursorPos; i++){
            if(DisplayText.getText().toString().charAt(i) == '('){
                openPar += 1;
            }
            if(DisplayText.getText().toString().charAt(i) == ')') {
                openPar += 1;
            }
        }
        if(openPar == closedPar || DisplayText.getText().toString().charAt(textlen - 1) == '('){
            updateText("(");
        }
        else if(closedPar < openPar && DisplayText.getText().toString().charAt(textlen - 1) != ')'){
            updateText(")");
        }
        DisplayText.setSelection(cursorPos+1);
    }
    public void plusMinusBTN(View view){
        updateText("+-");
    }
    public void pointBTN(View view){
        updateText(".");
    }
    public void backspaceBTN(View view){
        int cursorPos = DisplayText.getSelectionStart();
        int textLen = DisplayText.getText().length();

        if(cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection  = (SpannableStringBuilder) DisplayText.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            DisplayText.setText(selection);
            DisplayText.setSelection(cursorPos-1);
        }
    }

}