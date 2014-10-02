package config.compile;

import config.SystemConfiguration;

import javax.tools.*;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class JavaCompiler {
    private final javax.tools.JavaCompiler compiler;
    private final File sourceRoot;

    public JavaCompiler(File sourceRoot) {
        this.sourceRoot = sourceRoot;
        this.compiler = ToolProvider.getSystemJavaCompiler();
    }

    @SuppressWarnings("unchecked")
    public SystemConfiguration compile(JavaSourceFile configFile) throws Exception {
        compiler.run(null, null, null, configFile.path());

        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { sourceRoot.toURI().toURL() });
        Class<?> clazz = Class.forName(configFile.binaryName(), true, classLoader);

        return (SystemConfiguration) clazz.newInstance();
    }
}
