import aplication.Application;
import util.ProgramSetup;

/**
 * Created by Patrik Melander
 * Date: 2022-02-07
 * Time: 20:14
 * Project: ISBN-programmeringsuppgift
 * Copyright: MIT
 */
public class Main {
    public static void main(String[] args) {
        ProgramSetup programSetup = new ProgramSetup();
        String configPath = programSetup.init(args);
        Application app = new Application();
        app.run(configPath);
    }
}
