package com.example.joseph.converter;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.media.Image;
import android.nfc.cardemulation.CardEmulation;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //Declarations
    EditText textField1,textField2;
    ImageButton lenButton, wtButton, curButton;
    Spinner unitSelect1, unitSelect2;
    ArrayAdapter<CharSequence> adapterLen,adapterWt,adapterCur;
    DecimalFormat decimal = new DecimalFormat("#.##");

    int editTextId = 1;
    double input = 0;
    double output = 0;

    String convType = "length";
    String selUnit1 = "Kilometers"; //Default is Km
    String selUnit2 = "Kilometers";

    //Saved Instance Declarations
    static final String STATE_INPUT_1 = "Input 1";
    static final String STATE_INPUT_2 = "Input 2";
    static final String STATE_EDIT_TEXT_ID = "Edit Text ID";
    static final String STATE_CONV_TYPE = "Conversion Type";
    static final String STATE_SPIN_POS_1 = "Spinner 1 Position";
    static final String STATE_SPIN_POS_2 = "Spinner 2 Position";
    static double inputField1 = 0;
    static double inputField2 = 0;
    static String saveConvType = "length";
    static int saveEditId = 0;
    static int saveSpinPos1 = 0;
    static int saveSpinPos2 = 0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        switch(getResources().getConfiguration().orientation){
            case Configuration.ORIENTATION_PORTRAIT:
                setContentView(R.layout.activity_main);
                break;
            case Configuration.ORIENTATION_LANDSCAPE:
                setContentView(R.layout.activity_main_landscape);
                break;
        }

        final Converter converter = new Converter();

        //Widgets
        textField1 = (EditText) findViewById(R.id.input1);
        textField2 = (EditText) findViewById(R.id.input2);

        lenButton = (ImageButton) findViewById(R.id.lengthButton);
        wtButton = (ImageButton) findViewById(R.id.weightButton);
        curButton = (ImageButton) findViewById(R.id.currencyButton);

        unitSelect1 = (Spinner) findViewById(R.id.input1_list);
        unitSelect2 = (Spinner) findViewById(R.id.input2_list);

        adapterLen = ArrayAdapter.createFromResource(this, R.array.length_list,android.R.layout.simple_spinner_item);
        adapterLen.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterWt = ArrayAdapter.createFromResource(this, R.array.weight_list,android.R.layout.simple_spinner_item);
        adapterWt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterCur = ArrayAdapter.createFromResource(this, R.array.currency_list,android.R.layout.simple_spinner_item);
        adapterCur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        unitSelect1.setAdapter(adapterLen);
        unitSelect2.setAdapter(adapterLen);

        lenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                unitSelect1.setAdapter(adapterLen);
                unitSelect2.setAdapter(adapterLen);
                compOutput(converter);
                displayOutput();
                convType = "length";
            }

        });

        wtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                unitSelect1.setAdapter(adapterWt);
                unitSelect2.setAdapter(adapterWt);
                compOutput(converter);
                displayOutput();
                convType = "weight";
            }

        });

        curButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                unitSelect1.setAdapter(adapterCur);
                unitSelect2.setAdapter(adapterCur);
                compOutput(converter);
                displayOutput();
                convType = "currency";
            }

        });

        unitSelect1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                selUnit1 = adapterView.getItemAtPosition(position).toString();
                compOutput(converter);
                displayOutput();
                saveSpinPos1 = adapterView.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        unitSelect2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                selUnit2 = adapterView.getItemAtPosition(position).toString();
                compOutput(converter);
                displayOutput();
                saveSpinPos2 = adapterView.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        final TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().isEmpty()){
                    input = Double.parseDouble(charSequence.toString());
                    compOutput(converter);
                } else {
                    output = 0;
                    refreshInput();
                }
                displayOutput();
                saveInput();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().isEmpty()){
                   output = 0;
                }
            }
        };

        textField1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, final boolean inputFocus) {
                if(inputFocus){
                    textField1.addTextChangedListener(watcher);
                    editTextId = 1;
                } else {
                    textField1.removeTextChangedListener(watcher);
                }
            }
        });

        textField2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean inputFocus) {
                if(inputFocus){
                    textField2.addTextChangedListener(watcher);
                    editTextId = 2;
                } else {
                    textField2.removeTextChangedListener(watcher);
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putDouble(STATE_INPUT_1, inputField1);
        outState.putDouble(STATE_INPUT_2, inputField2);
        outState.putString(STATE_CONV_TYPE, convType);
        outState.putInt(STATE_EDIT_TEXT_ID, editTextId);
        outState.putInt(STATE_SPIN_POS_1, saveSpinPos1);
        outState.putInt(STATE_SPIN_POS_2, saveSpinPos2);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        convType = savedInstanceState.getString(STATE_CONV_TYPE);
        editTextId = savedInstanceState.getInt(STATE_EDIT_TEXT_ID);
        setSpinnerAdapter();
        unitSelect1.setSelection(savedInstanceState.getInt(STATE_SPIN_POS_1));
        unitSelect2.setSelection(savedInstanceState.getInt(STATE_SPIN_POS_2));
        textField1.setText(String.valueOf(decimal.format(savedInstanceState.getDouble(STATE_INPUT_1))));
        textField2.setText(String.valueOf(decimal.format(savedInstanceState.getDouble(STATE_INPUT_2))));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        switch(newConfig.orientation){
            case Configuration.ORIENTATION_PORTRAIT:
                setContentView(R.layout.activity_main);
                break;
            case Configuration.ORIENTATION_LANDSCAPE:
                setContentView(R.layout.activity_main_landscape);
                break;
        }
    }

    //Computes output based on whether active text field is 1 or 2.
    private void compOutput(Converter converter) {
        if(editTextId == 1) {
            output = converter.convert(selUnit1, selUnit2, input);
        } else {
            output = converter.convert(selUnit2, selUnit1, input);
        }
    }

    //Sets adapter to spinners after restoring saved instance state.
    private void setSpinnerAdapter(){
        switch(convType){
            case "length":
                unitSelect1.setAdapter(adapterLen);
                unitSelect2.setAdapter(adapterLen);
                break;
            case "weight":
                unitSelect1.setAdapter(adapterWt);
                unitSelect2.setAdapter(adapterWt);
                break;
            case "currency":
                unitSelect1.setAdapter(adapterCur);
                unitSelect2.setAdapter(adapterCur);
                break;
        }
    }

    //Displays the output after computation. Considers what field to display output on.
    private void displayOutput(){
        if(editTextId == 1){
            textField2.setText(String.valueOf(decimal.format(output)));
        } else {
            textField1.setText(String.valueOf(decimal.format(output)));
        }
    }

    //Replaces the string inside the current field if field becomes empty.
    private void refreshInput(){
        if(editTextId == 1){
            textField1.setText(String.valueOf(decimal.format(output)));
        } else {
            textField2.setText(String.valueOf(decimal.format(output)));
        }
    }

    //Used to save the output for save instance state.
    private void saveInput(){
        inputField1 = Double.parseDouble(textField1.getText().toString());
        inputField2 = Double.parseDouble(textField2.getText().toString());
    }
}
