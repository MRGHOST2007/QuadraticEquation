package ir.mrghost.moadeleD2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ResultFragment extends BottomSheetDialogFragment {

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_result, container, false);

        QuadraticEquation calculate = new QuadraticEquation();
        try {
            //Find views
            TextView delta = view.findViewById(R.id.delta);
            TextView root1, root2;
            root1 = view.findViewById(R.id.root1);
            root2 = view.findViewById(R.id.root2);
            //Get bundle
            String receivedA = getArguments().getString("StringA");
            String receivedB = getArguments().getString("StringB");
            String receivedC = getArguments().getString("StringC");
            //Get text
            float a, b, c;
            a = Float.parseFloat(receivedA);
            b = Float.parseFloat(receivedB);
            c = Float.parseFloat(receivedC);
            //Calculate numbers
            float deltaF = calculate.calculateDelta(a, b, c);
            float root0 = calculate.calculateRoot0(a, b);
            float root1F = calculate.calculateRoot1(a, b, deltaF);
            float root2F = calculate.calculateRoot2(a, b, deltaF);

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
        } catch (NumberFormatException n) {
            Toast.makeText(this.getActivity(), "لظفا تمامی اعداد را وارد کنید" +
                    "\n(اگر عددی نیست یا ضریب ندارد برابر 0 قرار دهید)", Toast.LENGTH_SHORT).show();
            dismiss();
        }

        return view;
    }
}