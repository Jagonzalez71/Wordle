import java.io.FileNotFoundException;

// Attributes
public class WordleGame {
  private String answer;
  private WordleLetter[][] guesses;
  private int maxGuesses;
  private int numGuesses;

  // Constructor
  public WordleGame(int puzzleNumber) throws FileNotFoundException {
    this.answer = WordBank.getAnswerForPuzzleNumber(puzzleNumber);
    this.guesses = new WordleLetter[6][5];
    this.maxGuesses = 6;
    this.numGuesses = 0;
  }

  // getter
  public String getAnswer() {
    return answer;
  }

  // our guess method is the backbone behind the wordle program
  public void guess(String guessWord) {
    if (numGuesses >= maxGuesses || isGameWin()) {
      // Game already over, do not accept more guesses
      return;
    }

    // Have our array set to take in the letter guesses from the user
    WordleLetter[] letters = new WordleLetter[5];

    // for loop that helps us go through every letter of the 5-letter word given by the user
    for (int i = 0; i < guessWord.length(); i++) {
      char guessedLetter = guessWord.charAt(i);
      char correctLetter = answer.charAt(i);

      WordleLetter letter = new WordleLetter(guessedLetter);

      // This is what is responsible for checking if the letter is in the word and in the right position
      if (guessedLetter == correctLetter) {
        letter.setColor("green");
      } else if (answer.indexOf(guessedLetter) != -1) {
        letter.setColor("yellow");
      } else {
        letter.setColor("red");
      }

      // here is where we add the new letter with it's assigned color
      letters[i] = letter;
    }

    // Making sure we update the array with every letter and making sure our
    // guesses keep track of how many words have been given
    guesses[numGuesses] = letters;
    numGuesses++;
  }

  // getter
  public int getNumberGuessesSoFar() {
    return numGuesses;
  }

  // getter that helps us with getting the exact number of guesses been made by the user
  public WordleLetter[] getGuess(int guessNumber) {
    // if statement that checks the number of guesses to not go over the
    // allowed 6 guesses that we have set
    if (guessNumber >= 0 && guessNumber < numGuesses) {
      return guesses[guessNumber];
    }
    // Return null for invalid guessNumber
    return null;
  }

  // Method to identify when the game has ended but the user lost because they went over the allowed guess number
  public boolean isGameOver() {
    return isGameWin() || numGuesses >= maxGuesses;
  }

  // method that takes chekWordleLetter to ensure that the letter is right and give back a true to let the user know he is right
  public boolean isGameWin() {
    if (numGuesses > 0) {
      WordleLetter[] latestGuess = guesses[numGuesses - 1];
      return checkWordleLetters(latestGuess, "green");
    }
    return false;
  }

  // Method thats in charge of checking that all letters from the latest guess are returned green
  // by doing so we are able to return it for the isGameWin method
  private boolean checkWordleLetters(WordleLetter[] letters, String color) {
    for (int i = 0; i < letters.length; i++) {
      WordleLetter letter = letters[i];
      if(letter == null){
        return false;
      }
      if(!color.equals(letter.getColor())){
        return false;
      }
    }
    return true;
  }


  // TODO - include the remainder of the below code back in once rest of class is implemented.
  // Do not modify this method implementation.
  public String toString() {
    // result will be used to build the full answer String
    String result = "";
    // for each word guessed so far
    for (int i = 0; i < getNumberGuessesSoFar(); i++) {
       // get each letter of each word
      for (int j = 0; j < 5; j++) {
         // concatenate it to the result
         // WordleLetter's toString() is automatically invoked here.
       result += getGuess(i)[j];
     }
       // new line separator between each word
     result += "\n";
   }
   return result;
 }
}
