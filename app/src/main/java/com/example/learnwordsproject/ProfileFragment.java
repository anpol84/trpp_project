package com.example.learnwordsproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * ProfileFragment is a fragment that displays the user's profile information.
 * This fragment is responsible for displaying the user's name, profile picture, and other relevant information.
 * The information is retrieved from the associated ViewModel, which is responsible for fetching the data from the database.
 */
public class ProfileFragment extends Fragment {

    /**
     * Required empty public constructor
     */
    public ProfileFragment() {
        // Required empty public constructor
    }


    /**
     * Inflates the view for this fragment.
     *
     * @param inflater           LayoutInflater object.
     * @param container          ViewGroup object.
     * @param savedInstanceState Bundle object containing the fragment's keys/values.
     * @return Inflated view for this fragment.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView image = view.findViewById(R.id.progress_image);
        if(MainActivity.userProgress < 4*30){
            image.setImageResource(R.drawable.first_compressed);
        }else if (MainActivity.userProgress < 8*30){
            image.setImageResource(R.drawable.second_compressed);
        }else{
            image.setImageResource(R.drawable.third_compressed);
        }



    }
}