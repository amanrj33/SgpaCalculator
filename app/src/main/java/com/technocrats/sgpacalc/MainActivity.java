package com.technocrats.sgpacalc;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint({"WrongConstant", "ResourceType"})
    public void addition(View view) {
        GridLayout gridLayout = (GridLayout) findViewById(R.id.linearlayout);
        EditText editText = (EditText) findViewById(R.id.sub_no);
        EditText editText2 = (EditText) findViewById(R.id.total_marks);
        String obj = editText.getText().toString();
        if (obj.equals("")) {
            editText.setError("Please Enter Required Field");
            editText.requestFocus();
            return;
        }
        gridLayout.removeAllViews();
        int parseInt = Integer.parseInt(obj);
        if (parseInt > 25) {
            editText.setError("Subject limit is 25");
            editText.setText("");
            editText.requestFocus();
            return;
        }
        editText.setEnabled(false);
        editText2.setEnabled(false);
        if (editText2.getText().toString().equals("")) {
            editText2.setHint("--");
        }
        int i = parseInt + 1;
        int i2 = parseInt;
        for (int i3 = 0; i3 < parseInt; i3++) {
            TextView textView = new TextView(this);
            textView.setTextAlignment(4);
            textView.setTextColor(-16777216);
            textView.setTextSize(18.0f);
            textView.setText("Subject " + i2 + " ");
            i2--;
            gridLayout.addView(textView, 0);
            EditText editText3 = new EditText(this);
            editText3.setInputType(2);
            editText3.setTextColor(-16777216);
            editText3.setId(i3);
            editText3.setTextAlignment(4);
            editText3.setHint(" Sub-Credit ");
            gridLayout.addView(editText3, 1);
            Spinner spinner = new Spinner(this);
            spinner.setId(i);
            i++;
            ArrayList arrayList = new ArrayList();
            arrayList.add("Select Grade");
            arrayList.add("O");
            arrayList.add("E");
            arrayList.add("A");
            arrayList.add("B");
            arrayList.add("C");
            arrayList.add("D");
            arrayList.add("F");
            arrayList.add("S");
            arrayList.add("M");
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367048, arrayList);
            arrayAdapter.setDropDownViewResource(17367049);
            spinner.setAdapter(arrayAdapter);
            gridLayout.addView(spinner, 2);
        }
        Button button = new Button(this);
        button.setTextAlignment(4);
        button.setTextColor(-16777216);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.show(view);
            }
        });
        button.setText("Calculate");
        gridLayout.addView(button, parseInt * 3);
        Toast.makeText(this, "Subjected Added Successfully", 0).show();
    }

    private void show(View view) {

        //Here you have to do sgpa calculation by getting value of editext and spinner

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) "YOUR SGPA");
        builder.setMessage((CharSequence) "this is the calculation showing part");
        builder.setNegativeButton((CharSequence) "Got It !!", (DialogInterface.OnClickListener) null).setCancelable(false);
        builder.create();
        builder.show();

    }

}