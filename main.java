import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class main {     // Main    
    public static void main(String[] args) {
        // Game stats
        int wins = 0;
        int losses = 0;

        Scanner input = new Scanner(System.in);
        boolean playAgain = true;   // boolean for stopping/continuing

        // Play again after finishing
        while (playAgain) {
            System.out.println("Wins: " + wins);
            System.out.println("Losses: " + losses);
            System.out.println("");

            String word = "";       
            int lives = 7;
            
            // Hangman Word
            Random rand = new Random(); // Random  
    
            try {
    
                File myObj = new File("words.txt"); // Take input from file
    
                Scanner myReader = new Scanner(myObj);
                ArrayList<String> data = new ArrayList<String>();   // Arraylist
    
                while (myReader.hasNextLine()) {
                    data.add(myReader.nextLine());  // Add everything into an arraylist
                }
    
                int random = rand.nextInt(data.size()); // pick random number from 0 to max size of array
                word = data.get(random);    // Get random word
                myReader.close();
            
            } catch (FileNotFoundException e) {
    
                System.out.println("An error has occured");
                e.printStackTrace();
    
            }        
    
            char[] guessedWord = new char[word.length()];   // Array for guessed letters
            boolean[] guessedLetters = new boolean[26];     // Guessed letters for repeat check
            
            // Заполнение массива
            // ! System.out.println("word: " + word); // Word Admin
            for (int i = 0; i < guessedWord.length; i++) {
                guessedWord[i] = '_';
            }
    
            // Game
            while(!isWordGuessed(guessedWord) && lives > 0) {
                // Start info
                System.out.println();
                System.out.println("Word: " + String.valueOf(guessedWord));
                System.out.println("Attempts left: " + lives);
                System.out.print("Enter a letter or the whole word: ");
    
                // Initial to check on empty and whole word guess
                String initial = input.nextLine().toLowerCase();
                
                System.out.println("");
                System.out.println("");
                
                // Empty input check
                if (initial.isEmpty()) {
                    System.out.println("Input cannot be empty! ");
                    continue;
                }

                // guessing letter
                char x = initial.charAt(0);

                // check for numbers
                if (Character.isDigit(x)) {
                    System.out.println("Numbers are not allowed! Try again.");
                    continue;
                }
    
                // whole word guessed correctly
                if (initial.length() == word.length() && initial.equals(word)) {
                    for (int i = 0; i < word.length(); i++) {
                        guessedWord[i] = word.charAt(i);
                    }
                    break;
                } 
                // whole word guessed incorrectly
                if (initial.length() == word.length() && !(initial.equals(word))) {
                    lives-=2;
                    System.out.println("Your guess is incorrect! -2 attempts!");
                    continue;
                }
                
                // Repeat check
                if (guessedLetters[x - 'a']) {
                    System.out.println("You've already entered this letter!");
                    continue;
                }
    
                // Repeat check - letter to true
                guessedLetters[x - 'a'] = true;
    
                boolean correctGuess = false;
    
                // Open letter if present
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == x) {
                        guessedWord[i] = x;
                        correctGuess = true;
                    }
                }
    
                // Take away life on wrong guess
                if (!correctGuess) {
                    lives--;
                    System.out.println("No such letter in the word.");
                }
            }
            
            // Game end
            if (isWordGuessed(guessedWord)) {
                System.out.println("Congratulations! You've correctly guessed the word: " + word);
                wins++;
            } else {
                System.out.println("You Lost! The word was: " + word);
                losses++;
            }

            System.out.println("Would you like to play again? \n Write '1' if yes, write anything else if no \n");
            if (!(input.nextLine().equals("1"))) {
                playAgain = false;
            }
    
        }
        input.close();
    }

    // Word found check
    private static boolean isWordGuessed(char[] guessedWord) {
        for (char i: guessedWord) {
            if (i == '_') {
                return false;
            }
        }
    return true;
    }
}
