package General_Practice;
import javax.print.DocFlavor;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Created by cap on 4/19/16.
 */
class HamsterShelf{
    private int _numberOfCages;
    private Hamster _hamster[];
    private int points = 0;

    HamsterShelf(int row){
        _numberOfCages = row;
        _hamster = new Hamster[_numberOfCages]; //creates a number of cages that corresponds to _numberOfCages
        allocate_characteristic();

    }

    void allocate_characteristic(){
        for(int row_indx = 0; row_indx < _numberOfCages; row_indx++)
            _hamster[row_indx] = new Hamster(); //creates memory spaces that contain the characteristics of each hamster, separately.

    }

    void create(){
        String _name;
        String _personality;
        String _food;
        String _movie;
        String _view;
        boolean flag;

        try {

            System.out.println("What is your hamster's name? ");
            _name = Hamster_Game_V2.input.next();

            System.out.println("What is your hamster's personality: Nice, Shy, Grumpy ");
            _personality = Hamster_Game_V2.input.next();

            if(_personality.equals("Nice") || _personality.equals("nice") || _personality.equals("Shy") || _personality.equals("shy") || _personality.equals("Grumpy") || _personality.equals("grumpy")){

                System.out.println("What is your hamster's favorite food: Pasta, Chocolate, Sushi ");
                _food = Hamster_Game_V2.input.next();

                if(_food.equals("Pasta") || _food.equals("pasta") || _food.equals("Chocolate") || _food.equals("chocolate") || _food.equals("Sushi") || _food.equals("sushi")){

                    System.out.println("What is your hamster's favorite movie genre: Romance, Comedy, Action ");
                    _movie = Hamster_Game_V2.input.next();

                    if(_movie.equals("Romance") || _movie.equals("romance") || _movie.equals("Comedy") || _movie.equals("comedy") || _movie.equals("Action") || _movie.equals("action")){

                        for(int row_indx = 0; row_indx < _numberOfCages; row_indx++){
                            _hamster[row_indx].setName(_name);
                            _hamster[row_indx].setPersonality(_personality);
                            _hamster[row_indx].setFood(_food);
                            _hamster[row_indx].setMovie(_movie);
                        }
                    }
                    else
                        throw(new InputMismatchException());
                }
                else
                    throw(new InputMismatchException());
            }
            else
                throw (new InputMismatchException());


    }catch(InputMismatchException e) {
            System.out.println("You have inputted an invalid option.\n");
            System.exit(0);
        }


        do {
            System.out.println();
            System.out.println("You have successfully created a hamster. Would you like to view it? (Y)es or (N)o: ");
            _view = Hamster_Game_V2.input.next();

            switch (_view) {
                case "Y":
                case "y":
                case "yes":
                case "Yes":
                case "(Y)":
                case "(y)":
                    view();
                    for(int row_indx = 0; row_indx < _numberOfCages; row_indx++) {
                        System.out.println("It is time to introduce " + _hamster[row_indx].getName() + " to his/her friends!\n");
                    }
                    approach();
                    flag = false;
                    break;
                case "N":
                case "n":
                case "No":
                case "no":
                case "(N)":
                case "(n)":
                    approach();
                    flag = false;
                    break;
                default:
                    flag = true;
                    System.out.println("You have inputted an invalid option.");
            }
        }while(flag);
    }

    void view(){
        for(int row_indx = 0; row_indx < _numberOfCages; row_indx++){
            System.out.println("Name: " + _hamster[row_indx].getName());
            System.out.println("Personality: " + _hamster[row_indx].getPersonality());
            System.out.println("Favorite food: " + _hamster[row_indx].getFood());
            System.out.println("Favorite movie genre: " + _hamster[row_indx].getMovie());
            System.out.println();
        }
    }


    void approach(){
        String option;
        boolean flag;

        do {
            System.out.println();
            System.out.println("Which hamster would you like to approach first: Mimi, Ebichu, FooFoo ");
            option = Hamster_Game_V2.input.next();

            switch (option) {
                case "Mimi":
                    playMimi();
                    flag = false;
                    break;
                case "Ebichu":
                    playEbichu();
                    flag = false;
                    break;
                case "FooFoo":
                    playFooFoo();
                    flag = false;
                    break;
                default:
                    System.out.println("You have inputted an invalid option.");
                    flag = true;
            }
        }while(flag);

    }

