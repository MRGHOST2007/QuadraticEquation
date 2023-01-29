package ir.mrghost.moadeleD2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
    }


    public void buttons(View view){
        ImageView rate , contact;
        rate = findViewById(R.id.ratebtn);
        contact = findViewById(R.id.contactbtn);

        rate.setOnClickListener(v -> {
            Uri rateURI = Uri.parse("myket://comment?id=ir.mrghost.moadeleD2");
            Intent rateClick = new Intent(Intent.ACTION_VIEW , rateURI);
            startActivity(rateClick);
        });
        contact.setOnClickListener(v -> {
            Uri contactURI = Uri.parse("https://t.me/mrghost2007");
            Intent contactClick = new Intent(Intent.ACTION_VIEW , contactURI);
            startActivity(contactClick);
        });
    }

    public void initUi(){
            Button calculateBtn = findViewById(R.id.calculatebtn);
            calculateBtn.setOnClickListener(v -> {

                ResultFragment dialog = new ResultFragment();
                dialog.show(getSupportFragmentManager(), null);

                EditText textA = findViewById(R.id.editTextA);
                EditText textB = findViewById(R.id.editTextB);
                EditText textC = findViewById(R.id.editTextC);

                String a, b, c;
                a = textA.getText().toString();
                b = textB.getText().toString();
                c = textC.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("StringA", a);
                bundle.putString("StringB", b);
                bundle.putString("StringC", c);
                dialog.setArguments(bundle);
            });

    }

    }