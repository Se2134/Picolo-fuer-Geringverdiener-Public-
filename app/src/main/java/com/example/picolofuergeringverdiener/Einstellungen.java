package com.example.picolofuergeringverdiener;

import android.os.Bundle;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass, that implements the settings.
 */
public class Einstellungen extends Fragment {


    public Einstellungen() {
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
        if (MainActivity.getAktivesFragment() != AktivesFragment.EINSTELLUNGEN){
            MainActivity.setAktivesFragment(AktivesFragment.EINSTELLUNGEN);
        }

        View view = inflater.inflate(R.layout.fragment_einstellungen, container, false);

        // Initialize the light/night mode switch
        SwitchCompat lightNight = view.findViewById(R.id.light_night);
        lightNight.setChecked(!MainActivity.isDayMode());
        lightNight.setOnClickListener(v -> {
            MainActivity.wechselDarkMode(lightNight.isChecked());
        });

        // Initialize the button to get back to the fragment before the settings
        Button weiter = view.findViewById(R.id.weiter);
        weiter.setOnClickListener(v -> {
            switch (MainActivity.getLetztesFragment()){
                case START:
                    NavHostFragment.findNavController(Einstellungen.this)
                            .navigate(R.id.action_einstellungen_to_start);
                    break;
                case PICOLO:
                    NavHostFragment.findNavController(Einstellungen.this)
                            .navigate(R.id.action_einstellungen_to_picolo);
                    break;
                case SPIELERWAHL:
                    NavHostFragment.findNavController(Einstellungen.this)
                            .navigate(R.id.action_einstellungen_to_spieler_wahl);
                    break;
                case SPIELAUSWAHL:
                    NavHostFragment.findNavController(Einstellungen.this)
                            .navigate(R.id.action_einstellungen_to_spielAuswahl);
                    break;
                default:
                    break;
            }
        });

        // Initialize the buttons for changing the player count/names and changing the game
        Button spielerAendern = view.findViewById(R.id.spieler_aendern);
        spielerAendern.setOnClickListener(v -> NavHostFragment.findNavController(Einstellungen.this)
                .navigate(R.id.action_einstellungen_to_spieler_wahl));

        Button spielAendern = view.findViewById(R.id.spiel_aendern);
        spielAendern.setOnClickListener(v -> NavHostFragment.findNavController(Einstellungen.this)
                .navigate(R.id.action_einstellungen_to_spielAuswahl));

        // Initialize a button to reset the questions and showing how many are left
        Button listeReset = view.findViewById(R.id.fragen_reset);
        String text;
        if (Picolo.fragenAnzahl != 0){
            text = getString(R.string.fragen_reset) + "\n (" + Picolo.fragenAnzahl + ") übrig";
        } else {
            text = getString(R.string.fragen_reset);
        }
        listeReset.setText(text);
        listeReset.setOnClickListener(v -> {
            Picolo.resetFragen();
            listeReset.setText(getString(R.string.fragen_reset));
        });

        // Initialize a button to get to the story behind the app (could also be used for credits)
        Button geschichte = view.findViewById(R.id.geschichte);
        geschichte.setOnClickListener(v -> NavHostFragment.findNavController(Einstellungen.this)
                .navigate(R.id.action_einstellungen_to_geschichte2));

        // Inflate the layout for this fragment
        return view;
    }
}