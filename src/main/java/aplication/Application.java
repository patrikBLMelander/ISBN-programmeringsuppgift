package aplication;

import util.ISBNValidator;
import util.InputFileReader;

import java.util.List;

public class Application {
    ISBNValidator isbnValidator = new ISBNValidator();
    Logging logging = new Logging();

    public static int totalTests = 0;
    public static int passedTests = 0;
    public static int failedTests = 0;

    public void run(String path){

        List<String> tests =InputFileReader.readStringFile(path);
        System.out.println("\n Number of tests to run: " + tests.size());
        totalTests=tests.size();
        for (String s : tests) {
            if(s.length()==10){
                boolean didPass = isbnValidator.checkISBN10(s);
                if (didPass){
                    passedTests++;
                    logging.printPassMessage(s);
                }else{
                    failedTests++;
                    logging.printFailMessage(s);
                }

            }else if (s.length()==13){
                boolean didPass = isbnValidator.checkISBN13(s);
                if (didPass){
                    passedTests++;
                    logging.printPassMessage(s);
                }else{
                    failedTests++;
                    logging.printFailMessage(s);
                }
            }else{
                failedTests++;
                logging.printIsNotISBNMessage(s);
            }
        }

        System.out.println(logging.printFinalResult(totalTests, passedTests, failedTests));
        System.exit(0);

    }
}
