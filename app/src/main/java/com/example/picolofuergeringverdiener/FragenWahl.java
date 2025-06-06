package com.example.picolofuergeringverdiener;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass, to choose which types of questions should be in the game
 */
public class FragenWahl extends Fragment {

    // The fragment initialization parameters
    private static final String ARG_FragenNamen = "FRAGENNAMEN";


    public FragenWahl() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param fragenNamen Namen der Fragenlisten
     *
     * @return A new instance of fragment FragenWahl.
     */
    public static FragenWahl newInstance(ArrayList<String> fragenNamen) {
        FragenWahl fragment = new FragenWahl();
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_FragenNamen, fragenNamen);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Setting the current fragment
        MainActivity.setAktivesFragment(AktivesFragment.FRAGENWAHL);

        View view = inflater.inflate(R.layout.fragment_fragen_wahl, container, false);

        // Initializing a button to continue
        Button weiter = view.findViewById(R.id.weiter);
        LinearLayout layout = view.findViewById(R.id.fragen_checkbox_container);
        // Navigate to the player choice if the game is picked and to the game choice if not
        weiter.setOnClickListener(v -> {
            if (MainActivity.spiel == Spiel.PICOLO){
                NavHostFragment.findNavController(FragenWahl.this)
                        .navigate(R.id.action_fragenWahl_to_spieler_wahl2);
            }
            else {
                NavHostFragment.findNavController(FragenWahl.this)
                        .navigate(R.id.action_spieler_wahl_to_spielAuswahl);
            }
        });

        // Initializing a textview with a checkbox for each type of question to select which types to play with. Standard is preselected
        for (FragenTypen typ : FragenTypen.values()) {
            View view1 = getLayoutInflater().inflate(R.layout.fragen_checkbox, null);

            TextView nameText = view1.findViewById(R.id.fragen_typ);
            CheckBox typAnAus = view1.findViewById(R.id.typ_an_aus);

            if (typ == FragenTypen.STANDART){
                typAnAus.setChecked(true);
                MainActivity.aktiveTypen.add(FragenTypen.STANDART);
            }

            typAnAus.setOnClickListener(v -> {
                if (typAnAus.isChecked()) {
                    MainActivity.aktiveTypen.add(FragenTypen.valueOf((String) nameText.getText()));
                } else {
                    MainActivity.aktiveTypen.remove(FragenTypen.valueOf((String) nameText.getText()));
                }
            });

            nameText.setText(typ.name());
            layout.addView(view1);
        }



        // Inflate the layout for this fragment
        return view;
    }
}