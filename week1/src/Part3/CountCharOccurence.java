package Part3;

import java.util.Scanner;

public class CountCharOccurence {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string length: ");
        int length = sc.nextInt();

        String str = randomString(length);
        System.out.println("Genrated string: " + str);
        System.out.println("Enter character to count: ");
        char c = sc.next().charAt(0);

        System.out.println("Number of character " + c + " in string is: " + countChar(c, str));


    }

    public static String randomString(int size){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++){
            sb.append(Character.toString((char)((Math.random() * (122 - 97)) + 97)));
        }
        return sb.toString();
    }

    public static int countChar(char c, String str){
        int count = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == c) count++;
        }
        return count;
    }
}