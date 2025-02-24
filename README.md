# Hangman-Game

### Student: Osmonov Erjan  
### Group: COMCEH24  
## Description  
### This is a Java-based implementation of the classic Hangman word-guessing game. The program reads a list of words from a file (words.txt), selects a random word, and allows the player to guess the word by entering letters or the entire word. The game tracks wins and losses, provides feedback on guesses, and offers the option to play multiple rounds.  


## Game Rules
* The player has 7 attempts (lives) to guess the word.  
* The word is displayed as a series of underscores (_), each representing a letter.  
* The player can:  
* Guess a single letter (e.g., "a").  
* Guess the entire word (e.g., "shadow").  
* Correct letter guess: The letter appears in all matching positions; lives remain unchanged.  
* Incorrect letter guess: Lives decrease by 1.  
* Correct word guess: The game ends with a win.  
* Incorrect word guess: Lives decrease by 2.  
* The game ends when:  
* The word is fully guessed (win).  
* Lives reach 0 (loss).  
* After each game, the player can choose to play again.  
## Documentation  
### Key Features  
#### Word Selection:  
* Reads words from words.txt into an ArrayList.  
* Uses Random to select a word from the list.  
#### Input Validation:  
* Rejects empty input.  
* Rejects numbers.  
* Prevents repeated letter guesses.  
#### Gameplay:  
* Displays the current state of the word and remaining lives.  
* Updates the word display based on correct guesses.  
* Adjusts lives based on incorrect guesses.  
#### Endgame:  
* Congratulates the player on a win or reveals the word on a loss.  
* Updates win/loss stats.  
* Prompts to play again (1 = yes, anything else = no).  
