package ua.fortop.fa;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button addition, subtraction, multiplication, division; //для калькулятора
    private Button exit;//для выхода из приложения
    private RatingBar rating;//рейтинг
    private TextView mark;//для отображения оценки рейтинга
    private Button transferButton;//переход на другую вкладку..

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addition = findViewById(R.id.additionButton);//для калькулятора ищем по айди
        subtraction = findViewById(R.id.subtractionButton);//для калькулятора ищем по айди
        multiplication = findViewById(R.id.multiplicationButton);//для калькулятора ищем по айди
        division = findViewById(R.id.divisionButton);//для калькулятора ищем по айди

        exit = findViewById(R.id.exitButton);//для выхода ищем по айди

        rating = findViewById(R.id.rating);//для рейтинга ищем по айди
        mark = findViewById(R.id.mark);//для отображения оценки рейтинга ищем по айди
        //рейтингBEGIN
        rating.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                        mark.setText("Ваша оценка - " + v);
//                        Toast.makeText(MainActivity.this, "Вы оценили на " + rating, Toast.LENGTH_SHORT).show();
                    }
                }
        );
        //рейтингEND

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                EditText firstNumberString = findViewById(R.id.firstNumber);
                EditText secondNumberString = findViewById(R.id.secondNumber);
                TextView result = findViewById(R.id.resultTexView);

                //если чила есть, то делаем операции, если нет, то просим ввести числа
                if (!(firstNumberString.getText().toString().isEmpty() || secondNumberString.getText().toString().isEmpty())) {
                    int firstNumberInt = Integer.parseInt(firstNumberString.getText().toString());
                    int secondNumberInt = Integer.parseInt(secondNumberString.getText().toString());

                    int resultInteger;
                    switch (view.getId()) { //О как, ищем по айдишнику...
                        case R.id.additionButton:
                            resultInteger = firstNumberInt + secondNumberInt;
                            result.setText(String.valueOf(resultInteger));

//                        addition.setText("!");//смена текста в кнопке
                            addition.setBackgroundColor(Color.parseColor("#00FF00"));//фон в кнопке
                            subtraction.setBackgroundColor(Color.parseColor("#D6D7D7"));//фон в кнопке
                            multiplication.setBackgroundColor(Color.parseColor("#D6D7D7"));//фон в кнопке
                            division.setBackgroundColor(Color.parseColor("#D6D7D7"));//фон в кнопке
                            break;
                        case R.id.subtractionButton:
                            resultInteger = firstNumberInt - secondNumberInt;
                            result.setText(String.valueOf(resultInteger));

                            addition.setBackgroundColor(Color.parseColor("#D6D7D7"));//фон в кнопке
                            subtraction.setBackgroundColor(Color.parseColor("#00FF00"));//фон в кнопке
                            multiplication.setBackgroundColor(Color.parseColor("#D6D7D7"));//фон в кнопке
                            division.setBackgroundColor(Color.parseColor("#D6D7D7"));//фон в кнопке
                            break;
                        case R.id.multiplicationButton:
                            resultInteger = firstNumberInt * secondNumberInt;
                            result.setText(String.valueOf(resultInteger));

                            addition.setBackgroundColor(Color.parseColor("#D6D7D7"));//фон в кнопке
                            subtraction.setBackgroundColor(Color.parseColor("#D6D7D7"));//фон в кнопке
                            multiplication.setBackgroundColor(Color.parseColor("#00FF00"));//фон в кнопке
                            division.setBackgroundColor(Color.parseColor("#D6D7D7"));//фон в кнопке
                            break;
                        case R.id.divisionButton:
                            resultInteger = firstNumberInt / secondNumberInt;
                            result.setText(String.valueOf(resultInteger));

                            addition.setBackgroundColor(Color.parseColor("#D6D7D7"));//фон в кнопке
                            subtraction.setBackgroundColor(Color.parseColor("#D6D7D7"));//фон в кнопке
                            multiplication.setBackgroundColor(Color.parseColor("#D6D7D7"));//фон в кнопке
                            division.setBackgroundColor(Color.parseColor("#00FF00"));//фон в кнопке
                            break;
                    }
                } else {
                    Toast.makeText(
                            MainActivity.this,
                            "Введите числа!",
                            Toast.LENGTH_SHORT
                    ).show(); //всплывающее окно, Toast
                }
            }
        };
        addition.setOnClickListener(onClickListener);
        subtraction.setOnClickListener(onClickListener);
        multiplication.setOnClickListener(onClickListener);
        division.setOnClickListener(onClickListener);

        //выход из приложения, алёрт(alert)
        View.OnClickListener exitOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Вы хотите закрыть приложение?")
                        .setCancelable(true)//можем ли отменить всплывающее окно
                        .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();//полностью закрывает приложение
                            }
                        });
//                        .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                dialogInterface.cancel();//отменяю всплывающее окно
//                            }
//                        });
                AlertDialog alertDialog = builder.create();//создание диалогового окна
                alertDialog.setTitle("Секунду!");
                alertDialog.show();
            }
        };

        exit.setOnClickListener(exitOnClickListener);
        //переход на другую активити
        transferButton = findViewById(R.id.transferToSecondActivity);
        transferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}