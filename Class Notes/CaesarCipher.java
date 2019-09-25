import java.util.Scanner;

/**
 * This class encrypts strings with a keyphrase version of the classic
 *      Caesar Cipher.
 *      (as described in The Code Book by Simon Singh)
 *
 * @author ztan
 * @version 23 September 2018
 */
public class CaesarCipher
{
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public static void main(String[] args)
    {
        /*
         * A scanner object parses a primitive type or a String from a stream.
         * 
         * A stream is a sequence of characters from file, String, keyboard, network connection, etc.
         * 
         * Parsing is separating a sequence of characters into tokens based on delimiters.
         * 
         * A token is a meaningful sequence of characters (e.g. word)
         * 
         * Delimiters are characters that separate tokens (by default whitespace (space, tab, newline)
         * is the delimiter
         * 
         * When we create a Scanner object, we must specify the input stream (e.g. System.in 
         * which is the keyboard via the terminal window)
         * 
         */
        
        Scanner s = new Scanner(System.in);
        
        /*
         * Best practice:
         *      1. Prompt the user for what to input
         *      2. Use print rather than println, then the user input immediately folow the colon
         *      3. Leave a space after the colon
         */
        
        System.out.print("Enter the text to encrypt: ");
        
        /*
         * The nextLine method returns all characters up to the end of the line (i.e. where the user typed enter)
         */
        
        String text = s.nextLine();
        text = text.toUpperCase();
        
        System.out.print("Enter the number of seconds to test a guessed keyphrase: ");
        
        /*
         * The nextInt method attempts to convert the next token in the stream to an int
         * and returns the value. If the next token cannot be converted, an exception is generated.
         * The nextDouble method behaves in the same way for doubles.
         */
        
        int secondsPerGuess = s.nextInt();
        
        // test both inputs by saving and printing their values back to the terminal
        System.out.println(text);
        System.out.println(secondsPerGuess);
    }
    
