package ir.mrghost.moadeleD2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View view){
        //Identify IDs
        TextView delta = findViewById(R.id.delta);
        Button calButton = findViewById(R.id.calculatebtn);
        EditText textA = findViewById(R.id.editTextA);
        EditText textB = findViewById(R.id.editTextB);
        EditText textC = findViewById(R.id.editTextC);

        TextView root1 , root2;
        root1 = findViewById(R.id.root1);
        root2 = findViewById(R.id.root2);
        //Return text to float
        float a , b , c;
        a = Float.parseFloat(textA.getText().toString());
        b = Float.parseFloat(textB.getText().toString());
        c = Float.parseFloat(textC.getText().toString());
        //Calculate DELTA
        float deltaF = (b * b) - (4 * a * c);
        //Set Texts and Calculate Roots
        calButton.setOnClickListener(v -> {
            delta.setText("Delta : " + deltaF);
            delta.setAlpha(1);

            if (deltaF < 0) {
                root1.setText("معادله ریشه حقیقی ندارد");
                root1.setAlpha(1);
            } else if (deltaF == 0) {
                float root = -b / (2 * a);
                root1.setText("Root 1 : " + root);
                root1.setAlpha(1);
            } else if (deltaF > 0) {
                if (b > 0) {
                    float bPosetive = (0.0f) - b;
                    float root1F = (float) ((bPosetive + Math.sqrt(deltaF)) / (2 * a));
                    float root2F = (float) ((bPosetive - Math.sqrt(deltaF)) / (2 * a));
                    root1.setText("Root 1 : " + root1F);
                    root2.setText("Root 2 : " + root2F);
                    root1.setAlpha(1);
                    root2.setAlpha(1);
                } else if (b < 0) {
                    float bNegetive = (0.0f) - b;
                    float root1F = (float) ((bNegetive + Math.sqrt(deltaF)) / (2 * a));
                    float root2F = (float) ((bNegetive - Math.sqrt(deltaF)) / (2 * a));
                    root1.setText("Root 1 : " + root1F);
                    root2.setText("Root 2 : " + root2F);
                    root1.setAlpha(1);
                    root2.setAlpha(1);
                }
            }
        });


    }
}