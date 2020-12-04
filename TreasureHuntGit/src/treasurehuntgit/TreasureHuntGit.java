package treasurehuntgit;

import java.util.Random;
import java.util.Scanner;

public class TreasureHuntGit {

    private static final String[][] gameBoard = new String[12][12];
    private static int x;
    private static int y;
    private static int score;
    private static int numberOfGuesses;
   

    public static void main(String[] args) {
        setUpGame();

        
        score = 0;
        setUpBoard();
        randomTreasure();

        for (int i = 0; i < numberOfGuesses; i++) {
            userGuessPosition();
            
            System.out.println("You have"+ ((numberOfGuesses-1)-i) +" guesses left.");
        }
        printBoard(); 
        System.out.println("Your final amount of coins is " + score);
        
        
        
    }

    public static void setUpBoard() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                gameBoard[i][j] = "[  ]";

            }
            

        }
    }

    public static void printBoard() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                
                System.out.print(gameBoard[i][j]);
            }
            System.out.println("");

        }

    }

    public static void randomTreasure() {
        Random random = new Random();
        

        int min = (12 * 12) / 4;
        int max = (12 * 12) / 2;

        int numberOfTreasureItems = random.nextInt((max - min) + 1) + min;

        System.out.println("Coin piles possible to find: " + numberOfTreasureItems);

        for (int i = 0; i < numberOfTreasureItems; i++) {
            //random number is 2 digits long
            gameBoard[random.nextInt(12)][random.nextInt(12)] = "[" + (random.nextInt((40 - 10) + 1) + 10) + "]";
        }

    }

    public static void userGuessPosition() {
        while(true){
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Please type in the y coordinate(row) [between 1 and 12]");
            y = input.nextInt() - 1;

            System.out.println("Please type in the x coordinate(column)[between 1 and 12]");
            x = input.nextInt() - 1;
            
            if(x>=0 && x<=12-1 && y>=0 && y<= 12-1){
                checkForTreasure(x ,y);
                    break;
                
            }

        } catch (Exception e) {
            System.out.println("Error" + e);
            System.out.println("Please only use numbers");

        }

    }
    }

    
    public static void checkForTreasure(int x, int y) {
        if (!gameBoard[x][y].substring(1, 3).equals("  ")) {
            score = score + Integer.parseInt(gameBoard[x][y].substring(1, 3));
            System.out.println("Yes! You found a coin pile! Your have is " +score+" coins!");
        }
        else{
            System.out.println("No treasure here. Your have "+score+" coins :/");
        }
    }
    public static void setUpGame() {
        while (true) {
            try {
                Scanner input=new Scanner(System.in);
                System.out.println("How many guesses would you like?");
                numberOfGuesses = input.nextInt();
                
                if(12>=2 && numberOfGuesses>=2){
                    break;
                }
            } catch (Exception e) {
                System.out.println(" incorrect inputs. The board size should be a positive number more than 2, and the guesses should be a positive number more than 2");
            }
            System.out.println("That input was not correct. Please check carefully.");
        }
    

}
}