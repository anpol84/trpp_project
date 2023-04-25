package com.example.learnwordsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LearnActivity extends AppCompatActivity {

    TextView learnWordTextEn;
    TextView learnWordTextRu;

    ArrayList<Integer> usedWords = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        learnWordTextEn = findViewById(R.id.learn_word_en);
        learnWordTextRu = findViewById(R.id.learn_word_ru);

        int pos = (int) (Math.random() * 30);
        Word word = LevelActivity.words.get(pos);
        setWords(word);

        findViewById(R.id.learn_next_bt).setOnClickListener(b -> {
            onClickNextBt();
        });
    }

    private void setWords(Word word) {
        learnWordTextEn.setText(word.englishWord);
        learnWordTextRu.setText(word.russianWord);
        usedWords.add((int) LevelActivity.words.indexOf(word));
    }

    public void onClickNextBt() {
        if (usedWords.size() < 30) {
            Word word;
            do {
                word = LevelActivity.words.get((int) (Math.random() * 30));
            } while (usedWords.contains((int) LevelActivity.words.indexOf(word)));
            setWords(word);
        } else {
            Toast.makeText(getApplicationContext(), "Вы закончили упражнение!", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, LevelActivity.class);

            intent.putExtra("POS", LevelActivity.currentPosition);

            startActivity(intent);
        }
    }
}