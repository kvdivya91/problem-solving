package arun;

import java.util.Scanner;

/**
 * Created by dvasanth on 10/01/17.
 */
public class AnagramCheck {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter string 1");
        String str1 = in.nextLine();
        System.out.println("Enter string 2");
        String str2 = in.nextLine();
        int[] arr = new int[26];

        if(str1.length() != str2.length()) {
            System.out.println("Not anagram");
            return;
        }

        for (int i = 0; i < str1.length(); i++) {
            ++arr[str1.charAt(i) - 97];
        }

        for (int i = 0; i < str2.length(); i++) {
            --arr[str2.charAt(i) - 97];
        }

        for (int i = 0; i < 26; i++) {
            if(arr[i] != 0) {
                System.out.println("Not anagram");
                return;
            }
        }

        System.out.println("Anagram");

    }
}
