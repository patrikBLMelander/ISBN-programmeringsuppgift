package util;

public class ISBNValidator {
    /**
     * Checks if ISBN 10 are valid
     * @param s ISBN 10 String
     * @return true if valid, fals if not valid
     */

    public boolean checkISBN10(String s) {
        int isbnSum=0;
        int counter = 10;

        for (int i = 0; i < 10; i++) {
            try{
                if (s.charAt(9) == 'X'){
                    isbnSum+= 10*counter;
                }else {
                    isbnSum+= Integer.parseInt(s.substring(i, i + 1)) *counter;
                }
                counter--;
            }catch (NumberFormatException e){
                return false;
            }

        }

        return isbnSum % 11 == 0;
    }
    /**
     * Checks if ISBN 13 are valid
     * @param s ISBN 13 String
     * @return true if valid, false if not valid
     */

    public boolean checkISBN13(String s) {
        int isbnSum=0;

        for (int i = 0; i < 12; i++) {
            try{
                final int isbnSum1 = Integer.parseInt(s.substring(i, i + 1));
                if (i % 2 != 0){
                isbnSum+= isbnSum1 *3;
                }else{
                isbnSum += isbnSum1;
                }
            }catch (NumberFormatException e){
                return false;
            }
        }
        return isbnSum % 10 == 0;
    }
}
