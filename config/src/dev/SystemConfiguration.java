package dev;

import config.DefaultSystemConfiguration;

import java.io.File;

public class SystemConfiguration extends DefaultSystemConfiguration {

    @Override
    public File getLogDir() {
        return new File("dev/log");
    }

    public static void main(String[] args) {
        new SystemConfiguration().sanityCheck();
    }
}
