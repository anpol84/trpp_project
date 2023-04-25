package com.example.learnwordsproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {


    /**
     * Required empty public constructor.
     */
    public SettingsFragment() {
        // Required empty public constructor
    }


    /**
     * Called to create the view hierarchy associated with the fragment. Inflates the settings layout.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate any views in the fragment.
     * @param container          If non-null, this is the parent view that the fragment's UI will be attached to. The fragment should not add the view itself, but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState The savedInstanceState of the fragment.
     * @return The view hierarchy associated with the fragment.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView progressText = view.findViewById(R.id.settings_progress_text);
        TextView levelText = view.findViewById(R.id.settings_level_text);

        progressText.setText("Прогресс: "+MainActivity.userProgress+" слов");
        int progress = MainActivity.userProgress;
        int level =1;
        while (progress>=30){
            progress-=30;
            level+=1;
        }
        levelText.setText("Уровень: "+level);
    }
}