package ua.fortop.fa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class XO extends AppCompatActivity {

    private Button btn1j, btn2j, btn3j, btn4j, btn5j, btn6j, btn7j, btn8j, btn9j;
    private TextView player;
    private String main;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x_o);

        btn1j = findViewById(R.id.btn1);
        btn2j = findViewById(R.id.btn2);
        btn3j = findViewById(R.id.btn3);
        btn4j = findViewById(R.id.btn4);
        btn5j = findViewById(R.id.btn5);
        btn6j = findViewById(R.id.btn6);
        btn7j = findViewById(R.id.btn7);
        btn8j = findViewById(R.id.btn8);
        btn9j = findViewById(R.id.btn9);
        player = findViewById(R.id.player);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn1:
                        if (btn1j.getText() == "") {
                            btn1j.setText(rkorn());
                            check();
                            if (main.equals("X")) {
                                player.setText("Ход игрока 2");
                            } else if (main.equals("0")) {
                                player.setText("Ход игрока 1");
                            }
                        } else {
                            error();
                        }
                        break;
                    case R.id.btn2:
                        if (btn2j.getText() == "") {
                            btn2j.setText(rkorn());
                            check();
                            if (main.equals("X")) {
                                player.setText("Ход игрока 2");
                            } else if (main.equals("0")) {
                                player.setText("Ход игрока 1");
                            }
                        } else {
                            error();
                        }
                        break;
                    case R.id.btn3:
                        if (btn3j.getText() == "") {
                            btn3j.setText(rkorn());
                            check();
                            if (main.equals("X")) {
                                player.setText("Ход игрока 2");
                            } else if (main.equals("0")) {
                                player.setText("Ход игрока 1");
                            }
                        } else {
                            error();
                        }
                        break;
                    case R.id.btn4:
                        if (btn4j.getText() == "") {
                            btn4j.setText(rkorn());
                            check();
                            if (main.equals("X")) {
                                player.setText("Ход игрока 2");
                            } else if (main.equals("0")) {
                                player.setText("Ход игрока 1");
                            }
                        } else {
                            error();
                        }
                        break;
                    case R.id.btn5:
                        if (btn5j.getText() == "") {
                            btn5j.setText(rkorn());
                            check();
                            if (main.equals("X")) {
                                player.setText("Ход игрока 2");
                            } else if (main.equals("0")) {
                                player.setText("Ход игрока 1");
                            }
                        } else {
                            error();
                        }
                        break;
                    case R.id.btn6:
                        if (btn6j.getText() == "") {
                            btn6j.setText(rkorn());
                            check();
                            if (main.equals("X")) {
                                player.setText("Ход игрока 2");
                            } else if (main.equals("0")) {
                                player.setText("Ход игрока 1");
                            }
                        } else {
                            error();
                        }
                        break;
                    case R.id.btn7:
                        if (btn7j.getText() == "") {
                            btn7j.setText(rkorn());
                            check();
                            if (main.equals("X")) {
                                player.setText("Ход игрока 2");
                            } else if (main.equals("0")) {
                                player.setText("Ход игрока 1");
                            }
                        } else {
                            error();
                        }
                        break;
                    case R.id.btn8:
                        if (btn8j.getText() == "") {
                            btn8j.setText(rkorn());
                            check();
                            if (main.equals("X")) {
                                player.setText("Ход игрока 2");
                            } else if (main.equals("0")) {
                                player.setText("Ход игрока 1");
                            }
                        } else {
                            error();
                        }
                        break;
                    case R.id.btn9:
                        if (btn9j.getText() == "") {
                            btn9j.setText(rkorn());
                            check();
                            if (main.equals("X")) {
                                player.setText("Ход игрока 2");
                            } else if (main.equals("0")) {
                                player.setText("Ход игрока 1");
                            }
                        } else {
                            error();
                        }
                        break;
                }
            }
        };
        btn1j.setOnClickListener(onClickListener);
        btn2j.setOnClickListener(onClickListener);
        btn3j.setOnClickListener(onClickListener);
        btn4j.setOnClickListener(onClickListener);
        btn5j.setOnClickListener(onClickListener);
        btn6j.setOnClickListener(onClickListener);
        btn7j.setOnClickListener(onClickListener);
        btn8j.setOnClickListener(onClickListener);
        btn9j.setOnClickListener(onClickListener);
    }

    private String rkorn() {
        if (count % 2 != 0) {
            count++;
            main = "0";
            return main;
        } else {
            count++;
            main = "X";
            return main;
        }
    }

    private void error() {
        AlertDialog.Builder builder = new AlertDialog.Builder(XO.this);
        builder.setMessage("Эта ячейка уже занята!")
                .setCancelable(true)//можем ли отменить всплывающее окно
                .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();//отменяю всплывающее окно
                    }
                });
        AlertDialog alertDialog = builder.create();//создание диалогового окна
        alertDialog.setTitle("Внимание!");
        alertDialog.show();
    }

    private void check() {
        if (btn1j.getText() != "" && btn2j.getText() != "" && btn3j.getText() != "" && btn1j.getText() == btn2j.getText() && btn1j.getText() == btn3j.getText()) {
            if (btn1j.getText() == "X") {
                winPlayer1();
            } else {
                winPlayer2();
            }
        } else if (btn4j.getText() != "" && btn5j.getText() != "" && btn6j.getText() != "" && btn4j.getText() == btn5j.getText() && btn4j.getText() == btn6j.getText()) {
            if (btn4j.getText() == "X") {
                winPlayer1();
            } else {
                winPlayer2();
            }
        } else if (btn7j.getText() != "" && btn8j.getText() != "" && btn9j.getText() != "" && btn7j.getText() == btn8j.getText() && btn7j.getText() == btn9j.getText()) {
            if (btn7j.getText() == "X") {
                winPlayer1();
            } else {
                winPlayer2();
            }
        } else if (btn1j.getText() != "" && btn4j.getText() != "" && btn7j.getText() != "" && btn1j.getText() == btn4j.getText() && btn1j.getText() == btn7j.getText()) {
            if (btn1j.getText() == "X") {
                winPlayer1();
            } else {
                winPlayer2();
            }
        } else if (btn2j.getText() != "" && btn5j.getText() != "" && btn8j.getText() != "" && btn2j.getText() == btn5j.getText() && btn2j.getText() == btn8j.getText()) {
            if (btn2j.getText() == "X") {
                winPlayer1();
            } else {
                winPlayer2();
            }
        } else if (btn3j.getText() != "" && btn6j.getText() != "" && btn9j.getText() != "" && btn3j.getText() == btn6j.getText() && btn3j.getText() == btn9j.getText()) {
            if (btn3j.getText() == "X") {
                winPlayer1();
            } else {
                winPlayer2();
            }
        } else if (btn1j.getText() != "" && btn5j.getText() != "" && btn9j.getText() != "" && btn1j.getText() == btn5j.getText() && btn1j.getText() == btn9j.getText()) {
            if (btn1j.getText() == "X") {
                winPlayer1();
            } else {
                winPlayer2();
            }
        } else if (btn3j.getText() != "" && btn5j.getText() != "" && btn7j.getText() != "" && btn3j.getText() == btn5j.getText() && btn3j.getText() == btn7j.getText()) {
            if (btn3j.getText() == "X") {
                winPlayer1();
            } else {
                winPlayer2();
            }
        } else if(count == 9) {
            AlertDialog.Builder builder = new AlertDialog.Builder(XO.this);
            builder.setMessage("Победила дружба!)")
                    .setCancelable(false)//можем ли отменить всплывающее окно
                    .setNegativeButton("Начать заново", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            main = "";
                            count = 0;
                            player.setText("Ход игрока 1");
                            btn1j.setText("");
                            btn2j.setText("");
                            btn3j.setText("");
                            btn4j.setText("");
                            btn5j.setText("");
                            btn6j.setText("");
                            btn7j.setText("");
                            btn8j.setText("");
                            btn9j.setText("");
                            dialogInterface.cancel();//отменяю всплывающее окно
                        }
                    });
            AlertDialog alertDialog = builder.create();//создание диалогового окна
            alertDialog.setTitle("Поздравляем!");
            alertDialog.show();
        }
    }

    private void winPlayer1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(XO.this);
        builder.setMessage("Игрок 1 победил!")
                .setCancelable(false)//можем ли отменить всплывающее окно
                .setNegativeButton("Начать заново", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        main = "";
                        count = 0;
                        player.setText("Ход игрока 1");
                        btn1j.setText("");
                        btn2j.setText("");
                        btn3j.setText("");
                        btn4j.setText("");
                        btn5j.setText("");
                        btn6j.setText("");
                        btn7j.setText("");
                        btn8j.setText("");
                        btn9j.setText("");
                        dialogInterface.cancel();//отменяю всплывающее окно
                    }
                });
        AlertDialog alertDialog = builder.create();//создание диалогового окна
        alertDialog.setTitle("Поздравляем!");
        alertDialog.show();
    }

    private void winPlayer2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(XO.this);
        builder.setMessage("Игрок 2 победил!")
                .setCancelable(false)//можем ли отменить всплывающее окно
                .setNegativeButton("Начать заново", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        main = "";
                        count = 0;
                        player.setText("Ход игрока 1");
                        btn1j.setText("");
                        btn2j.setText("");
                        btn3j.setText("");
                        btn4j.setText("");
                        btn5j.setText("");
                        btn6j.setText("");
                        btn7j.setText("");
                        btn8j.setText("");
                        btn9j.setText("");
                        dialogInterface.cancel();//отменяю всплывающее окно
                    }
                });
        AlertDialog alertDialog = builder.create();//создание диалогового окна
        alertDialog.setTitle("Поздравляем!");
        alertDialog.show();
    }
}