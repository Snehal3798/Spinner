package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;//Objects of texttview ,edittext spinner are created to perform operations on it
    EditText editText;
    Spinner spinner;
    static String string,string1;
    RadioButton radioButton,radioButton1;
    RadioGroup radioGroup;//consist of multiple radio buttons
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinner);//calls id of spinner
        textView=findViewById(R.id.textView);//id of text view
        editText=findViewById(R.id.editTextTextPersonName);
        radioButton=findViewById(R.id.radioButton);
        radioButton1=findViewById(R.id.radioButton2);
        radioGroup=findViewById(R.id.radio_may);
        checkBox=findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {//it  is used to check the box
                if(compoundButton.isChecked())//if box is checked it will show the contents
                {
                    editText.setVisibility(View.INVISIBLE);//set visibility is used to visible the object with argument visible
                    radioGroup.setVisibility(View.INVISIBLE);
                    spinner.setVisibility(View.INVISIBLE);
                    textView.setVisibility(View.INVISIBLE);
                }else
                {
                    editText.setVisibility(View.VISIBLE);//to make object invisible
                    radioGroup.setVisibility(View.VISIBLE);
                    spinner.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.VISIBLE);
                }

            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {//on item selected method is called with  adapter object that will make connection between  UI and source code
                String s= editText.getText().toString().trim();//take text convert to string and remove white spaces
                string= String.valueOf(adapterView.getItemAtPosition(i));//inter is converted to string and value is stored at its position
                string=string + "\n Welcome " +s +string1;
                textView.setText(string);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void onRadioButtonClicked(View view) {
        boolean status_checked=((RadioButton)view).isChecked();
        switch (view.getId())
        {
            case R.id.radioButton:
                if(status_checked)
                {
                    string1= "\n"+"Gender "+radioButton.getText().toString().trim();
                }

                break;
            case R.id.radioButton2:
                if(status_checked) {
                    string1 = "\n"+"Gender " + radioButton1.getText().toString().trim() + "\n";
                }
                break;
        }

    }
}