    /**
     * Formats the average time to crack the cipher based on the specified number of seconds and
     * displays it via System.out in several formats.
     * 
     * @param totalSeconds the total number of seconds to crack the cipher
     * 
     * This methods is static and is independent of th estate of a CaesarCipher object. As a result, this method
     * may be invoked on the class instead of on a variable that references an object.
     *      (e.g. CaesarCipher.printAverageTimeToCrack())
     *      
     * Static methods cannot access any instance variables. They can only access static class variables.
     */
    public static void printAverageTimeToCrack(long totalSeconds)
    {
        /*
         * Instead of using "magic numbers" (e.g. 3.14159), use constants defined by us or the Java Standard Library.
         * 
         * For example, in the Math class is defined:
         * public static final double PI = 3.141592654;
         * 
         * Declare a constant with the final keyword. If we try to change the value, a compile error will be generated.
         * By convention, constants are in all caps.
         */
        final int SECONDS_FOR_EVERY_MINUTE = 60;
        final int MINUTES_FOR_EVERY_HOUR = 60;
        final int HOURS_FOR_EVERY_DAY = 24;
        final int DAYS_FOR_EVERY_YEAR = 365;
        
        //SECONDS_FOR_EVERY_MINUTE = 50; cannot reassign to a final variable
        
        /*
         * Use integer division to calculate how many whole minutes based on the 
         * specified number of seconds. 
         * 
         * Integer division (like the // in Python) discards the remainder (truncates)
         * 
         * For example: (3/4) evaluates to 0; (3.0/4) evaluates to .75
         * 
         * In Java, the type of divison executed depends on the type of values (or operands)
         */
        
        long totalMinutes = totalSeconds / SECONDS_FOR_EVERY_MINUTE;
        
        /*
         * Use the modulo operator (%) to return the remainder of the division operation.
         * It can be useful when paired with integer division.
         */
        
        long seconds = totalSeconds % SECONDS_FOR_EVERY_MINUTE;
        
        long totalHours = totalMinutes / MINUTES_FOR_EVERY_HOUR;
        long minutes = totalMinutes % MINUTES_FOR_EVERY_HOUR;
        
        long totalDays = totalHours / HOURS_FOR_EVERY_DAY;
        long hours = totalHours % HOURS_FOR_EVERY_DAY;
        
        long years = totalDays / DAYS_FOR_EVERY_YEAR;
        long days = totalDays % DAYS_FOR_EVERY_YEAR;
        
        System.out.println("Average time to crack: " + years + " years, " + days + " days, "
        + hours + " hours, " + minutes + " minutes, " + seconds + " seconds.");
    }
    
    
    
    
    
    
    /**
     * Encrypts the specified text using the specified keyphrase using a
     *      keyphrase-enhanced Caesar Cipher.
     *      
     *  @param  text        the text to encrypt
     *  @param  keyphrase   the keyphrase with which to encrypt the specified text
     *  @return             the encrypted text
     */
    public static String encrypt(String text, String keyphrase)
    {
        String encryptedText = "";

        /*
         * The keyphrase, after removing any repeated letters is used as the beginning of the
         *      jumbled cipher alphabet. The remainder of the cipher alphabet is merely the
         *      remaining letters of the alphabet, in their correct order, starting where the
         *      keyphrase ends.
         */
        String cipherAlphabet = keyphrase;
        for(int i = 0; i < CaesarCipher.ALPHABET.length(); i++)
        {
            char letter = CaesarCipher.ALPHABET.charAt(i);
            if(keyphrase.indexOf(letter) == -1)
            {
                cipherAlphabet += letter;
            }
        }

        /*
         * For each letter in the text that is a letter, find the corresponding letter
         *      at the same position in the cipher alphabet as its replacement.
         */
        for(int i = 0; i < text.length(); i++)
        {
            char letter = text.charAt(i);

            // if the letter is between A and Z
            if(letter >= 'A' && letter <= 'Z')
            {
                // 65 is the ASCII value of 'A'
                int cipherIndex = letter - 65;
                encryptedText += cipherAlphabet.charAt(cipherIndex);
            }
            else    // don't substitute the letter; just use it as is
            {
                encryptedText += letter;
            }
        }

        return encryptedText;
    }

    /**
     * Calcualtes the average time to crack the cipher, based on the
     *      specified length of the keyphrase and seconds to evaluate
     *      each attempt, using a brute force approach. This calculation
     *      assumes that the cracker knows the length of the keyphrase.
     *      If the length is not know, it will take substantially longer
     *      to crack the cipher. Regardless, this calculation is only
     *      for a brute force approach; other techniques (e.g., frequency
     *      analysis) can crack the cipher extremely quickly.
     *      
     *  @param  keyphraseLength the number of characters in the keyphrase
     *  @param  secPerGuess     the number of seconds to evaluate each attempt
     *  @return                 the average number of seconds to crack the cipher
     */
    public static long calculateAverageTimeToCrack(int keyphraseLength, int secPerGuess)
    {
        final int NUMBER_OF_LETTERS_IN_ALPHABET = 26;
        int lettersRemaining = NUMBER_OF_LETTERS_IN_ALPHABET;
        long combinations = 1;
        
        /*
         * Calculate the number of combintations for the specified keyphrase length.
         *  For example, if the keyphrase is six characters long:
         *      26 * 25 * 24 * 23 * 22 * 21
         *      would be the number of combinations of cipher alphabets for keyphrases
         *      that are six characters long.
         */
        for(int i = 0; i < keyphraseLength; i++)
        {
            combinations *= lettersRemaining;
            lettersRemaining -= 1;
        }

        long worstCaseTimeToCrack = combinations * secPerGuess;

        // average time is half the worst time since the best time is cracking the
        //  cipher on the first attempt
        return worstCaseTimeToCrack/2;
    }
}
