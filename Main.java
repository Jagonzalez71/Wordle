import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    // Do not modify the method signature.
    public static WordleGame startGame(Scanner scanner) throws FileNotFoundException {
        // We initialize puzzleNumber with -1 so that we are able to choose from 0 to 2315
        int puzzleNumber = -1;

        // A while loop allows us to reapeat the question every time startGame is called upon
        while(puzzleNumber < 0 || puzzleNumber > 2315){
            System.out.println("Please enter a number from 0 to 2315: ");

            // we do !scanner so that incase anything but a number is inputed by the user it is caught
            while(!scanner.hasNextInt()){
                System.out.println("Please input a valid number...");
                scanner.next();
            }
            //the user input is saced into puzzleNumber
            puzzleNumber = scanner.nextInt();      
        }
        // here we return a new WordleGame instance once a valid number has been inputed.
        return new WordleGame(puzzleNumber);
    }

    // Do not modify the method signature.
    public static void playGame(Scanner scanner, WordleGame game) throws FileNotFoundException {
        // By having !game we are able to call upon the method and keep playGame 
        // repeating until the user has either guess the word or not
        while(!game.isGameOver()){
            System.out.println("Please enter a 5-letter guess: ");
            String guess = scanner.next().toLowerCase();

            // This helps us identify if a word inputed by the user is in the dictionary
            while(!WordBank.checkInDictionary(guess) || guess.length() !=5){
                System.out.println("Invalid Word!! Please try again!!");
                guess = scanner.next().toLowerCase();
            }
            game.guess(guess);

            System.out.println(game.toString());
        }
    }

    // Do not modify the method signature.
    public static void reportGameOutcome(WordleGame game) {
        if(game.isGameWin()){
            System.out.println("You Won!");
        } else {
            System.out.println("The answer was " + game.getAnswer());
        }
    }

    // This main method body should not be modified.
    public static void main(String[] args) throws FileNotFoundException {
        // Only use this Scanner for user input, do not create new ones via `new Scanner(System.in)`.
        Scanner scanner = new Scanner(System.in);
        WordleGame game = startGame(scanner);
        playGame(scanner, game);
        reportGameOutcome(game);
    }
}
