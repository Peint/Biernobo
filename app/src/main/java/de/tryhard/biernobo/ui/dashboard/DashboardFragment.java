package de.tryhard.biernobo.ui.dashboard;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import de.tryhard.biernobo.R;


public class DashboardFragment extends Fragment {

    private String[] tasks = {
            "Trinke einen Schluck.",
            "Trinke 2 Schlucke.",
            "Trinke 3 Schlucke.",
            "Trinke 5 Schlucke.",
            "Trinke 10 Schlucke.",
            "Verteile einen Schluck.",
            "Verteile 2 Schlucke.",
            "Verteile 3 Schlucke.",
            "Verteile 5 Schlucke.",
            "Verteile 10 Schlucke.",
            "Exe dein Getränk.",
            "Warheit oder Pflicht.",
            "Ich hab noch nie.",
            "Sage den Zungenbrecher: 'Zehn zahme Ziegen zogen zehn Zentner Zucker zum Zoo' auf, schaffst du es nicht trinke 5 Schlucke.",
            "Alle trinken für jeden Buchstaben in seinem Namen",
            "Jeder der schon einmal ein Traum mit einem Mitspieler hatte trinkt.",
            "Die Person die als letztes Geburtstag hatte trinkt.",
            "Alle die einen Bruder haben trinken.",
            "Alle Männer trinken.",
            "Alle Frauen trinken.",
            "Wer schon einmal jemand aus dieser Runde geküsst hat muss trinken.",
            "Schließe deine Augen und sag welche Farbe das Oberteil von links hat. Falsch.? Dann trink.",
            "Alle die eine Schwester haben trinken.",
            "Alle deren Hausnummer gerade ist trinken.",
            "Du darfst die Mitspieler nur noch mit Nachnamen ansprechen.",
            "Die nächste Person die du berührst muss trinken.",
            "Wähle einen Trinkbuddy für 5 Runden.",
            "Jeder mit schwarzen Socken trinkt.",
            "Alle deren Handy auf dem Tisch liegt muss trinken.",
            "Alle die keine Jeans tragen müssen trinken.",
            "Alle die schon Mal geklaut haben trinken.",
            "Trink wenn du schon Mal schwarz gefahren bist.",
            "Trink wenn du schon Mal schwarz gefahren bist.",
            "Der größte und der kleinste trinken.",
            "Verteile für jeden Buchstaben in deinem Namen.",
            "Alle die schon Mal nackt schwimmen waren trinken.",
            "Trink soviele Schlucke wie du willst, rechts trinkt das doppelte.",
            "Alle die einen \"A\" im Vorname haben trinken.",
            "Warst du schon Mal betrunken in der Schule/Uni wenn ja trink.",
            "Alle die Bock auf Saufen haben stoßen an und nehmen einen kräftigen Schluck.",
            "Alle die ein \"N\" im Nachnamen haben trinken.",
            "Weil wir Freunde sind trinken wir alle ein.",
            "Alle die noch nicht auf Klo waren trinken.",
            "Alle Raucher trinken 1, alle Nichtraucher 3.",
            "Hättest du schon einmal ein Tinder (ect.) Date. Dann trink.",
            "Suche dir jemand aus der jetzt trinkt.",
            "Alle die Sex schonmal außerhalb vom Bett hätten trinken.",
            "Trink wenn du schon Mal Karaoke gesungen haben trinken.",
            "Stelle eine Frage in die Runde, wer zuerst antworte verteilt.",
            "Alle mit Abi trinken.",
            "Trink wenn du nicht alle Star wars Filme gesehen hast."
    };

    public Integer[] taskHistory = {};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        TextView taskPanel = (TextView) rootView.findViewById(R.id.taskPanel);

        Button klickWeiter = (Button) rootView.findViewById(R.id.weiter);
        klickWeiter.setOnClickListener(v -> {
            int randIndex = ThreadLocalRandom.current().nextInt(1, tasks.length);
            taskPanel.setText(tasks[randIndex]);
            taskHistory = append(taskHistory, randIndex);
        });

        Button klickZurueck = (Button) rootView.findViewById(R.id.zurueck);
        klickZurueck.setOnClickListener(v -> {
            if(taskHistory.length > 1) {
                taskHistory = removeLast(taskHistory);
                taskPanel.setText(tasks[taskHistory[taskHistory.length - 1]]);
            }
        });

        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.PlayerSpinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        return rootView;
    }

    private static Integer[] append(Integer[] arr, int element) {
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        list.add(element);
        return list.toArray(new Integer[0]);
    }

    private static Integer[] removeLast(Integer[] arr) {
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        list.remove(arr.length - 1);
        return list.toArray(new Integer[0]);
    }
}