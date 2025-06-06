package com.example.picolofuergeringverdiener;

import android.os.Bundle;
import android.os.Handler;

import android.media.MediaPlayer;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass to play the game "Picolo"
 */
public class Picolo extends Fragment {

    // Initialize important variables
    private static final String ARG_ALLE_FRAGEN = "alleFragen";
    private static final String ARG_MODUS = "modus";
    private static final String ARG_TYPEN = "typen";
    private static final String ARG_SPIELER_NAMEN = "spielerNamen";
    private static final String ARG_NOCH_AUFLOESEN = "nochAufloesen";
    private static final String ARG_AKTIVE_FRAGE = "aktiveFrage";

    private static ArrayList<String> alleFragen;
    private ArrayList<String> spielerNamen;
    private ArrayList<String> nochAufloesen;
    private int modus;
    private ArrayList<FragenTypen> typen;
    private String aktiveFrage;
    private static boolean reset;
    public static int fragenAnzahl = 0;

    private int eastereggPicture;
    private int sound;

    private Button fragenanzeiger;
    private NeueFrage neueFrage;

    public Picolo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Picolo.
     */
    public static Picolo newInstance(int modus, ArrayList<FragenTypen> typen, ArrayList<String> alleFragen, ArrayList<String> spielerNamen, ArrayList<String> nochAufloesen, String aktiveFrage) {
        Picolo fragment = new Picolo();
        Bundle args = new Bundle();
        args.putInt(ARG_MODUS, modus);
        args.putSerializable(ARG_TYPEN, typen);
        args.putStringArrayList(ARG_ALLE_FRAGEN, alleFragen);
        args.putStringArrayList(ARG_SPIELER_NAMEN, spielerNamen);
        args.putStringArrayList(ARG_NOCH_AUFLOESEN, nochAufloesen);
        args.putString(ARG_AKTIVE_FRAGE, aktiveFrage);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(ARG_ALLE_FRAGEN, alleFragen);
        outState.putStringArrayList(ARG_SPIELER_NAMEN, spielerNamen);
        outState.putStringArrayList(ARG_NOCH_AUFLOESEN, nochAufloesen);
        outState.putSerializable(ARG_TYPEN, typen);
        outState.putInt(ARG_MODUS, modus);
        outState.putString(ARG_AKTIVE_FRAGE, aktiveFrage);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize the needed variables either with a saved state if existed or get the new ones
        neueFrage = new NeueFrage();
        if (getArguments() != null) {
            modus = getArguments().getInt(ARG_MODUS);
            typen = MainActivity.aktiveTypen;
            alleFragen = getArguments().getStringArrayList(ARG_ALLE_FRAGEN);
            spielerNamen = getArguments().getStringArrayList(ARG_SPIELER_NAMEN);
            nochAufloesen = getArguments().getStringArrayList(ARG_NOCH_AUFLOESEN);
            aktiveFrage = getArguments().getString(ARG_AKTIVE_FRAGE);
        } else {
            modus = MainActivity.modus;
            typen = MainActivity.aktiveTypen;
            if (alleFragen == null){
                alleFragen = neueFrage.fragenErstellen(modus, typen);
            }
            spielerNamen = MainActivity.spielerNamen;
            nochAufloesen = new ArrayList<>();
            if (MainActivity.aktiveFrage != null){
                aktiveFrage = MainActivity.aktiveFrage;
            }
        }
        if (savedInstanceState != null){
            modus = savedInstanceState.getInt(ARG_MODUS);
            typen = (ArrayList<FragenTypen>) savedInstanceState.getSerializable(ARG_TYPEN);
            alleFragen = savedInstanceState.getStringArrayList(ARG_ALLE_FRAGEN);
            spielerNamen = savedInstanceState.getStringArrayList(ARG_SPIELER_NAMEN);
            nochAufloesen = savedInstanceState.getStringArrayList(ARG_NOCH_AUFLOESEN);
            aktiveFrage = savedInstanceState.getString(ARG_AKTIVE_FRAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Choose when to show an easter egg
        Random random = new Random();
        eastereggPicture = random.nextInt(80) + 20;
        sound = random.nextInt(40) + 10;

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_picolo, container, false);

        // Set active fragment
        MainActivity.setAktivesFragment(AktivesFragment.PICOLO);

        // Initialize the button to show and switch questions
        fragenanzeiger = view.findViewById(R.id.fragen_anzeiger);
        fragenanzeiger.setOnClickListener(v -> fragenanzeiger.setText(gibFrage()));

        // Show active question
        if (aktiveFrage != null){
            fragenanzeiger.setText(aktiveFrage);
        }

        return view;
    }

    /**
     * Switches to a new question
     *
     * @return  The new question
     */
    private String gibFrage(){
        // Check if picture easter egg should be shown and show it if so
        eastereggPicture = (eastereggPicture >= 0)? eastereggPicture -1 : -1;
        if (eastereggPicture == 0){
            fragenanzeiger.setVisibility(View.INVISIBLE);
            new Handler().postDelayed(() -> fragenanzeiger.setVisibility(View.VISIBLE), 500);
        }

        // Check if sound easter egg should be played and if so play it
        sound--;
        if (sound == 0){
            List<Integer> quellen = new ArrayList<>();
            quellen.add(R.raw.placeholder_music);
            Collections.shuffle(quellen);

            MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), quellen.get(0));
            mediaPlayer.start();

            sound = new Random().nextInt(40) + 20;
        }

        // Reset question list if needed
        if (alleFragen.isEmpty()||reset){
            alleFragen = neueFrage.fragenErstellen(modus, typen);
            reset = false;
        }

        // Get new active question and set the new variables
        Bundle alles = neueFrage.ranFrage(neueFrage.ranSpieler(spielerNamen), alleFragen, nochAufloesen);
        aktiveFrage = alles.getString("aktiveFrage");
        alleFragen = alles.getStringArrayList("alleFragen");
        nochAufloesen = alles.getStringArrayList("nochAufloesen");

        fragenAnzahl = alleFragen.size();
        MainActivity.aktiveFrage = aktiveFrage;

        return aktiveFrage;
    }

    /**
     * Reset questions on next question
     */
    public static void resetFragen(){
        reset = true;
    }
}