package util;


import aplication.Logging;

public class ProgramSetup {
    public static String cPath = "./";
    Logging logging = new Logging();

    /**
     * Checks how many arg user sends,
     * @param args = flags in terminal
     * @return cPath to testdata
     */

    public String init(String[] args){
        System.out.println("Program starting...");
        if (args.length==0){
            System.out.println(logging.getMissingArgsMessage());
            cPath = "./testdata.txt"; //för att testköra via intelliJ
            //System.exit(0);
        }else if(args.length>1) {
            System.out.println(logging.getToManyArgsMessage());
        }else{
            handleIncomingArgs(args);
        }

    return cPath;
    }

    /**
     * Checks if flags is -cPath: or -help:, other flags are not valid
     * @param args
     */
    private void handleIncomingArgs(String[] args) {
        String s = args[0];
        if (s.startsWith("-cPath:")) {
            cPath = args[0].substring("-cPath:".length());
        } else if (s.startsWith("-help:")) {
            System.out.println(logging.getHelpMessage());
            System.exit(0);
        }else{
            System.out.println(logging.getNoValidArgsMessage());
            System.exit(0);
        }
    }
}
