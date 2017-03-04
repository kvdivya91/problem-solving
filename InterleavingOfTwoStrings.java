import java.util.Scanner;

/**
 * Created by dvasanth on 04/03/17.
 */
public class InterleavingOfTwoStrings {

    public static void main (String[] args) {
        int str1Ind = 0;
        int str2Ind = 0;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter string 1: ");
        String str1 = in.nextLine();
        int len1 = str1.length();

        System.out.println("Enter string 2: ");
        String str2 = in.nextLine();
        int len2 = str2.length();

        System.out.println("Enter string 3: ");
        String str3 = in.nextLine();
        int len3 = str3.length();

        if ((len1 + len2) != len3) {
            System.out.println("Invalid shuffle");
            return;
        }

        int i;
        for (i = 0; i < len3; i++) {
            if(str1Ind < len1 && str3.charAt(i) == str1.charAt(str1Ind)) {
                ++str1Ind;
            } else if (str2Ind < len2 && str3.charAt(i) == str2.charAt(str2Ind)) {
                ++str2Ind;
            } else {
                break;
            }
        }

        if (str1Ind == len1 && str2Ind == len2) {
            System.out.println("Valid shuffle");
        } else {
            System.out.println("Invalid shuffle");
        }
    }
}
