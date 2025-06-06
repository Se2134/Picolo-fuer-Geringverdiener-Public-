package com.example.picolofuergeringverdiener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * A class for storing all questions and sort them into types
 */
public class FragenListe {

    //The types without "Drehplatte"
    private FragenMitTyp standart, spicy, vorgluehen, kennenlernen, challenges, challengesFertig;

    //The types with "Drehplatte"
    private FragenMitTyp standartMit, spicyMit, vorgluehenMit, kennenlernenMit, challengesMit, challengesMitFertig;


    //Emojis
    String Hund = new String(Character.toChars(0x1F415));
    String Katze = new String(Character.toChars(0x1F408));

    //To use random values in the questions
    Random random = new Random();

    /**
     * A constructor that firstly initializes all lists of questions and then fills these lists
     */
    public FragenListe(){
        FragenErstellen();
        ListenFuellen();
    }

    /**
     * Initializes the lists
     */
    public void FragenErstellen(){

        // Without "Drehplatte"
        standart = new FragenMitTyp(new ArrayList<>(), FragenTypen.STANDART, false);
        spicy = new FragenMitTyp(new ArrayList<>(), FragenTypen.SPICY, false);
        vorgluehen = new FragenMitTyp(new ArrayList<>(), FragenTypen.VORGLUEHEN, false);
        kennenlernen = new FragenMitTyp(new ArrayList<>(), FragenTypen.KENNENLERNEN, false);
        challenges = new FragenMitTyp(new ArrayList<>(), FragenTypen.CHALLENGES, false);
        challengesFertig = new FragenMitTyp(new ArrayList<>(), FragenTypen.CHALLENGES, false);


        // With "Drehplatte"
        standartMit = new FragenMitTyp(new ArrayList<>(), FragenTypen.STANDART, true);
        spicyMit = new FragenMitTyp(new ArrayList<>(), FragenTypen.SPICY, true);
        vorgluehenMit = new FragenMitTyp(new ArrayList<>(), FragenTypen.VORGLUEHEN, true);
        kennenlernenMit = new FragenMitTyp(new ArrayList<>(), FragenTypen.KENNENLERNEN, true);
        challengesMit = new FragenMitTyp(new ArrayList<>(), FragenTypen.CHALLENGES, true);
        challengesMitFertig = new FragenMitTyp(new ArrayList<>(), FragenTypen.CHALLENGES, true);
    }

