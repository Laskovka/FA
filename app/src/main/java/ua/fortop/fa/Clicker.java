package ua.fortop.fa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Clicker extends AppCompatActivity implements CallBack {

    public TextView valueTextView;
    DataClass db = new DataClass();

    @Override
    public boolean callBackMethodCarsLevels() {
        if (db.getValue() >= db.getLvl1Price()) {
            db.setValue(db.getValue() - db.getLvl1Price());
            db.setOnClick(db.getOnClick() + 1);
            db.setLvl1Price(db.getLvl1Price() + db.getLvl1Price());
            valueTextView.setText(db.getValue() + " дет.");
            return true;
        } else {
            Toast.makeText(this, "Не хватает деталей!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicker);
        {
            valueTextView = findViewById(R.id.value);
            Button clickerButton = findViewById(R.id.click);
            View.OnClickListener clickButton = new View.OnClickListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View view) {
                    db.setValue(db.getValue() + db.getOnClick());
                    valueTextView.setText(db.getValue() + " дет.");
                }
            };
            clickerButton.setOnClickListener(clickButton);
        }//OnClickPlusValue
        {
            Button carsButton = findViewById(R.id.carsButton);
            Button garagesButton = findViewById(R.id.garageButton);
            View.OnClickListener changeFragments = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()) {
                        case R.id.carsButton:
                            openCarsFragment();
                            break;
                        case R.id.garageButton:
                            openGaragesFragment();
                            break;
                    }
                }
            };
            carsButton.setOnClickListener(changeFragments);
            garagesButton.setOnClickListener(changeFragments);
        }//fragments(cars and garages)
    }

    private void openCarsFragment() {
        Cars fragment = new Cars();
        fragment.realizeCallBack(this);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutForFragment, fragment);
        fragmentTransaction.commit();
    }

    private void openGaragesFragment() {
        Garage fragment = new Garage();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutForFragment, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        openCarsFragment();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

//    private SharedPreferences sharedPreferences; //For setData() and getData()
//
//    private void setData() {
//        sharedPreferences = getSharedPreferences("Data", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putInt("value", getValue());
//        editor.putInt("onClick", getOnClick());
//        editor.putInt("valueForFirstLevelCars", getValueForFirstLevelCars());
//        editor.apply();
//
//        DataClass dataClass = new DataClass(); //вначале программы
//        dataClass.set1Lvl(valueForFirstLevelCars);
//    }
//
//    private void getData() {
//        sharedPreferences = getSharedPreferences("Data", MODE_PRIVATE);
//        setValue(sharedPreferences.getInt("value", 100));
//        setOnClick(sharedPreferences.getInt("onClick", 1));
//        setValueForFirstLevelCars(sharedPreferences.getInt("valueForFirstLevelCars", 200));
//        valueTextView.setText(getValue() + " дет.");
//    }
}