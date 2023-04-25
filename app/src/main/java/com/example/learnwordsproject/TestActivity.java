package com.example.learnwordsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class TestActivity extends AppCompatActivity {

    TextView textView;
    Button checkBt;
    EditText editText;
    Word currentWord;

    int errorCnt = 0;

    ArrayList<Integer> usedWords = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        textView = findViewById(R.id.test_text_word);
        checkBt = findViewById(R.id.test_check_bt);
        editText = findViewById(R.id.test_edit_text);


        int pos = (int) (Math.random() * 30);
        currentWord = LevelActivity.words.get(pos);
        usedWords.add(pos);
        textView.setText(currentWord.russianWord);

        checkBt.setOnClickListener(b -> {
            String answer = editText.getText().toString().toLowerCase();
            if (answer.equals(currentWord.englishWord)) {
                setNewWord();
                editText.getText().clear();
            } else {
                editText.getText().clear();
                Toast.makeText(this, "Ошибка", Toast.LENGTH_SHORT).show();
                errorCnt++;
                if (errorCnt == 3) {
                    Toast.makeText(this, "3 ошибки – слишком много :(", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.putExtra("POS", LevelActivity.currentPosition);
                    startActivity(intent);
                }
            }
        });

        findViewById(R.id.test_back_button).setOnClickListener(b -> {
            Intent intent = new Intent(this, LevelActivity.class);
            intent.putExtra("POS", LevelActivity.currentPosition);
            startActivity(intent);
        });
    }

    private void setNewWord() {
        if (usedWords.size() < 30) {
            do {
                currentWord = LevelActivity.words.get((int) (Math.random() * 30));
            } while (usedWords.contains((int) LevelActivity.words.indexOf(currentWord)));
            usedWords.add(LevelActivity.words.indexOf(currentWord));
            textView.setText(currentWord.russianWord);
        } else {
            Toast.makeText(getApplicationContext(), "Вы прошли уровень!", Toast.LENGTH_LONG).show();

            SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("progress", (MainActivity.userProgress + 30));
            editor.apply();

            if (LevelActivity.currentPosition >= MainActivity.userProgress / 30)
                MainActivity.setUserProgress(MainActivity.userProgress + 30);

            Intent intent = new Intent(this, LevelActivity.class);

            intent.putExtra("POS", LevelActivity.currentPosition);

            startActivity(intent);
        }
    }

}