    /**
     * Fills the lists with questions
     */
    public void ListenFuellen(){

        // Without "Drehplatte"
        standart.getList().addAll(Arrays.asList(
                "name_1 drehe dich eine Minute im Kreis, sonst trinke 2 Shots",
                "name_1 schlage name_2",
                "name_1 schieße ein Selfie von der Gruppe und poste ihn auf Instagram, TikTok, o.Ä",
                "name_1 zeige dein letztes geschossenes Foto",
                "name_1 mache der linken Person ein Kompliment und beleidige die rechte Person",
                "name_1 zeige allen deinen Suchverlauf",
                "name_1, wenn du ein Tag lang eine andere Person sein könntest, wen würdest du wählen?",
                "name_1 was machst du ständig obwohl du es NULL kannst?",
                "name_1 glaubst du, du bist intelligenter als dein linker Sitznachbar?",
                "name_1 bist du schon mal betrunken Auto gefahren?",
                "name_1 bist du käuflich?",
                "name_1 wie lange hast du jemals am Stück nicht geduscht?",
                "name_1 welches Tier passt am besten zu dir und warum?",
                "name_1 womit kann man dich so richtig beeindrucken?",
                "name_1 von welchem Alkohol wird dir heute noch augenblicklich schlecht?",
                "name_1 auf einer Skala von 1-10: Für wie attraktiv hältst du dich?",
                "name_1 wer ist der/die Hübscheste in der Gruppe?",
                "name_1 wenn du morgen jemanden heiraten müsstest, wer wäre es?",
                "name_1 welche Superkraft hättest du gerne?",
                "name_1 an welches Erlebnis denkst du besonders gerne zurück?",
                "name_1 wirst du besoffen manchmal aufdringlich?",
                "name_1 erzähl der Gruppe von einem unanständigen Traum, an den du dich erinnern kannst",
                "name_1 wurdest du schon einmal so richtig hart gekorbt?",
                "name_1 wenn du für den Rest deines Lebens nur noch einen bestimmten Alkohol trinken dürftest, welcher wäre es?",
                "name_1 auf was könntest du eher verzichten: Alkohol oder Sex?",
                "name_1 trink dein Getränk innerhalb von 20 Sekunden leer und sing danach den Anfang von \"I want it that way\" (Backstreet Boys)",
                "name_1 mach dein Sternzeichen pantomimisch nach",
                "name_1 setz dich auf den Schoß deines rechten Sitznachbarn und flüster ihm ein ausgedachtes Pfannkuchen Rezept ins Ohr",
                "name_1 tanz zu einem Lied, welches die anderen Spieler aussuchen",
                "name_1 stell dich in den Hausflur / vor die Haustür und schrei laut “can i get a hayaaaa”",
                "name_1 ruf eine Person deiner Wahl an und wünsche ihr ein frohes neues Jahr",
                "name_1 ruf bei einer Person deiner Wahl an und frag, warum die Person dich angerufen hat",
                "name_1 küsse jedem in der Runde das Knie",
                "name_1 zieh ein Kleidungsstück aus (keine Socke/Schuh oder Gürtel erlaubt, nur “richtige” Kleidungsstücke)",
                "name_1 erklär deinem linken Sitznachbarn, weshalb du ungerne neben ihm sitzen möchtest",
                "name_1 tausche mit name_2 die Klamotten",
                "name_1 teste wessen Haare am besten riechen",
                "name_1 zeig allen ein peinliches Foto von dir.",
                "name_1 flirte eine Runde mit name_2",
                "name_1 gib deinem linken Nachbarn dein Handy und lass ihn in deine Foto-Galerie schauen",
                "name_1 laufe wie bei Germany's Next Topmodel über den Catwalk",
                "name_1 suche dir eine andere Person aus und mache mit dieser 10 Partnerliegestütze",
                "name_1 vor was hast du so richtig Angst?",
                "name_1 wann hast du das letzte Mal geweint?",

                // Mini games
                "name_1 spiele Schere, Stein, Papier mit name_2. Der Verlierer trinkt 4 Schlücke",
                "Alle spielen Schere, Stein, Papier. Wer als letztes übrig bleibt verteilt 6 Schlücke",
                "3-Finger \"Ich hab noch nie…\" \n\nJeder Spieler hält 3 Finger hoch und ihr spielt \"Ich hab noch nie...\", wer es schon getan hat nimmt einen Finger runter und trinkt einen. Wer zuerst alle drei Finger unten hat, verliert und trinkt 5 Schlücke" ,
                "Anstarren \n\n name_1 und name_2 starren sich an. Wer zuerst reagiert bzw. lacht, hat verloren und trinkt 2 Schlücke",
                "Medusa \n\nSchaut nach unten und hebt gleichzeitig die Köpfe. Jeder Spieler starrt einen anderen an. Schaut dieser zurück, ruft ihr \"Medusa!\" und schenkt trinkt 2 Schlücke. Das Spiel geht so lange bis nur noch 1/2 Spieler übrig sind" ,
                "Wasserfall \n\nAlle Spieler fangen gleichzeitig an zu trinken. Man darf erst aufhören, wenn der Spieler zu seiner Rechten absetzt. Wer das hochprozentigste Getränk vor sich stehen hat, setzt zuerst ab",
                "name_1 lies die zuletzt gesendete WhatsApp vor oder trinke 3 Schlücke",
                "Fuck, Marry, Kill \n\nname_1 dir werden drei Personen genannt. Wen würdest du ficken, wen heiraten und wen umbringen und wieso?",
                "Alle, die die Zunge rollen können, sind safe. Alle anderen müssen 2 Schlücke trinken",
                "Alle, die programieren können, sind safe. Alle anderen müssen 5 Schlücke trinken (Scratch zählt als 3 Schlücke)",
                "name_1 muss name_2 dessen Glas einflößen, ohne dass name_2 das Glas mit seinen Händen berührt",
                "Wer errät, welches Lied als nächstes vom DJ gespielt wird, ist safe, alle anderen müssen 4 Schlucke trinken",
                "Der, der name_1 am wenigsten kennt, muss erraten, wie alt name_1 ist. Wenn er falsch liegt, muss er mit name_1 Bruderschaft trinken (5 Schlücke)",
                "Alle müssen 10 Liegestützen machen. Wer als letztes fertig ist, muss 4 Schlücke trinken",

                // Enumerations
                "Zählt reih um Filmgenre auf, wem als erster keins mehr einfällt, muss 3 Schlücke trinken",
                "Zählt reih um Tierarten auf, wem als erster keine mehr einfällt, muss 3 Schlücke trinken",
                "Zählt reih um Biermarken auf, wem als erster keine mehr einfällt, muss 3 Schlücke trinken",
                "Zählt reih um Superhelden auf, wem als erster keiner mehr einfällt, muss 3 Schlücke trinken",
                "Zählt reih um Autohersteller auf, wem als erster keiner mehr einfällt, muss 3 Schlücke trinken",
                "Zählt reih um Modemarken auf, wem als erster keine mehr einfällt, muss 3 Schlücke trinken",
                "Zählt reih um Supermarktnamen auf, wem als erster keiner mehr einfällt, muss 3 Schlücke trinken",
                "Zählt reih um Streamingplatformen auf, wem als erster keine mehr einfällt, muss 3 Schlücke trinken",
                "Zählt reih um Werkzeuge auf, wem als erster keins mehr einfällt, muss 3 Schlücke trinken",
                "Zählt reih um Pflanzenarten auf, wem als erster keine mehr einfällt, muss 3 Schlücke trinken",

                // Who would rather
                "Wer würde eher? \n\neinen Fakeaccount anlegen und nutzen \ndiese Person muss 2 Schlücke trinken",
                "Wer würde eher? \n\nsich besoffen die Augenbrauen abrasieren \ndiese Person muss 2 Schlücke trinken",
                "Wer würde eher? \n\nauf Makeup verzichten \ndiese Person muss 2 Schlücke trinken",
                "Wer würde eher? \n\neinen Monat keinen Alkohol trinken \ndiese Person muss 2 Schlücke trinken",
                "Wer würde eher? \n\neinen Bungee Jump machen \ndiese Person muss 2 Schlücke trinken",

                // VS
                "Hunde gegen Katzen \n\nVerlierer trinken 2 Schlücke",
                "Playstation oder Xbox \n\nVerlierer trinken 2 Schlücke",


                // Joker
                "Saufsklave \n\nname_1 suche dir eine/n Freund/in aus, der/die das nächste mal für dich trinkt",
                "Trinkpartner \n\nname_1 suche dir einen Trinkpartner aus.\nDie nächsten 5 mal, wenn du oder dein gewählter Partner trinken müssen, trinkt der andere mit",
                "Bodyguard \n\nname_1 wähle einen Bodyguard. Für den Rest des Spieles muss er den ersten aller an dich verteilten Schlücke mittrinken"
));

        spicy.getList().addAll(Arrays.asList(
                ""
        ));

        vorgluehen.getList().addAll(Arrays.asList(
                "name_1 trink 2 Schlücke, weil Flüssigkeiten wichtig für den Körper sind",
                "Dicks drink!\n\nAlle Männer trinken 2 Schlücke",
                "Chicks drink\n\nAlle Frauen trinken 2 Schlücke",
                "Alle mit schwarzen Haaren trinken 2 Schlücke",
                "Alle mit blonden Haaren trinken 2 Schlücke",
                "Alle mit braunen Haaren trinken 2 Schlücke",
                "Alle trinken einen Shot",
                "name_1 trink einen Shot",
                "Der Besitzer dieses Handys trinkt einen Shot",
                "Der jüngste trinkt einen Shot",
                "Der älteste trinkt einen Shot",
                "Anfangsbuchstaben A - M trinken 2 Schlücke",
                "Anfangsbuchstaben N - Z trinken 2 Schlücke",
                "Alle ohne Bart trinken 3 Schlücke",
                "Alle mit Bart trinken 4 Schlücke",
                "Alle Singles trinken 3 Schlücke",
                "Alle Pärchen trinken 2 Schlücke",
                "Der Nüchternste trinkt 5 Schlücke",
                "Der Betrunkenste trinkt 2 Schlücke",
                "name_1 exe dein Getränk leer, egal was und wie voll es ist",
                "name_1 trinke einen Schluck für jeden Mitspieler am Tisch",
                "name_1 trink so viele Schlücke wie du Beziehungen hattest",
                "Wer das liest ist dumm",
                "name_1 trink einen für jeden Buchstaben in deinem Vornamen",
                "name_1 trink einen für jeden Buchstaben in deinem Nachnamen",
                "name_1 trink einen für jeden Spieler der jünger ist als du",
                "name_1 trink einen für jeden Spieler der älter ist als du",
                "name_1 trink einen für jedes Schmuckstück an deinem Körper.\nDazu zählen Ohrringe, Ringe, Ketten, Piercings, Tattoos, Uhren, Armbänder usw",
                "name_1, wenn dein Name mit einem Vokal endet, trink zwei Schlücke",
                "name_1 sag einen Trinkspruch auf, danach trinken alle 3 Schlücke",
                "Wer aus der Runde keine blaue Jeans anhat, muss einen Shot trinken",
                "name_1 trink innerhalb von 10 Sekunden dein Glas aus",
                "Jeder, der alle Folgen von „How I met your mother“ gesehen hat, muss einen Schluck trinken",
                "Jeder der noch keinen Marvelfilm gesehen hat muss 6 Schlücke trinken",
                "Säufer \n\nname_1 du hast 15 Sekunden Zeit Biermarken aufzuzählen. Für jede kannst du einen Schluck verteilen",
                "Käse \n\nname_1 du hast 15 Sekunden Zeit um Käsesorten aufzuzählen. Für jede kannst du einen Schluck verteilen",
                "Mystery Shot \n\nname_1 drinke dein Glas aus, drehe dich um und deine Mitspieler mischen dir ein neues Getränk, sie entscheiden was und wieviel",
                "name_1 verteile Schlücke für jede Person die kleiner ist als du",
                "name_1 verteile Schlücke für jede Person die größer ist als du",
                "name_1 trinke für jeden Streminganbieter, den du hast, einen Schluck",
                "name_1 trinke für jeden Kotzer wegen Akohol einen Schluck",
                "name_1 trinke für jedes Musikinstrument, das du beherrschst, einen Schluck",
                "Jeder, der sich schon schwer verletzt hat muss zur Schmerzbekämpfung 3 Schlücke trinken",

                // Distribution
                "name_1 verteile so viele Schlücke wie du Nachnahmen deiner Mitspieler aufzählen kannst",
                "name_1 verteile so viele Schlücke wie du Augenfarben von Mitspielern aufzählen kannst ohne nachzugucken",
                "name_1 verteile 2 Schlücke"
        ));

        kennenlernen.getList().addAll(Arrays.asList(
                "name_1 hast du schon einmal einen Post gelöscht, weil er zu wenig Likes/ Views bekam.",
                "name_1 hast du schon einmal mit meiner Mutter/ Vater über mein Sex-Leben gesprochen.",
                "name_1 hast du schon einmal in Unterhaltungen Interesse geheuchelt.",
                "name_1 hast du schon einmal etwas zu Essen mitgebracht und behauptet es selbst gemacht zu haben, obwohl es gekauft war.",
                "name_1 hast du schon einmal so getan krank zu sein, damit ich zuhause nicht im Haushalt helfen muss.",
                "name_1 hast du schon einmal Blut gespendet.",
                "name_1 hast du schon einmal jemand anderem das Herz gebrochen.",
                "name_1 wurdest du schon einmal betrogen",
                "name_1 hast du schon einmal jemandem absichtlich eine falsche Telefonnummer gegeben.",
                "name_1 hast du schon einmal einen Anruf aus dem Knast bekommen.",
                "name_1 hast du schon einmal so getan zu telefonieren nur um nicht mit jemand bestimmten reden zu müssen.",
                "name_1 hast du schon einmal gedacht, dass jemand aus der Runde hässlich / supergut aussieht!",
                "name_1 hast du schon einmal jemanden geküsst und es danach bereut."
        ));

        challenges.getList().addAll(Arrays.asList(
                "Namenstausch \n\nAlle Spieler tauschen ihren Namen mit dem rechten Sitznachbarn, wenn jemand den falschen Namen benutzt muss er 1 Schluck trinken",
                "Namenstausch \n\nAlle Spieler tauschen ihren Namen mit dem linken Sitznachbarn, wenn jemand den falschen Namen benutzt muss er 1 Schluck trinken",
                "Niemand darf den Ellenbogen auf den Tisch absetzen, sonst muss derjenige einen Schluck trinken",
                "Kellner \n\nname_1 du musst für die ganze Gruppe Getränke holen und servieren, bis hier etwas anderes steht",
                "name_1 sprich mit einem außergewöhnlichen Akzent, wenn du es vergisst trinke 1 Schluck",
                "Bauernhof \n\nname_1 wähle einen Spieler der immer dann ein Tiergeräusch machen muss, wenn name_2 trinkt",
                "Außenseiter \n\nname_1 du darfst nur zum Trinken an den Tisch kommen",
                "Redet euch nur mit „Sie“ an. Wer dagegen verstößt, muss 3 Schlücke trinken",
                "Ihr dürft nur noch flüstern. Wer dagegen verstößt, muss 2 Schlücke trinken",
                "Ihr dürft keine Frage stellen, sonst müsst ihr einen Shot trinken",
                "Alle müssen wie Yoda reden. Wer es nicht hinkriegt, muss 5 Schlücke trinken",
                "Ihr dürft nur noch mit der schwachen Hand trinken und wer dagegen verstößt, muss 2 Schlücke trinken",
                "name_1 heißt ab jetzt „Horst“. Sobald jemand ihn nicht mit diesem Namen anredet, muss derjenige 3 Schlücke trinken",
                "name_1 sprich in einem komischen Dialekt weiter bis hier steht, dass du normal sprechen darfst. Immer wenn du es vergisst musst du einen Schluck trinken",
                "name_1 rede wie Monte bis hier steht, dass du aufhören darfst",
                String.format("Niemand darf mehr den Buchstabe \"%s\" mehr benutzen, sonst muss diese Person einen Schluck trinken", (char) ('a' + random.nextInt(26)))

        ));

        challengesFertig.getList().addAll(Arrays.asList(
                "Alle Namen werden zurückgetauscht",
                "Alle Namen werden zurückgetauscht",
                "Ihr dürft die Ellenbogen wieder absetzen",
                "Kellner \n\nname_1 du musst nicht mehr für die ganze Gruppe Getränke holen und servieren",
                "name_1 sprich nicht mehr mit einem außergewöhnlichen Akzent",
                "Bauernhof \n\nDer gewählte Spieler muss keine Tiergeräuche mehr machen",
                "Außenseiter \n\nname_1 du darfst wieder ganz nochmal am Tisch stehen",
                "Redet euch wieder normal an",
                "Ihr müsst nicht mehr flüstern",
                "Ihr dürft wieder Fragen stellen",
                "Ihr müsst nicht mehr wie Yoda reden",
                "Ihr dürft wieder mit der Hand trinken mit der ihr wollt",
                "name_1 heißt nicht mehr \"Horst\"",
                "name_1 du darfst wieder normal reden",
                "name_1 du darfs aufhören wie Monte zu reden",
                "Ihr dürft wieder \"T\"s benutzen"
        ));


        // With "Drehplatte"
        standartMit.getList().addAll(Arrays.asList(
                "name_1 drehe so viele Getränke weiter, wie du schaffs ohne loszulassen",
                "name_1 du darfs wann du willst einmal in eine belibige Richtung drehen",
                "name_1 suche dir ein Getränk aus. Drehe bis zu diesem",
                "name_1 mixe dir dein nächstes Getränk wie du es willst",
                "name_1 drehe ein Getränk nach rechts und schütte von dem jetzt vor dir stehende Getränk nach",
                "name_1 drehe ein Getränk nach links und schütte von dem jetzt vor dir stehende Getränk nach",
                "name_1 drehe so lange bis das Getränk, das vor dir stand, jetzt bei name_2 steht",
                "name_1 drehe mit verschlossenen Augen so lange wie du willst. Das Getränk, das jetzt vor dir steht musst du dir einschenken",
                "Der mit dem hochprozentigsten Getränk darf das Getränk bis zu name_1 drehen",
                "name_1 dreht so viele Getränke weiter, wie er alt ist",
                "name_1 du darfs so oft weiter drehen wie du Instrumente spielst",
                "name_1 du darfs so viele Getränke weiter drehen, wie du jetzt Schlücke drinkst",
                "name_1 Entweder Oder\n\n<-- " + Katze +" | " + Hund + "-->",
                "name_1 Entweder Oder\n\n<-- Barfuß | Socken -->",
                "name_1 Entweder Oder\n\n<-- Links neben dir | Rechts neben dir -->",
                "name_1 Entweder Oder\n\n<-- Unsichtbar sein | Gedanken lesen -->",
                "name_1 Entweder Oder\n\n<-- Fliegen | Teleportieren -->",
                "name_1 Entweder Oder\n\n<-- Jogginghose | Jeans -->",
                "name_1 Entweder Oder\n\n<-- Schwitzen | Frieren -->",
                "name_1 Entweder Oder\n\n<-- Die Nutella | Das Nutella -->",
                "name_1 Entweder Oder\n\n<-- Android | iPhone -->",
                "name_1 Entweder Oder\n\n<-- Stadt | Dorf -->",
                "name_1 Entweder Oder\n\n<-- McDonald`s | Burger King -->",
                "name_1 Entweder Oder\n\n<-- Pizza | Nudeln -->",
                "name_1 Entweder Oder\n\n<-- Schockolade | Chips -->",
                "name_1 Entweder Oder\n\n<-- Sommer | Winter -->",
                "name_1 Entweder Oder\n\n<-- Strandurlaub | Städtetrip -->",
                "name_1 Entweder Oder\n\n<-- Viel Geld | Viel Freizeit -->",
                "name_1 Entweder Oder\n\n<-- Reich | Berühmt -->",
                "name_1 Entweder Oder\n\n<-- Marvel | DC -->",
                "name_1 Entweder Oder\n\n<-- Süßes Popkorn | Salziges Popkorn -->",
                "name_1 Entweder Oder\n\n<-- Bösewicht | Superheld -->",
                "name_1 Entweder Oder\n\n<-- Ketchup | Majo -->",
                "name_1 Entweder Oder\n\n<-- Optimist | Pessimist -->",
                "name_1 Entweder Oder\n\n<-- Regen | Schnee -->",
                "name_1 Entweder Oder\n\n<-- Tatoo | Pircing -->",
                "name_1 Entweder Oder\n\n<-- Singen | Tanzen -->",
                "name_1 Entweder Oder\n\n<-- Charakter | Aussehen -->",
                "name_1 Entweder Oder\n\n<-- Intelligenz | Humor -->",
                "name_1 Entweder Oder\n\n<-- Geld | Ruhm -->",
                "name_1 Entweder Oder\n\n<-- Nie mehr Musik | Immer das gleiche Lied -->",
                "name_1 Entweder Oder\n\n<-- Diskutieren | Schweigen -->",
                "name_1 Entweder Oder\n\n<-- Telefonieren | Schreiben -->",
                "name_1 Entweder Oder\n\n<-- Reisen | Zuhause -->",
                "name_1 Entweder Oder\n\n<-- Ehrlichkeit | Notlügen -->",
                "name_1 Entweder Oder\n\n<-- Geld ausgeben | Sparen -->",
                "name_1 Entweder Oder\n\n<-- Kinder | Keine Kinder -->",
                "name_1 Entweder Oder\n\nNutella\n\n<-- Mit Butter | Ohne Butter -->",
                "name_1 Entweder Oder\n\nBeim Brötchen\n\n<-- Obere Hälfte | Untere Hälfte -->",

                // Switching drinks
                "name_1 tausche das Getränk vor dir mit dem Rechts von dir",
                "name_1 tausche das Getränk vor dir mit dem Rechts von dir",
                "name_1 tausche das Getränk vor dir mit dem von name_2",
                "name_1 tausche das Getränk vor dir mit dem von name_2",
                "name_1 tausche das Getränk vor dir mit dem von name_2",
                "name_1 tausche das Getränk vor dir mit dem Links von dir",
                "name_1 tausche das Getränk vor dir mit dem Links von dir",
                "name_1 tausche das vor dir stehende Getränk mit name_2s Getränk und fülle dir ein",

                // Filling glass
                "name_1 schenke dir von dem Getränk vor dir nach",
                "name_1 schenke dir von dem Getränk vor dir nach",
                "name_1 schenke dir von dem Getränk vor dir nach",
                "name_1 schenke dir von dem Getränk vor dir nach",
                "name_1 schenke dir mit dem Getränk vor dir nach",
                "name_1 schenke dir mit dem Getränk vor dir nach",
                "name_1 schenke allen mit dem Getränk vor dir nach",
                "name_1 schenke allen mit dem Getränk vor dir nach",
                "name_1 schenke allen mit dem Getränk vor dir nach",
                "name_1 schenke allen mit dem Getränk vor dir nach",
                "Hyperversager\n\nJeder darf name_1 einen Schluck eines belibigen Getränks einschütten"
        ));

        spicyMit.getList().addAll(Arrays.asList(
                ""
        ));

        vorgluehenMit.getList().addAll(Arrays.asList(
                ""
        ));

        kennenlernenMit.getList().addAll(Arrays.asList(
                ""
        ));

        challengesMit.getList().addAll(Arrays.asList(
                ""
        ));

        challengesMitFertig.getList().addAll(Arrays.asList(
                ""
        ));
    }

    /**
     * A getter method for a specific type of questions
     *
     * @param typ   The type of questions to get
     * @param modus The mode of questions to get
     * @return      A list of questions depending on the type and mode
     */
    public FragenMitTyp get(FragenTypen typ, int modus){
        if (modus == 1){
            switch (typ){
                case STANDART: return standart;
                case SPICY: return spicy;
                case VORGLUEHEN: return vorgluehen;
                case KENNENLERNEN: return kennenlernen;
                case CHALLENGES: return challenges;
                default: return null;
            }
        } else if (modus == 0){
            switch (typ){
                case STANDART: return standartMit;
                case SPICY: return spicyMit;
                case VORGLUEHEN: return vorgluehenMit;
                case KENNENLERNEN: return kennenlernenMit;
                case CHALLENGES: return challengesMit;
                default: return null;
            }
        } else {
            return null;
        }
    }

    /**
     * A getter for the resolutions of the challenges
     *
     * @param modus The mode of resolutions to get
     * @return      A list of resolutions depending on the mode
     */
    public FragenMitTyp getChallengesFertig(int modus){
        return(modus == 1)? challengesFertig:challengesMitFertig;
    }

}
