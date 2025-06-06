package com.example.picolofuergeringverdiener;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass to show the story of the app
 * The story was deleted because of privacy reasons and can be alternatively used for credits
 */
public class Geschichte extends Fragment {

    // Defining important variables
    TextView geschichteText;
    ImageView geschichteBild;
    int geschichte;

    public Geschichte() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Setting the current fragment
        MainActivity.setAktivesFragment(AktivesFragment.GESCHICHTE);

        View view = inflater.inflate(R.layout.fragment_geschichte, container, false);

        // Initialize the first text and picture and setting the counter to the beginning
        geschichteText = view.findViewById(R.id.geschichte_text);
        geschichteBild = view.findViewById(R.id.geschichte_bilder);
        geschichte = 1;

        // Initialize the button for getting to the next part of the story
        Button geschichteWeiter = view.findViewById(R.id.button_geschichte);
        geschichteWeiter.setOnClickListener(v -> next());

        // Inflate the layout for this fragment
        return view;
    }

    /**
     * Switches to the next part of the story
     */
    private void next(){
        switch (geschichte){
            case 1:
                geschichteBild.setImageResource(R.drawable.placeholder_pic);
                geschichteText.setText(R.string.geschichte_1);
                break;
        }
        geschichte++;
    }
}