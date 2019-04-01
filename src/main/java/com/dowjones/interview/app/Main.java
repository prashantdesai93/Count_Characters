package com.dowjones.interview.app;

import com.dowjones.interview.exception.InvalidRangeException;
import org.omg.IOP.ExceptionDetailMessage;

import static com.dowjones.interview.app.CountCharacters.countChars;

/**
 * This can be used to run the application for various inputs,
 * in case it's not possible to run test cases
 */
public class Main {
    public static void main(String[] args) {
        /**
         * Inside main method it will call one caller function which accepts start number, finish number and expected output
         */
        caller(10,13," "+"TenElevenTwelveThirteen".length());
        caller(99,99," "+"NinetyNine".length());
        caller(0,0," "+"Zero".length());
        caller(1000,1000," "+"OneThousand".length());
        caller(-1,-1,"Range is not valid");
        caller(1001,1001,"Range is not valid");
    }

    /**
     * This method will print the Start and Finish number with actual output and expected output.
     * Method: caller
     * @param start
     * @param finish
     * @param expected
     */
    public static void caller(int start,int finish,String expected){
        try{
            System.out.println("Start: "+start+" Finish: "+finish+"\t Actual length of characters: " + countChars(start,finish)+" Expected length of characters: "+expected);
        }catch (InvalidRangeException i ){
            System.out.println("Start: "+start+" Finish: "+finish+"\t Actual: "+i.getMessage()+" Expected: "+expected);
        }catch (Exception e){

        }
    }
}
