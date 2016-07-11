package com.company;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        new Main().input();
    }

    private String keyboard(String message) {
        System.out.print(message + ": ");
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    private void input() {
        String i = keyboard("Input 1 for SAX\n" +
                "Input 2 for DOM\n" +
                "Input 3 for JAXB\n" +
                "Your choice");
        if (i.equalsIgnoreCase("1")) {
            SAX sax = new SAX();
            sax.sax();
        } else if (i.equalsIgnoreCase("2")) {
            DOM dom = new DOM();
            dom.dom();
        } else if (i.equalsIgnoreCase("3")) {
            JAXB jaxb = new JAXB();
            jaxb.jaxb();
        }
    }
}