package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.company.Main.wordSet;

/**
 * Created by admin on 08.04.2017.
 */
public class Searcher extends Thread {
    String res;

    public Searcher(String res) {
        this.res = res;
        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        File file = new File(res);
        Matcher m;

        try {
            Scanner scanner = new Scanner(file);
            String word;

            while (scanner.hasNext()) {
                word = scanner.next();

                if (Pattern.compile("[a-zA-Z]+").matcher(word).matches()) {
                    System.out.println("File "+file+" has eng word");
                    return;
                }
                word = word.replaceAll("[^а-яА-Я]+", "");

                //synchronized (wordSet) {
                    if (!wordSet.add(word)) {
                        System.out.println("word ''"+word+"'' repeated in file "+res);
                        return;
                    }
                //}

                System.out.println(word);
            }

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }
    }

}
