package com.example.picolofuergeringverdiener;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Chooses a new random question and replaces placeholders with names
 */
public class NeueFrage {
    // Declares the lists
    private ArrayList<String> regeln;
    private ArrayList<String> regelnFertig;


    // Declares player variables
    private String name_1;
    private String name_2;
    private String aktiveFrage;
    private int modus;                  //The game mode (0 with "Drehplatte", 1 without)
    private ArrayList<FragenTypen> typen;
    private int rundenSeitAufloesung;


    /**
     * Constructor that initializes the questions
     */
    public NeueFrage(){
        fragenErstellen(modus, typen);
    }


    /**
     * Initializes the questions used in the game
     * @param modus     The game mode (0 with "Drehplatte", 1 without)
     * @param typen     The selected types of questions
     * @return          A list of all questions that are being played with
     */
    public ArrayList<String> fragenErstellen(int modus, ArrayList<FragenTypen> typen){
        // Declares the lists
        FragenListe Liste = new FragenListe();
        this.modus = modus;
        this.typen = typen;

        ArrayList<String> alleFragen = new ArrayList<>();
        regeln = new ArrayList<>();
        regelnFertig = new ArrayList<>();

        // Initializes the lists of the needed types
        for (FragenTypen typ : FragenTypen.values()){
            if (MainActivity.aktiveTypen.contains(typ)){
                if (modus == 0){
                    if (typ == FragenTypen.CHALLENGES){
                        regeln.addAll(Liste.get(typ, 0).getList());
                        regelnFertig.addAll(Liste.getChallengesFertig(0).getList());
                    } else{
                        alleFragen.addAll(Liste.get(typ, 0).getList());
                    }
                }
                if (typ == FragenTypen.CHALLENGES){
                    regeln.addAll(Liste.get(typ, 1).getList());
                    regelnFertig.addAll(Liste.getChallengesFertig(1).getList());
                } else{
                    alleFragen.addAll(Liste.get(typ, 1).getList());
                }

            }
        }
        alleFragen.addAll(regeln);
        return alleFragen;
    }

    /**
     * Chooses two random players and replaces the name with a nickname sometimes
     *
     * @param spieler   A list of players
     * @return          An array of two strings with the player names
     */
    public String[] ranSpieler(ArrayList<String> spieler){
        // Get two random names
        Random random = new Random();
        Collections.shuffle(spieler);
        name_1 = spieler.get(0);
        name_2 = spieler.get(1);

        // Replace the name with a nickname
        if (name_2.equals("Name1")){
            name_2 = "Spitzname";
        }
        // Replace the name with a nickname sometimes
        if (name_2.equals("Name2")){
            int g = random.nextInt(10);
            if (g == 1){
                name_2 = "Spitzname1";
            }
            if (g ==2 ){
                name_2 = "Spitzname2";
            }
        }

        // Bundles the names in an array
        String[] gewaehlteSpieler = new String[2];
        gewaehlteSpieler[0] = name_1;
        gewaehlteSpieler[1] = name_2;

        return gewaehlteSpieler;
    }

    /**
     * Chooses random question and replaces placeholders with names
     *
     * @param gewaehlteSpieler  The names of players
     * @param alleFragen        All remaining questions that are played with
     * @param nochAufloesen     All resolutions of all unresolved rules
     * @return                  A bundle with all remaining questions, all unresolved resolutions and the current question
     */
    public Bundle ranFrage(String[] gewaehlteSpieler, ArrayList<String> alleFragen, ArrayList<String> nochAufloesen){
        Random random = new Random();
        Collections.shuffle(alleFragen);
        name_1 = gewaehlteSpieler[0];
        name_2 = gewaehlteSpieler[1];

        // Reset question list if all are used
        if (alleFragen.isEmpty() && nochAufloesen.isEmpty()){
            fragenErstellen(modus, typen);
        }
        // Find a new question or resolve a implemented rule
        else {
            if (((!nochAufloesen.isEmpty() && random.nextInt(10) == 0) | rundenSeitAufloesung > 20)||alleFragen.isEmpty()){
                aktiveFrage = nochAufloesen.get(0);
                nochAufloesen.remove(0);
                rundenSeitAufloesung = 0;
            } else {
                aktiveFrage = alleFragen.get(0);
                alleFragen.remove(0);
                if (!nochAufloesen.isEmpty()) {
                    rundenSeitAufloesung++;
                }
            }
            // Add the resolution if question is a rule
            if (regeln.contains(aktiveFrage)){
                String aufloesen = regelnFertig.get(regeln.indexOf(aktiveFrage)).replace("name_1", name_1);
                aufloesen = aufloesen.replace("name_2", name_2);
                nochAufloesen.add(aufloesen);
            }
        }

        // Replace placeholder with player names
        aktiveFrage = aktiveFrage.replace("name_1", name_1);
        aktiveFrage = aktiveFrage.replace("name_2", name_2);

        // Bundle everything and return it
        Bundle alles = new Bundle();
        alles.putStringArrayList("alleFragen", alleFragen);
        alles.putStringArrayList("nochAufloesen", nochAufloesen);
        alles.putString("aktiveFrage", aktiveFrage);

        return alles;
    }
}