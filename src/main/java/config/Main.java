package config;

import config.compile.*;
import config.compile.JavaCompiler;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("expected exactly one argument for configuration file name e.g. dev/SystemConfiguration.java");
            System.exit(1);
        }

        File configRoot = new File("conf");

        JavaCompiler compiler = new JavaCompiler(configRoot);
        SystemConfiguration configuration = compiler.compile(new JavaSourceFile(configRoot, args[0]));

        System.out.println("Log dir: " + configuration.getLogDir());
        System.out.println("Port: " + configuration.getPort());
    }
}
