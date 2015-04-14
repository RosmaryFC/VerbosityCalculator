package nyc.c4q.ac21;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Calculate the verbosity of a text
 */
public class VerbosityCalculator {
    public static void main(String[] args) {
        double mobyDickTotalNumOfWords = 0;
        double mobyDickTotalNumOfSentences = 0;
        double twoCitiesTotalNumOfWords = 0;
        double twoCitiesTotalNumOfSentences = 0;

        // An abstract representation of a File
        File twoCities = new File("/Users/c4q-rosmary/Desktop/accesscode/VerbosityCalculator/src/nyc/c4q/RosmaryFC/Resources/A Tale of Two Cities by Charles Dickens");
        File MobyDick = new File ("/Users/c4q-rosmary/Desktop/accesscode/VerbosityCalculator/src/nyc/c4q/RosmaryFC/Resources/Moby Dick Or The Whale by Herman Melville");


        try {
            Scanner scTwoCities = new Scanner(twoCities);
            Scanner scMobyDick = new Scanner (MobyDick);

            while(scTwoCities.hasNext()){
                String currentWord = scTwoCities.next();// scans through A Tale of Two Cities word by word
                twoCitiesTotalNumOfWords ++;
                if(currentWord.charAt(currentWord.length() - 1) == '.'){//if last character in word is a period
                    if(wordsToNotContain(currentWord) == true ) { // and if String currentWord is not any in wordsToNotContain method
                        twoCitiesTotalNumOfSentences ++;
                    }
                }
            }

            while (scMobyDick.hasNext()){
                String currentWord = scMobyDick.next();//scans through Moby Dick word by word
                mobyDickTotalNumOfWords ++;
                if(currentWord.charAt(currentWord.length()-1) == '.'){ // if last character in word is a period
                    if(wordsToNotContain(currentWord) == true ) { // and if String currentWord is not any in wordsToNotContain method
                        mobyDickTotalNumOfSentences ++;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Verbosity = (Total number of words)/(Total number of sentences)
        //calculates verbosity up to two decimal points
        DecimalFormat decimal = new DecimalFormat("#.##");
        double twoCitiesVerbosity = (Double.valueOf(decimal.format(twoCitiesTotalNumOfWords/twoCitiesTotalNumOfSentences)));
        double mobyDickVerbosity = (Double.valueOf(decimal.format(mobyDickTotalNumOfWords/mobyDickTotalNumOfSentences)));


        if(twoCitiesVerbosity > mobyDickVerbosity) {
            System.out.println("Charles Dickens is more verbose than Herman Melville");
        }else if (twoCitiesVerbosity < mobyDickVerbosity) {
            System.out.println("Herman Melville is more verbose than Charles Dickens");
        }else if (twoCitiesVerbosity == mobyDickVerbosity){
            System.out.println("Charles Dickens and Herman Melville are equally verbose");
        }

    }
    public static boolean wordsToNotContain (String currentWord) {//kept these Strings in a separate method to add more in the future.
        if(! currentWord.equals("Mr.") && ! currentWord.equals("Mrs.") && ! currentWord.equals("Ms.")) {
            return true;
        }else {
            return  false;
        }

    }


}
