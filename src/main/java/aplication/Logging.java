package aplication;

/**
    Collecting all messages to user
 */
public class Logging {
    public String getMissingArgsMessage(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n");
        sb.append(String.format("%10s %s", "[error]", "You need a -cPath: to add your testdata"));

        return sb.toString();
    }
    public String getToManyArgsMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n");
        sb.append(String.format("%10s %s", "[error]", "You can just use one flag at the time"));

        return sb.toString();
    }
    public String getNoValidArgsMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n");
        sb.append(String.format("%10s %s", "[error]", "no valid flag found, please use -help to get more information"));

        return sb.toString();
    }
    public String getHelpMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n");
        sb.append("Welcome to Patrik Melanders ISBN validator");
        sb.append("\n\n");
        sb.append("This is a application tests if a list of ISBN 10 or ISBN 13 are valid");
        sb.append("\n");
        sb.append("To be able to run this application you need a txt file with a list of ISBN10 or ISBN13");
        sb.append("\n");
        sb.append("it should be one ISBN on each row");
        sb.append("\n\n");
        sb.append("Valid flags are:");
        sb.append("\n");
        sb.append(String.format("%10s %s", "[info]", "-help: to get help message"));
        sb.append("\n");
        sb.append(String.format("%10s %s", "[info]", "-cPath: followed by the path to your test file"));

        return sb.toString();
    }

    public String printFinalResult(int totalTests, int passedTests, int failedTests){
      String finalResult = String.format(""+
              "\n%s\n" +
              "%-20s %s\n" +
              "%-20s %s\n" +
              "%-20s %s","Final result",
              "Total tests:", totalTests,
              "Tests passed:", passedTests,
              "Tests failed:", failedTests);

      return finalResult;
    }

    public void printPassMessage (String ISBN){
        System.out.printf("%10s %s%n", "[success]", ISBN+": did pass");
    }

    public void printFailMessage (String ISBN){
        System.out.printf("%10s %s%n", "[fail]", ISBN+": did fail");
    }

    public void printIsNotISBNMessage(String ISBN) {
        System.out.printf("%10s %s%n", "[fail]", ISBN + " is not a ISBN10 or ISBN 13 number");
    }
}
