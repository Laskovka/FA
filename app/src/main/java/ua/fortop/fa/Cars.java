package ua.fortop.fa;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class Cars extends Fragment {

    CallBack callBack;

    public void realizeCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    Button levelOneBtn, levelTwoBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cars, container, false);

        levelOneBtn = v.findViewById(R.id.firstLevel);
        levelOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callBack != null) {
                    callBack.callBackMethodCarsLevels();
                }
            }
        });
        levelTwoBtn = v.findViewById(R.id.secondLevel);
        return v;
    }
}