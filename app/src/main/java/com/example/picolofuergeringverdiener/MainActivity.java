package com.example.picolofuergeringverdiener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

/**
 * The foundation of the app and saves all globally needed and static variables
 */
public class MainActivity extends AppCompatActivity {

    // Declare all important variables
    public static ArrayList<String> spielerNamen;
    public static ArrayList<FragenTypen> aktiveTypen;
    public static String aktiveFrage;
    public static int modus;
    private static AktivesFragment aktivesFragment;
    private static AktivesFragment letztesFragment;
    public static Spiel spiel;

    private static final String ARG_SPIELER_NAMEN = "spielerNamen";
    private static final String ARG_AKTIVE_TYPEN = "aktiveTypen";
    private static final String ARG_AKTIVE_FRAGE = "aktiveFrage";
    private static final String ARG_MODUS = "modus";
    private static final String ARG_AKTIVES_FRAGMENT = "aktivesFragment";
    private static final String ARG_SPIEL = "spiel";

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(ARG_SPIELER_NAMEN, spielerNamen);
        outState.putSerializable(ARG_AKTIVE_TYPEN, aktiveTypen);
        outState.putString(ARG_AKTIVE_FRAGE, aktiveFrage);
        outState.putInt(ARG_MODUS, modus);
        outState.putSerializable(ARG_AKTIVES_FRAGMENT, aktivesFragment);
        outState.putSerializable(ARG_SPIEL, spiel);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize game variables
        spielerNamen = new ArrayList<>();
        aktiveTypen = new ArrayList<>();
        aktiveFrage = null;
        modus = 1;

        // Getting saved variables if existent
        if (savedInstanceState != null){
            spielerNamen = savedInstanceState.getStringArrayList(ARG_SPIELER_NAMEN);
            aktiveTypen = (ArrayList<FragenTypen>) savedInstanceState.getSerializable(ARG_AKTIVE_TYPEN);
            aktiveFrage = savedInstanceState.getString(ARG_AKTIVE_FRAGE);
            modus = savedInstanceState.getInt(ARG_MODUS);
            aktivesFragment = (AktivesFragment) savedInstanceState.getSerializable(ARG_AKTIVES_FRAGMENT);
            spiel = (Spiel) savedInstanceState.getSerializable(ARG_SPIEL);
        }
        
        setContentView(R.layout.activity_main);

        // Adding the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onSupportNavigateUp() {
        super.onSupportNavigateUp();
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        NavController navController = Navigation.findNavController(this, R.id.fragmentContainerView2);

        // Navigate to the settings depending on the active fragment and back from the settings depending on the last fragment
        if (item.getItemId() == R.id.einstellungen_button){
            switch (aktivesFragment){
                case START:
                    navController.navigate(R.id.action_start_to_einstellungen);
                    break;
                case PICOLO:
                    navController.navigate(R.id.action_picolo_to_einstellungen);
                    break;
                case SPIELERWAHL:
                    navController.navigate(R.id.action_spieler_wahl_to_einstellungen);
                    break;
                case SPIELAUSWAHL:
                    navController.navigate(R.id.action_spielAuswahl_to_einstellungen);
                    break;
                case FRAGENWAHL:
                    navController.navigate(R.id.action_fragenWahl_to_einstellungen);
                    break;
                case GESCHICHTE:
                    navController.navigate(R.id.action_geschichte2_to_einstellungen);
                    break;
                case EINSTELLUNGEN:
                    switch (letztesFragment){
                        case START:
                            navController.navigate(R.id.action_einstellungen_to_start);
                            break;
                        case PICOLO:
                            navController.navigate(R.id.action_einstellungen_to_picolo);
                            break;
                        case SPIELERWAHL:
                            navController.navigate(R.id.action_einstellungen_to_spieler_wahl);
                            break;
                        case SPIELAUSWAHL:
                            navController.navigate(R.id.action_einstellungen_to_spielAuswahl);
                            break;
                        case FRAGENWAHL:
                            navController.navigate(R.id.action_einstellungen_to_fragenWahl);
                            break;
                        default:
                            System.out.println("Letztes Fragment vor Geschichte: " + letztesFragment);
                            break;
                    }
                    break;
                default:
                    System.out.println("Aktives Fragment: " + aktivesFragment);
                    break;
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Set the active fragment
     *
     * @param aktivesFragment   The fragment to set active
     */
    public static void setAktivesFragment(AktivesFragment aktivesFragment){
        if (aktivesFragment != AktivesFragment.GESCHICHTE &&
                !(aktivesFragment == AktivesFragment.EINSTELLUNGEN && MainActivity.aktivesFragment == AktivesFragment.GESCHICHTE)) {
            MainActivity.letztesFragment = MainActivity.aktivesFragment;
        }
        MainActivity.aktivesFragment = aktivesFragment;
    }

    /**
     * Get the last fragment before the current one
     *
     * @return  The last fragment
     */
    public static AktivesFragment getLetztesFragment(){
        return letztesFragment;
    }

    /**
     * Get the active fragment
     *
     * @return  The active fragment
     */
    public static AktivesFragment getAktivesFragment(){
        return aktivesFragment;
    }

    /**
     * Sets dark mode on or of
     *
     * @param dark  True = dark mode on, False = dark mode of
     */
    public static void wechselDarkMode(boolean dark){
        if (dark){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }  else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    /**
     * Checks weather or not the current mode is day mode
     *
     * @return  True if app is in day mode
     */
    public static boolean isDayMode(){
        return AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO;
    }
}