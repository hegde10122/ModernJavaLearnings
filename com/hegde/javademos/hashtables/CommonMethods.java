package com.hegde.javademos.hashtables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Hegde on 01-08-2015.
 */
public class CommonMethods {

    public int getInt() throws IOException {

        String s = getString();
        return Integer.parseInt(s);
    }

    public String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