    void playMimi(){
        String option;
        boolean flag;

        System.out.println();
        System.out.println("Mimi: Hi...");
        for(int row_indx = 0; row_indx < _numberOfCages; row_indx++){
            if(_hamster[row_indx].getPersonality().equals("Shy") || _hamster[row_indx].getPersonality().equals("shy"))
                points++;
            else if (_hamster[row_indx].getPersonality().equals("Nice"))
                points += 0;
            else
                points--;
        }

        do {
            System.out.println();
            System.out.println("What would you like to give to Mimi: Sushi, Pasta, Chocolate ");
            option = Hamster_Game_V2.input.next();

            switch (option) {
                case "Sushi":
                case "sushi":
                    System.out.println("Mimi: Oh I can't eat raw fish...");
                    System.out.println("You: Oops, sorry.");
                    points--;
                    flag = false;
                    break;
                case "Pasta":
                case "pasta":
                    System.out.println("Mimi: Pasta is nice to eat every now and then..I guess.");
                    System.out.println("You: Yeah, there's this great pasta place I know.");
                    points += 0;
                    flag = false;
                    break;
                case "Chocolate":
                case "chocolate":
                    System.out.println("Mimi: Oh thank you so much! I adore chocolate!");
                    System.out.println("You: Chocolate never fails :) ");
                    points++;
                    flag = false;
                    break;
                default:
                    System.out.println("You have inputted an invalid option.");
                    flag = true;
            }

        }while(flag);

        do {
            System.out.println();
            System.out.println("Mimi: Do you want to go watch a movie with me?" +
                    " Which movie do you want to watch: Comedy, Romance, Action");
            option = Hamster_Game_V2.input.next();

            switch (option) {
                case "Comedy":
                case "comedy":
                    System.out.println("You: I heard the Three Idiots is excellent.");
                    System.out.println("Mimi: Laughing is good I suppose.");
                    points += 0;
                    flag = false;
                    break;
                case "Romance":
                case "romance":
                    System.out.println("Mimi: Lovely! You must be dreamy like me...");
                    System.out.println("You: Life should be romantic.");
                    points++;
                    flag = false;
                    break;
                case "Action":
                case "action":
                    System.out.println("Mimi: Umm...I don't handle adrenaline very well.");
                    System.out.println("You: Oh, I am sure you will be fine.");
                    points--;
                    flag = false;
                    break;
                default:
                    System.out.println("You have inputted an invalid option.");
                    flag = true;
            }
        }while(flag);

        System.out.println();
        System.out.println("It is time to check if Mimi considers you her friend...\n...\n...");

        if(points > 2) {
            System.out.println();
            System.out.println("Congratulations! You have become friends with Mimi.");
            System.out.println();
        }
        else {
            System.out.println();
            System.out.println("Sorry...Mimi hasn't quite warmed up to you. Better luck next time. ");
            System.out.println();

        }

    }

    void playEbichu(){
        String option;
        boolean flag;

        System.out.println();
        System.out.println("Ebichu: Yo! Wassup!");
        for(int row_indx = 0; row_indx < _numberOfCages; row_indx++){
            if(_hamster[row_indx].getPersonality().equals("Nice") || _hamster[row_indx].getPersonality().equals("nice"))
                points++;
            else if (_hamster[row_indx].getPersonality().equals("Shy"))
                points += 0;
            else
                points--;
        }

        do {
            System.out.println();
            System.out.println("What would you like to give to Ebichu: Sushi, Pasta, Chocolate ");
            option = Hamster_Game_V2.input.next();

            switch (option) {
                case "Sushi":
                case "sushi":
                    System.out.println("Ebichu: Man I love sushi!");
                    System.out.println("You: I know right, sushi is the best!");
                    points++;
                    flag = false;
                    break;
                case "Pasta":
                case "pasta":
                    System.out.println("Ebichu: Thanks man for this pasta...I'll uh eat it later.");
                    System.out.println("You: Don't mention it.");
                    points += 0;
                    flag = false;
                    break;
                case "Chocolate":
                case "chocolate":
                    System.out.println("Ebichu: Is today Valentine's Day?");
                    System.out.println("You: Not really...");
                    points--;
                    flag = false;
                    break;
                default:
                    System.out.println("You have inputted an invalid option.");
                    flag = true;
            }

        }while(flag);

        do {
            System.out.println();
            System.out.println("Ebichu: Do you want to go watch a movie with me?" +
                    " Which movie do you want to watch: Comedy, Romance, Action");
            option = Hamster_Game_V2.input.next();

            switch (option) {
                case "Comedy":
                case "comedy":
                    System.out.println("You: I heard the Three Idiots is excellent.");
                    System.out.println("Ebichu: Ooh, that sounds like a funny title.");
                    points++;
                    flag = false;
                    break;
                case "Romance":
                case "romance":
                    System.out.println("Ebichu: Ro-romance?!");
                    System.out.println("You: Sorry, is that too mushy for you?");
                    points--;
                    flag = false;
                    break;
                case "Action":
                case "action":
                    System.out.println("Ebichu: An occasional thrill is welcome.");
                    System.out.println("You: Yeah, action is pretty decent.");
                    points += 0;
                    flag = false;
                    break;
                default:
                    System.out.println("You have inputted an invalid option.");
                    flag = true;
            }
        }while(flag);

        System.out.println();
        System.out.println("It is time to check if Ebichu considers you his friend...\n...\n...");

        if(points > 2) {
            System.out.println();
            System.out.println("Congratulations! You have become friends with Ebhichu.");
            System.out.println();
        }
        else {
            System.out.println();
            System.out.println("Sorry...Ebichu isn't really taken with you. Better luck next time. ");
            System.out.println();

        }
    }

