package Part4.QuadraticEquation.src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a: ");
        double a = sc.nextDouble();
        System.out.println("Enter b: ");
        double b = sc.nextDouble();
        System.out.println("Enter c: ");
        double c = sc.nextDouble();

        QuadraticEquation qe = new QuadraticEquation(a,b,c);

        if (qe.getDiscriminant() > 0){
            System.out.println("The equation has two roots " + qe.getRoot1() + " and " + qe.getRoot2());
        } else if (qe.getDiscriminant() == 0) {
            System.out.println("The equation has one root " + qe.getRoot1());
        }
        else{
            System.out.println("The equation has no real root");
        }
    }
}