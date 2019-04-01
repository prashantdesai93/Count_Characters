package com.dowjones.interview.app;

import com.dowjones.interview.exception.InvalidRangeException;

public class CountCharacters {

    /**
     * This function counts the characters of numbers spelled out in a given range.
     * As per given requirement this function is static. If we want to remove static method then
     * remove static keyword and create instace and access the method.
     * Method: countChars
     * @param start
     * @param finish
     * @return characterCount
     */
    public static int countChars(int start, int finish) throws InvalidRangeException {
        int characterCount = 0;

        /** Check corner cases:
         * If start greater than finish OR
         * If start less than 0 OR
         * finish greater than 1000 then, return 0 */
        if(start > finish || start < 0 || finish > 1000){
            throw new InvalidRangeException("Range is not valid");
        }

        /** Loop through start and finish and get the count of characters */
        for(int i=start; i<=finish; i++){
            characterCount = characterCount + characterCount(i);
        }

        return characterCount;
    }

    /**
     * This function will check the smallest and largest number word count
     * and calls characterCountHelper function to get the count of remaining numbers
     * Method: characterCount
     * @param number
     * @return
     *
     */
    public static int characterCount(int number){
        if(number == 0){
            return "Zero".length();
        }
        if(number == 1000){
            return "OneThousand".length();
        }
        return characterCountHelper(number).length();
    }

    /**
     * This method takes input as a number and returns number of characters as spelled out
     * Method: characterCountHelper
     * @param num
     * @return
     */
    public static String characterCountHelper(int num) {
        // Array of String which contains number spelled out such as 1 to 20, 30, 40, 50, 60, 70, 80, 90
        String[] numberWordArray = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
                "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        StringBuilder numberToWords = new StringBuilder();

        //check condition, and call characterCountHelper function recursively to get the length of each integer with respect to it's place value
        if(num >= 100) {
            numberToWords.append(characterCountHelper(num/100)).append("Hundred").append(characterCountHelper(num%100));
        } else if(num >= 20) {
            numberToWords.append(numberWordArray[(num-20)/10+20]).append(numberWordArray[num%10]);
        } else {
            numberToWords.append(numberWordArray[num]);
        }

        return numberToWords.toString();
    }
}
