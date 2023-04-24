package com.example.learnwordsproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements RecyclerViewInterface {

    private ArrayList<String> levelsArr;
    private RecyclerView recyclerView;

    public HomeFragment() {
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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        MyAdapter myAdapter = new MyAdapter(getContext(), levelsArr, this);
        recyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    private void dataInitialize() {
        levelsArr = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            levelsArr.add("Уровень " + i);
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this.getContext(), LevelActivity.class);

        intent.putExtra("POS", position);

        startActivity(intent);
    }
}