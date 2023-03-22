package com.example.learnwordsproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;

import com.example.learnwordsproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding; //чел в видео использует binding, видимо как-то удобнее работать с элементами
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater()); //Какая-то штука с binding (инициализация)
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment()); // Когда открываем приложение показываем HomeFragment

        binding.bottomNavigaionView.setOnItemSelectedListener(item -> { // Обработка нажатия на bottomNavMenu

            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ProfileFragment());
                    break;
                case R.id.settings:
                    replaceFragment(new SettingsFragment());
                    break;
            }

            return true;
        });
    }

    public void replaceFragment(Fragment fragment){ // метод для замены фрагмента

        FragmentManager fragmentManager = getSupportFragmentManager(); //cлужебные вызовы
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frame_layout, fragment); //заменяем текущий фрагмент в рамке на fragment
        fragmentTransaction.commit();
    }
}