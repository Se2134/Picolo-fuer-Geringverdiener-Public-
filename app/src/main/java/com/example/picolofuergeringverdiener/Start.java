package com.example.picolofuergeringverdiener;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.media.MediaPlayer;

/**
 * A simple {@link Fragment} subclass to implement the title screen
 */
public class Start extends Fragment {

    public Start() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Set active fragment
        MainActivity.setAktivesFragment(AktivesFragment.START);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_start, container, false);

        // Initialize start button and play a sound when pressed
        Button start_button = view.findViewById(R.id.start_button);
        start_button.setOnClickListener(v -> {
            MediaPlayer mediaPlayer = MediaPlayer.create(this.getContext(), R.raw.placeholder_music);
            mediaPlayer.start();
            NavHostFragment.findNavController(Start.this)
                    .navigate(R.id.action_start_to_spielAuswahl);
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}