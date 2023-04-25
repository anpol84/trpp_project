package com.example.learnwordsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CardsActivity extends AppCompatActivity {

    TextView learnWordTextFirst;
    TextView learnWordTextSecond;

    Button lookBt;
    Button rememberBt;
    Button notRememberBt;

    Word currentWord;
    boolean EnRu;

    ArrayList<Integer> usedWords = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        EnRu = getIntent().getBooleanExtra("EN-RU", true);

        learnWordTextFirst = findViewById(R.id.learn_word_first);
        learnWordTextSecond = findViewById(R.id.learn_word_second);

        lookBt = findViewById(R.id.cards_look_bt);
        rememberBt = findViewById(R.id.cards_remember);
        notRememberBt = findViewById(R.id.cards_not_remember);

        int pos = (int) (Math.random() * 30);
        currentWord = LevelActivity.words.get(pos);
        setWords();

        rememberBt.setVisibility(View.INVISIBLE);
        notRememberBt.setVisibility(View.INVISIBLE);
        learnWordTextSecond.setVisibility(View.INVISIBLE);

        lookBt.setOnClickListener(b -> {
            showItems();
        });
        notRememberBt.setOnClickListener(b->{
            hideItems();
        });
        rememberBt.setOnClickListener(b->{
            usedWords.add(LevelActivity.words.indexOf(currentWord));
            hideItems();
        });
    }

    private void hideItems() {
        rememberBt.setVisibility(View.INVISIBLE);
        notRememberBt.setVisibility(View.INVISIBLE);
        learnWordTextSecond.setVisibility(View.INVISIBLE);
        lookBt.setVisibility(View.VISIBLE);

        if (usedWords.size() < 30) {
            do {
                currentWord = LevelActivity.words.get((int) (Math.random() * 30));
            } while (usedWords.contains((int) LevelActivity.words.indexOf(currentWord)));
            setWords();
        } else {
            Toast.makeText(getApplicationContext(), "Вы закончили упражнение!", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, LevelActivity.class);

            intent.putExtra("POS", LevelActivity.currentPosition);

            startActivity(intent);
        }
    }

    private void showItems() {
        rememberBt.setVisibility(View.VISIBLE);
        notRememberBt.setVisibility(View.VISIBLE);
        learnWordTextSecond.setVisibility(View.VISIBLE);
        lookBt.setVisibility(View.INVISIBLE);
    }

    private void setWords() {
        if (EnRu) {
            learnWordTextFirst.setText(
                    currentWord.englishWord
            );
            learnWordTextSecond.setText(currentWord.russianWord);
        } else {
            learnWordTextFirst.setText(currentWord.russianWord);
            learnWordTextSecond.setText(currentWord.englishWord);
        }
    }
}