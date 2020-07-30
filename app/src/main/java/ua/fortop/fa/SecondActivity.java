package ua.fortop.fa;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    Button firstForm, xo, clicker;
    public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //переход на другую активити
        firstForm = findViewById(R.id.firstForm);
        firstForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        xo = findViewById(R.id.xo);
        xo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, XO.class);
                startActivity(intent);
            }
        });

        clicker = findViewById(R.id.clicker);
        clicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, Clicker.class);
                startActivity(intent);
            }
        });
    }

    // Метод обработки нажатия на кнопку
    public void sendMessage(View view) {
        // действия, совершаемые после нажатия на кнопку
        // Создаем объект Intent для вызова новой Activity
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        // Получаем текстовое поле в текущей Activity
        EditText editText = findViewById(R.id.phrase);
        // Получаем текст данного текстового поля
        String message = editText.getText().toString();
        // Добавляем с помощью свойства putExtra объект - первый параметр - ключ,
        // второй параметр - значение этого объекта
//        Параметр "EXTRA_MESSAGE" указывает на ключ передаваемых данных.
//        То есть мы можем в новую activity передать множество данных, и
//        чтобы их можно было разграничить, для них устанавливается ключ.
//        В данном случае ключ EXTRA_MESSAGE - эта обычная строка "EXTRA_MESSAGE"
        intent.putExtra(EXTRA_MESSAGE, message);
        // запуск activity
        startActivity(intent);
    }
}