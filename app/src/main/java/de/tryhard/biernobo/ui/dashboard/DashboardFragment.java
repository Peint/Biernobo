package de.tryhard.biernobo.ui.dashboard;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
            "trinke 1",
            "trinke 2",
            "trinke 3",
            "trinke 4",
            "trinke 5",
            "trinke 6",
            "trinke 7",
            "trinke 8",
            "trinke 9",
            "trinke 10"
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