package ir.mrghost.moadeleD2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttons(View view){
        ImageView rate , contact;
        rate = findViewById(R.id.ratebtn);
        contact = findViewById(R.id.contactbtn);

        rate.setOnClickListener(v -> {
            Uri rateURI = Uri.parse("https://myket.ir/app/ir.mrghost.moadeleD2");
            Intent rateClick = new Intent(Intent.ACTION_VIEW , rateURI);
            startActivity(rateClick);
        });
        contact.setOnClickListener(v -> {
            Uri contactURI = Uri.parse("https://t.me/mrghost2007");
            Intent contactClick = new Intent(Intent.ACTION_VIEW , contactURI);
            startActivity(contactClick);
        });

    }

    public void initUI(View view) {

        Calculate calculate = new Calculate();

        Button calButton = findViewById(R.id.calculatebtn);
        calButton.setOnClickListener(v -> {
            //Find views
            TextView delta = findViewById(R.id.delta);
            EditText textA = findViewById(R.id.editTextA);
            EditText textB = findViewById(R.id.editTextB);
            EditText textC = findViewById(R.id.editTextC);
            TextView root1, root2;
            root1 = findViewById(R.id.root1);
            root2 = findViewById(R.id.root2);
            //Get text
            float a, b, c;
            a = Float.parseFloat(textA.getText().toString());
            b = Float.parseFloat(textB.getText().toString());
            c = Float.parseFloat(textC.getText().toString());
            //Calculate numbers
            float deltaF = calculate.calculateDelta(a, b, c);
            float root0 = calculate.calculateRoot0(a, b);
            float root1F = calculate.calculateRoot1(a , b , deltaF);
            float root2F = calculate.calculateRoot2(a , b , deltaF);

            //Set texts
            delta.setText("Delta : " + deltaF);
            delta.setAlpha(1);
            if (deltaF < 0) {
                root1.setText("معادله ریشه حقیقی ندارد");
                root1.setAlpha(1);
                root2.setAlpha(0);
            } else if (deltaF == 0) {
                root1.setText("Root : " + root0);
                root1.setAlpha(1);
                root2.setAlpha(0);
            }
            if (deltaF > 0) {
                root1.setText("Root 1 : " + root1F);
                root2.setText("Root 2 : " + root2F);
                root1.setAlpha(1);
                root2.setAlpha(1);
            }
        });

        }

    }