package com.example.learnwordsproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;

import com.example.learnwordsproject.databinding.ActivityMainBinding;
/**
 * MainActivity is the main activity class of the application.
 * This activity displays the bottom navigation bar and handles navigation between different fragments.
 * The fragments are swapped in the FrameLayout container with the help of FragmentManager.
 */
public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding; //чел в видео использует binding, видимо как-то удобнее работать с элементами
    /**
     * This method is called when the activity is starting. It is responsible for setting up the UI
     * and handling navigation between fragments.
     *
     * @param savedInstanceState Bundle object containing the activity's previously saved state, or null if the activity has no saved state.
     */
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

    /**
     * Replaces the current fragment in the FrameLayout container with a new fragment.
     *
     * @param fragment The fragment to replace the current fragment.
     */
    public void replaceFragment(Fragment fragment){ // метод для замены фрагмента

        FragmentManager fragmentManager = getSupportFragmentManager(); //cлужебные вызовы
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frame_layout, fragment); //заменяем текущий фрагмент в рамке на fragment
        fragmentTransaction.commit();
    }
}