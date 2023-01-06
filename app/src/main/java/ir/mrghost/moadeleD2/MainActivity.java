package ir.mrghost.moadeleD2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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


    public float calculateDelta(float a, float b, float c) {
        return (b * b) - (4 * a * c);
    }

    public float calculateRoot0(float a, float b) {
        float root;
        root = (-b) / (2 * a);
        return root;
    }

    public float calculateRoot1(float a , float b , float delta){
        float root1F;
        root1F = (float) (((-b) + Math.sqrt(delta)) / (2 * a));
        return root1F;
    }
    public float calculateRoot2(float a , float b , float delta){
        float root2F;
        root2F = (float) (((-b) - Math.sqrt(delta)) / (2 * a));
        return root2F;
    }

    public void initUI(View view) {
        Button calButton = findViewById(R.id.calculatebtn);
        calButton.setOnClickListener(v -> {

            TextView delta = findViewById(R.id.delta);
            EditText textA = findViewById(R.id.editTextA);
            EditText textB = findViewById(R.id.editTextB);
            EditText textC = findViewById(R.id.editTextC);
            TextView root1, root2;
            root1 = findViewById(R.id.root1);
            root2 = findViewById(R.id.root2);
            float a, b, c;
            a = Float.parseFloat(textA.getText().toString());
            b = Float.parseFloat(textB.getText().toString());
            c = Float.parseFloat(textC.getText().toString());

            float deltaF = calculateDelta(a, b, c);
            float root0 = calculateRoot0(a , b);
            float root1F = calculateRoot1(a , b , deltaF);
            float root2F = calculateRoot2(a , b , deltaF);
            delta.setText("Delta : " + deltaF);
            delta.setAlpha(1);
            if (deltaF < 0) {
                root1.setText("معادله ریشه حقیقی ندارد");
                root1.setAlpha(1);
            } else if (deltaF == 0) {
                root1.setText("Root : " + root0);
                root1.setAlpha(1);
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