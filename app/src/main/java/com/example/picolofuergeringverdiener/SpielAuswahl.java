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
 * A simple {@link Fragment} subclass to choose the game
 */
public class SpielAuswahl extends Fragment {
    // Initialize important variables
    private static final String ARG_DREHPLATTE_AN = "drehplatte_an";

    private SwitchCompat drehplatteAnAus;
    private boolean drehplatteAn;


    public SpielAuswahl() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SpielAuswahl.
     */
    public static SpielAuswahl newInstance(boolean drehplatteAn) {
        SpielAuswahl fragment = new SpielAuswahl();
        Bundle args = new Bundle();
        args.putBoolean(ARG_DREHPLATTE_AN, drehplatteAn);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            drehplatteAn = getArguments().getBoolean(ARG_DREHPLATTE_AN);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Set active fragment
        MainActivity.setAktivesFragment(AktivesFragment.SPIELAUSWAHL);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_spiel_auswahl, container, false);

        // Initialize button for games
        Button picoloStart = view.findViewById(R.id.picolo_spiel_button);
        picoloStart.setOnClickListener(v -> {
            MainActivity.spiel = Spiel.PICOLO;
            NavHostFragment.findNavController(SpielAuswahl.this)
                    .navigate(R.id.action_spielAuswahl_to_fragenWahl2);
        });

        // Initialize the switch for game mode with/without "Drehplatte"
        drehplatteAnAus = view.findViewById(R.id.drehplatte_an_aus);
        if (MainActivity.modus == 0){
            drehplatteAn = true;
        } else {
            drehplatteAnAus.setChecked(false);
            drehplatteAn = false;
        }

        if (drehplatteAn) {
            drehplatteAnAus.setChecked(true);
            MainActivity.modus = 0;
        }

        drehplatteAnAus.setOnClickListener(v -> {
            drehplatteAn = drehplatteAnAus.isChecked();
            if (drehplatteAnAus.isChecked()){
                MainActivity.modus = 0;
            } else {
                MainActivity.modus = 1;
            }
        });
        return view;
    }
}