    void playFooFoo(){
        String option;
        boolean flag;

        System.out.println();
        System.out.println("FooFoo: What do you want.");
        for(int row_indx = 0; row_indx < _numberOfCages; row_indx++){
            if(_hamster[row_indx].getPersonality().equals("Grumpy") || _hamster[row_indx].getPersonality().equals("grumpy"))
                points++;
            else if (_hamster[row_indx].getPersonality().equals("Nice"))
                points += 0;
            else
                points--;
        }

        do {
            System.out.println();
            System.out.println("What would you like to give to FooFoo: Sushi, Pasta, Chocolate ");
            option = Hamster_Game_V2.input.next();

            switch (option) {
                case "Sushi":
                case "sushi":
                    System.out.println("FooFoo: You want me to eat this piece of raw fish? You got to be kidding me.");
                    System.out.println("You: Sorry.");
                    points--;
                    flag = false;
                    break;
                case "Pasta":
                case "pasta":
                    System.out.println("FooFoo: Now this is what I call food!");
                    System.out.println("You: You got that right.");
                    points++;
                    flag = false;
                    break;
                case "Chocolate":
                case "chocolate":
                    System.out.println("FooFoo: Do I look like the chocolate type to you?");
                    System.out.println("You: Maybe not...? ");
                    points += 0;
                    flag = false;
                    break;
                default:
                    System.out.println("You have inputted an invalid option.");
                    flag = true;
            }

        }while(flag);

        do {
            System.out.println();
            System.out.println("FooFoo: Let's go watch something." +
                    " Which movie do you want to watch: Comedy, Romance, Action");
            option = Hamster_Game_V2.input.next();

            switch (option) {
                case "Comedy":
                case "comedy":
                    System.out.println("You: I heard the Three Idiots is excellent.");
                    System.out.println("FooFoo: I don't like laughing.");
                    points += 0;
                    flag = false;
                    break;
                case "Romance":
                case "romance":
                    System.out.println("FooFoo: Yuck!");
                    System.out.println("You: Let's watch something else...");
                    points--;
                    flag = false;
                    break;
                case "Action":
                case "action":
                    System.out.println("FooFoo: Now this is what I call a movie.");
                    System.out.println("You: Didn't see you as the action type.");
                    points++;
                    flag = false;
                    break;
                default:
                    System.out.println("You have inputted an invalid option.");
                    flag = true;
            }
        }while(flag);

        System.out.println();
        System.out.println("It is time to check if FooFoo considers you his friend...\n...\n...");

        if(points > 2) {
            System.out.println();
            System.out.println("Congratulations! You have become friends with FooFoo.");
            System.out.println();
        }
        else {
            System.out.println();
            System.out.println("Sorry...FooFoo has no interest in you. Better luck next time. ");
            System.out.println();

        }

    }

}

class Hamster{
    String _name;
    String _personality;
    String _food;
    String _movie;

    void setName(String name){
        _name = name;

    }

    String getName(){
        return _name;
    }

    void setPersonality(String personality){
        _personality = personality;

    }

    String getPersonality(){
        return _personality;
    }

    void setFood(String food){
        _food = food;

    }

    String getFood(){
        return _food;
    }

    void setMovie(String movie){
        _movie = movie;

    }

    String getMovie(){
        return _movie;
    }


    void HamsterFriends(){

        Hamster hamsterOne = new Hamster();
        hamsterOne._name = "Mimi";
        hamsterOne._personality = "Shy";
        hamsterOne._food = "Chocolate";
        hamsterOne._movie = "Romance";

        Hamster hamsterTwo = new Hamster();
        hamsterTwo._name = "Ebichu";
        hamsterTwo._personality = "Nice";
        hamsterTwo._food = "Sushi";
        hamsterTwo._movie = "Comedy";

        Hamster hamsterThree = new Hamster();
        hamsterThree._name = "FooFoo";
        hamsterThree._personality = "Grumpy";
        hamsterThree._food = "Pasta";
        hamsterThree._movie = "Action";
    }
}




public class Hamster_Game_V2 {
    final static int CAGE_ROW = 1;
    public static Scanner input = new Scanner(System.in);
    static String option;

    public static void main(String[] args){
        HamsterShelf myHamsters = new HamsterShelf(CAGE_ROW); //creates a shelf that can hold a different number of cages

        do {
            System.out.println("Welcome to Hamtori Game Version 2! The objective of this game is to " +
                    "create a hamster and become friends with the other 3 hamsters in the cage.\n" +
                    "Would you like to create a hamster? (Y)es or (N)o: ");
            option = Hamster_Game_V2.input.next();

            switch(option){
                case "Y":
                case "y":
                case "Yes":
                case "yes":
                case "(Y)":
                case "(y)":
                    myHamsters.create();
                    break;
                case "N":
                case "n":
                case "No":
                case "no":
                case "(N)":
                case "(n)":
                    System.exit(0);
                    break;
                default:
                    System.out.println("You have inputted an invalid option.");
                    System.out.println();
            }


        }while(true);



    }
}
