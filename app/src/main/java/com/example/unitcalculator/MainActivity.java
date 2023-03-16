package com.example.unitcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner input,output;
    Button convert;
    EditText money;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        output = findViewById(R.id.output);
        money = findViewById(R.id.money);
        result = findViewById(R.id.result);
        convert = findViewById(R.id.convert);
        String unit[] = {"Rupees","Dollar","Euros","Pounds"};

        ArrayAdapter adp =new ArrayAdapter(this, android.R.layout.simple_spinner_item,unit);
        input.setAdapter(adp);
        output.setAdapter(adp);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(money.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this, "Empty input", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(input.getSelectedItem().equals("Rupees"))
                {
                    if(output.getSelectedItem().equals("Dollar"))
                        result.setText("U+0024: " + Float.parseFloat(money.getText().toString()) * 0.0125463f + " $");
                    else if(output.getSelectedItem().equals("Euros"))
                        result.setText("EUR: " + Float.parseFloat(money.getText().toString()) * 0.0125112f + " £");
                    else if(output.getSelectedItem().equals("Pounds"))
                        result.setText("POUND: " + Float.parseFloat(money.getText().toString()) * 0.0109675f + " £");
                    else
                        Toast.makeText(MainActivity.this, "Same", Toast.LENGTH_SHORT).show();
                }
                else if(input.getSelectedItem().equals("Dollar"))
                {
                    if(output.getSelectedItem().equals("Rupees"))
                        result.setText("RS: " + Float.parseFloat(money.getText().toString()) * 79.8188f + " ₹");
                    else if(output.getSelectedItem().equals("Euros"))
                        result.setText("EUR: " + Float.parseFloat(money.getText().toString()) * 1.002685f + " £");
                    else if(output.getSelectedItem().equals("Pounds"))
                        result.setText("POUND: " + Float.parseFloat(money.getText().toString()) * 0.878902f + " £");
                    else
                        Toast.makeText(MainActivity.this, "Same", Toast.LENGTH_SHORT).show();
                }
                else if(input.getSelectedItem().equals("Euros"))
                {
                    if(output.getSelectedItem().equals("Dollar"))
                        result.setText("U+0024: " + Float.parseFloat(money.getText().toString()) * 0.99328f + " $");
                    else if(output.getSelectedItem().equals("Rupees"))
                         result.setText("RS: " + Float.parseFloat(money.getText().toString()) * 79.3941f + " ₹");
                   else if(output.getSelectedItem().equals("Pounds"))
                        result.setText("POUND: " + Float.parseFloat(money.getText().toString()) * 0.873605f + " £");
                    else
                        Toast.makeText(MainActivity.this, "Same", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(output.getSelectedItem().equals("Dollar"))
                        result.setText("U+0024: " + Float.parseFloat(money.getText().toString()) * 1.14399f + " $");
                    else if(output.getSelectedItem().equals("Euros"))
                        result.setText("EUR: " + Float.parseFloat(money.getText().toString()) * 1.1302f + " £");
                    else if(output.getSelectedItem().equals("Rupees"))
                        result.setText("RS: " + Float.parseFloat(money.getText().toString()) * 90.7903f + " ₹");
                    else
                        Toast.makeText(MainActivity.this, "Same", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}