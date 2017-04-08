package com.company;

public class Main {

    public static void main(String[] args) {
        String resources[] = new String[] {"1.txt", "2.txt", "3.txt"};

        Thread t[] = new Thread[resources.length];

        for (int i=0; i<resources.length; i++) {
            t[i] = new Searcher(resources[i]);
        }

    }
}
