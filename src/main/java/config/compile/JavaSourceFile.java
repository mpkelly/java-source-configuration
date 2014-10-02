package config.compile;

import java.io.File;

public class JavaSourceFile {

    private final String fullyQualifiedName;
    private final File parentFolder;

    public JavaSourceFile(File parentFolder, String fullyQualifiedName) {
        this.parentFolder = parentFolder;
        this.fullyQualifiedName = fullyQualifiedName;
        validate();
    }

    public String path() {
        return new File(parentFolder, fullyQualifiedName).getPath();
    }

    public String binaryName() {
        return fullyQualifiedName.replaceAll("\\.java", "").replaceAll("/", ".");
    }

    private void validate() {
        if (fullyQualifiedName.split("\\.").length != 2 ) {
            throw new IllegalArgumentException("path must be a source path separated by forward slashes e.g. /package1/MyClass.java - not: " + fullyQualifiedName);
        }
        if (!fullyQualifiedName.endsWith(".java")) {
            throw new IllegalArgumentException("path must end with .java -  " + fullyQualifiedName);
        }
        if (!new File(path()).exists()) {
            throw new IllegalArgumentException("no file found at: " + path());
        }
    }
}
