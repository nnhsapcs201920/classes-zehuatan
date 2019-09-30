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
    /*
     * String literal
     * is an instance of the String class (not a primitive)
     *  delineated by double quotes
     *  and is defined on a single line
     *  
     *  "ABCDEFGHIJKLMNOPQRSTUVWXYZ" is a String literal
     *  equivalent to: new String "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
     *  
     *  STATIC: one value for the variable for all objects of the class; can be accessed directly
     *  (e.g. CaesarCipher.ALPHABET) - just like Math.PI and System.out 
     */
    
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
        
        System.out.print("Enter the keyphrase (no spaces): ");
        /*
         * The next method returns the next token in the stream as a string
         */
        
        String keyphrase = s.next();
        keyphrase = keyphrase.toUpperCase();
        
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
        
        /*
         * Know how to generate a random number from a range (e.g. between 1-26)
         * We could use the Random class -->
         *      e.g. int randomNumber = randomObject.nextInt(26) + 1;
         * Or, we can use the Math class's Math.random() static method
         *      e.g. int randomNumber = (int) (Math.random() * (max-min+1)) + min);
         *      
         */
        
        int letterIndex = (int) ((Math.random() * 26) + 1);
        System.out.println("Randomly generated value from 1-26:" + letterIndex);
        
        //prepare the keyphrase by removing duplicate letters
        keyphrase = CaesarCipher.compressKeyphrase(keyphrase);
        
        long averageTimeToCrack = CaesarCipher.calculateAverageTimeToCrack(keyphrase.length(), 
        secondsPerGuess);
        
        CaesarCipher.printAverageTimeToCrack(averageTimeToCrack);
        
        String encryptedText = CaesarCipher.encrypt(text, keyphrase);
        System.out.println("Encrypted: " + encryptedText);
        
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
        
        long wholeMinutes = totalSeconds / SECONDS_FOR_EVERY_MINUTE;
        
        /*
         * Use the modulo operator (%) to return the remainder of the division operation.
         * It can be useful when paired with integer division.
         */
        
        long leftoverSeconds = totalSeconds % SECONDS_FOR_EVERY_MINUTE;
        
        long wholeHours = wholeMinutes / MINUTES_FOR_EVERY_HOUR;
        long leftoverMinutes = wholeMinutes % MINUTES_FOR_EVERY_HOUR;
        
        long wholeDays = wholeHours / HOURS_FOR_EVERY_DAY;
        long leftoverHours = wholeHours % HOURS_FOR_EVERY_DAY;
        
        long leftoverYears = wholeDays / DAYS_FOR_EVERY_YEAR;
        long leftoverDays = wholeDays % DAYS_FOR_EVERY_YEAR;
        
        System.out.println("Average time to crack: " + leftoverYears + " years, " 
        + leftoverDays + " days, " + leftoverHours + " hours, " + leftoverMinutes
        + " minutes, " + leftoverSeconds + " seconds.");
        
        /*
         * A conversion is when a data value is converted form one type to another (e.g.
         * int to a double, double to an int, int to a long)
         * 
         * Widening: preserves information (e.g. int to double, int to long)
         * Java automatically does this.
         * 
         * Narrowing (lossy): may lose information (e.g. double to int)
         * 
         * This is a widening conversion (i.e. long to double)
         * 
         */
        
        double yearsAsDecimal = totalSeconds;
        
        /*
         * Arithmetic Promotion
         * 
         * if the two operands are of different types, Java attempts to convert one of the
         * types (widening conversion) and then performs the operation
         * 
         * In this case, both SECONDS_FOR_EVERY_MINUTE and MINUTES_FOR_EVERY_HOUR are
         * ints; so, Java does not perform promotion, and just performs integer multiplication
         */
        
        final long SECONDS_FOR_EVERY_YEAR = SECONDS_FOR_EVERY_MINUTE * MINUTES_FOR_EVERY_HOUR *
        HOURS_FOR_EVERY_DAY * DAYS_FOR_EVERY_YEAR;
        
        /*
         * In this example, the value of SECONDS_FOR_EVERY_YEAR is promoted to a double and then 
         * the floating-point division is performed and assigned to yearsAsDecimal. The local 
         * variable SECONDS_FOR_EVERY_YEAR is still a long and has the same value.
         */
        
        yearsAsDecimal = yearsAsDecimal / SECONDS_FOR_EVERY_YEAR;
        
        System.out.println("or" + yearsAsDecimal + " years");
        
        /*
         * A cast is "I know what I'm doing: trust me" conversion
         * 
         * A cast can perform a narrowing conversion because we are explicitly doing so.
         * 
         * (int) (84.69) --> truncate to an int (84)
         * 
         * 
         * If we want to round a double to the nearest int value, use Math.round static method:
         * 
         *      public static long round( double value );
         *      public static int round( float value );
         *      
         *      The following divides yearsAsDecimal by 10, rounds the result to the nearest decade
         *      and then casts the resulting double to an int.
         */
        int decades = (int) Math.round(yearsAsDecimal / 10);
        System.out.println("or about " + decades + " decades");
        
    }
    
    /**
     * Compresses the specified keyphrase by removing duplicate letters.
     * 
     * @param keyphrase the keyphrase to compress
     * @return the keyphrase with all duplicate letters removed
     */
    public static String compressKeyphrase(String keyphrase)
    {
        String compressedKeyphrase = "";
        
        /*
         * length
         *      returns the number of characters in the string
         */
        
        int keyphraseLength = keyphrase.length();
        
        for(int i = 0; i < keyphraseLength; i++)
        {
            /*
             * charAt
             *      returns the character (of type char) at the specified index (0 based)
             *      
             * C A E S A R
             * 0 1 2 3 4 5  <-- indices
             *      
             * length = 6
             */
            
            char letter = keyphrase.charAt(i);
            
            /*
             * substring
             *      returns part of the string starting at the first index up to, but not including
             *      the second index.
             *      
             *      if only one index is specified, returns part of the string starting at the index
             *      through the end of the string.
             *      
             *  C A E S A R
             *  0 1 2 3 4 5  <-- indices
             */
            
            String restOfKeyphrase = keyphrase.substring(i+1);
            //could be:
            //String restOfKeyphrase = keyphrase.substring(i+1,keyphrase.length());
            
            /*
             * indexOf
             *      returns the index of the start of the first occurence of the specified string
             *      if not found, returns -1
             *      
             * C A E S A R
             * 0 1 2 3 4 5  <-- indices
             * 
             * length = 5
             */
            
            int index = restOfKeyphrase.indexOf(letter);
            
            /*
             * String concatenation
             *      + is the string concatenation operator
             *      concatenates the second string operand to the end of the first string operand
             *      if one or both operands are Strings, + is the string concatenation operator
             *      (operands are converted to Strings)
             */
            
            if(index==-1)
            {
                compressedKeyphrase = compressedKeyphrase + letter;
            }
        }
        return compressedKeyphrase;
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
