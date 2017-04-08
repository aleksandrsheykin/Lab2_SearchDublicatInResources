package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

        try {
            Scanner scanner = new Scanner(file);

            scanner.next();
            /*while (scanner.hasNext()) {
                System.out.println("1");
                System.out.println(scanner.next());
            }*/

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }
    }

}
