package org.example;

public class TestPrint {
    public static void main(String[] args) {

        //Print 10 to 100
        for (int j = 1; j < 11; j++) {
            System.out.println(j * 10);
        }
        //Print 0 to 10
        for (int j = 10; j >= 0; j--) {
            System.out.println(10 - j);
        }
        //Print A to Z
        for (char c = 'a'; c <= 'z'; c++){
            System.out.println(c);
        }
    }
}
