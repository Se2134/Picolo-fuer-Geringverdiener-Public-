package com.example.picolofuergeringverdiener;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass to choose the players
 */
public class SpielerWahl extends Fragment {

    // The fragment initialization parameters
    private static final String ARGSpielerNamen = "ARGSpielerNamen";

    public static ArrayList<String> spielerNamen = new ArrayList<>();

    private EditText namenEingeben;
    private LinearLayout layout;
    private Button weiter;
    private Button spielerLaden;

    public SpielerWahl() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param spielerNamen Namen der Spieler
     *
     * @return A new instance of fragment spieler_wahl.
     */
    public static SpielerWahl newInstance(ArrayList<String> spielerNamen) {
        SpielerWahl fragment = new SpielerWahl();
        Bundle args = new Bundle();
        args.putStringArrayList(ARGSpielerNamen, spielerNamen);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            spielerNamen = getArguments().getStringArrayList(ARGSpielerNamen);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Set the active fragment
        MainActivity.setAktivesFragment(AktivesFragment.SPIELERWAHL);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_spieler_wahl, container, false);

        // Initialize buttons, edittext and layout
        Button hinzufuegen = view.findViewById(R.id.spieler_hinzufuegen);
        weiter = view.findViewById(R.id.weiter);
        namenEingeben = view.findViewById(R.id.namen_eingeben);
        layout = view.findViewById(R.id.namen_anzeigen_container);

        // Initialize loading players (not implemented yet)
        spielerLaden = view.findViewById(R.id.spieler_laden);
        spielerLaden.setVisibility(View.INVISIBLE);

        // Show a box with the player name and an option to remove it for every player
        if (!spielerNamen.isEmpty()){
            for (String spieler : spielerNamen) {
                View view1 = getLayoutInflater().inflate(R.layout.namen_anzeigen, null);

                TextView nameText = view1.findViewById(R.id.name_text);
                Button entfernen = view1.findViewById(R.id.entferne_name);

                nameText.setText(spieler);

                entfernen.setOnClickListener(v -> {
                    layout.removeView(view1);
                    spielerNamen.remove(spieler);
                    MainActivity.spielerNamen.remove(spieler);
                    if (spielerNamen.size()<2){
                        weiter.setVisibility(View.INVISIBLE);
                    }
                });
                layout.addView(view1);
            }
            if (spielerNamen.size() > 1) {
                weiter.setVisibility(View.VISIBLE);
                spielerLaden.setVisibility(View.INVISIBLE);
            }
        }

        // Player loading (not implemented)
        spielerLaden.setOnClickListener(v -> {

        });

        // Add new player
        hinzufuegen.setOnClickListener(v -> addCard(namenEingeben.getText().toString()));

        // Navigate to picolo if game is selected, to game selection if not
        weiter.setOnClickListener(v -> {
            if (MainActivity.spiel == Spiel.PICOLO){
                NavHostFragment.findNavController(SpielerWahl.this)
                        .navigate(R.id.action_spieler_wahl_to_picolo);
            }
            else {
                NavHostFragment.findNavController(SpielerWahl.this)
                        .navigate(R.id.action_spieler_wahl_to_spielAuswahl);
            }
        });

        return view;
    }

    /**
     * Adds a card with player name and an option to remove it
     *
     * @param name  The name to add
     */
    private void addCard(String name){
        // Inflate the layout
        View view1 = getLayoutInflater().inflate(R.layout.namen_anzeigen, null);

        // If no name entered use standard name
        if (Objects.equals(name, getString(R.string.spieler_namen_eingeben_hier))){
            int n = 0;
            boolean nichtGefunden = true;
            while (nichtGefunden){
                if (!spielerNamen.contains("Spieler " + n)){
                    nichtGefunden = false;
                } else{
                    n++;
                }
            }
            name = "Spieler " + n;
        }

        // Display only first 16 letters of name
        TextView nameText = view1.findViewById(R.id.name_text);
        if (name.length() > 15){
            nameText.setText(name.substring(0, 16));
        } else {
            nameText.setText(name);
        }

        String finalName = name;

        // Initialize button to remove name
        Button entfernen = view1.findViewById(R.id.entferne_name);
        entfernen.setOnClickListener(v -> {
            layout.removeView(view1);
            spielerNamen.remove(finalName);
            MainActivity.spielerNamen.remove(finalName);
            if (spielerNamen.size()<2){
                weiter.setVisibility(View.INVISIBLE);
                // Player loading (not implemented)
                //spielerLaden.setVisibility(View.VISIBLE);
            }
        });

        layout.addView(view1);

        // Update player list
        MainActivity.spielerNamen.add(name);
        spielerNamen.add(name);
        if (spielerNamen.size()>1){
            weiter.setVisibility(View.VISIBLE);
            spielerLaden.setVisibility(View.INVISIBLE);
        }
    }
}