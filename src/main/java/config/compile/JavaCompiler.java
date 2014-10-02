package config.compile;

import javax.tools.ToolProvider;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class JavaCompiler {
    private final javax.tools.JavaCompiler compiler;
    private final File sourceRoot;

    public JavaCompiler(File sourceRoot) {
        this.sourceRoot = sourceRoot;
        this.compiler = ToolProvider.getSystemJavaCompiler();
        if (compiler == null) {
            throw new IllegalStateException("javax.tools.JavaCompiler is not available. Ensure you are using the JDK java.exe or have tools.jar on the classpath");
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T compile(JavaSourceFile configFile) throws Exception {
        compiler.run(null, null, null, configFile.path());

        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { sourceRoot.toURI().toURL() });
        Class<?> clazz = Class.forName(configFile.binaryName(), true, classLoader);

        return (T) clazz.newInstance();
    }
}
