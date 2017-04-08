package com.company;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static volatile WordSet wordSetObject = new WordSet();

    public static void main(String[] args) {
        String resources[] = new String[] {"1.txt", "2.txt", "3.txt"};

        Thread t[] = new Thread[resources.length];

        for (int i=0; i<resources.length; i++) {
            t[i] = new Searcher(resources[i]);
        }

    }
}
