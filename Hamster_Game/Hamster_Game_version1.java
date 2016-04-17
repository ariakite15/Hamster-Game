package Hamster_Game;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by cap on 4/16/16.
 */
public class Hamster_Game_version1 {
    static String greeting;
    static int friendship_points;
    static String present;
    static String action;
    static String response;
    static Scanner scan;
    static boolean flag;

    public static void main(String[] args){
        scan = new Scanner(System.in);
        friendship_points = 0;
        System.out.print("Welcome to the \'Hamster Game\'! The goal of this game is to make Hamtori, the hamster, " +
                "your friend by earning friendship points.\nIf you can earn enough friendship points by the time " +
                "the game ends, you win!");
        System.out.println();
        System.out.println();

        System.out.println("How would you like to greet Hamtori?\na) Hello\nb) It's a fat hamster!\nc) Awww...so cute! ");
        greeting = scan.next();

        try{
            if(greeting.charAt(0) < 'a' || greeting.charAt(0) > 'c')
                throw (new InputMismatchException());

            do {
                switch (greeting) {
                    case "a":
                    case "a)":
                    case "Hello":
                    case "hello":
                        System.out.println();
                        System.out.println("Hamtori: *squeak* Hi!");
                        friendship_points++;
                        break;
                    case "b":
                    case "b)":
                    case "It's a fat hamster!":
                        System.out.println();
                        System.out.println("Hamtori: Are you calling me fat?! *rawr* ");
                        friendship_points--;
                        break;
                    case "c":
                    case "c)":
                    case "Awww...so cute!":
                        System.out.println();
                        System.out.println("Hamtori: Hi there ~ 츄 <3 ");
                        friendship_points++;
                        break;
                }
            }while(flag);

            System.out.println();
            System.out.println("What present would you like to give Hamtori?\na) Nail polish\nb) Chocolate\nc) Spider");
            present = scan.next();

            if(present.charAt(0) < 'a' || present.charAt(0) > 'c')
                throw (new InputMismatchException());

            switch(present){
                case "a":
                case "a)":
                    System.out.println();
                    System.out.println("Hamtori: Is this nail polish? But I only have three fingers..hmmm...");
                    friendship_points += 0;
                    break;
                case "b":
                case "b)":
                    System.out.println();
                    System.out.println("Hamtori: CHOCOLATE?! I love it!!");
                    friendship_points++;
                    break;
                case "c":
                case "c)":
                    System.out.println();
                    System.out.println("Hamtori: Ah! It's a spider! OH NO!!");
                    friendship_points--;
                    break;
            }
            System.out.println();

            System.out.println("What would you like to do to Hamtori?\na) Poke\nb) Hug\nc) Tickle ");
            action = scan.next();

            if(action.charAt(0) < 'a' || action.charAt(0) > 'c')
                throw (new InputMismatchException());

            switch(action){
                case "a":
                case "a)":
                    System.out.println();
                    System.out.println("Hamtori: Stop poking my belly fat!!!");
                    friendship_points--;
                    break;
                case "b":
                case "b)":
                    System.out.println();
                    System.out.println("Hamtori: You're a great hugger!");
                    friendship_points++;
                    break;
                case "c":
                case "c)":
                    System.out.println();
                    System.out.println("Hamtori: Oomph! St..stop tickling me!");
                    friendship_points += 0;
                    break;
            }
        }catch(InputMismatchException e){
            System.out.println("You have inputted an invalid option.");
            System.exit(0);
        }
        System.out.println();

        System.out.println("It is time to see if Hamtori accepts you as her friend.\nAre you ready?");
        response = scan.next();

        try {
            if (response.charAt(0) < 'y' || response.charAt(0) > 'y' && response.charAt(0) < 'n' || response.charAt(0) > 'n')
                throw (new InputMismatchException());
        }catch(InputMismatchException e){
            System.out.println("You have inputted an invalid option.");
            System.exit(0);
        }

        switch(response){
            case "y":
            case "Y":
            case "yes":
            case "Yes":
                if(friendship_points > 2)
                    System.out.println("Congratulations! Hamtori is now your friend :)");
                else
                    System.out.println("Too bad..Hamtori does not want to be your friend. ");
                break;
            case "n":
            case "N":
            case "no":
            case "No":
                System.out.println("Too bad you have to see it anyway!");
                if(friendship_points > 2)
                    System.out.println("Congratulations! Hamtori is now your friend :)");
                else
                    System.out.println("Sorry...Hamtori does not want to be your friend. ");
        }

    }

}
