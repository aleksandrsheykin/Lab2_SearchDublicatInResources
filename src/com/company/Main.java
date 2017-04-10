package com.company;

public class Main {
    private static volatile WordSet wordSetObject = new WordSet();
    private static Finisher finisher;

    public static void main(String[] args) {
        String resources[] = new String[] {"1.txt", "2.txt", "3.txt"};
        finisher = new Finisher(resources.length);

        for (int i=0; i<resources.length; i++) {
            new Searcher(resources[i], i, wordSetObject, finisher);
            finisher.addThread(i);
        }

    }
}
