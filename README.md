java-source-configuration
=========================

An alternative to *.properties files for Java project configuration. 

Instead of keeping your project's configuration in property files, consider instead keeping it in Java source files which are compiled at runtime using the Java Compiler API (requires tools.jar or JDK). 

Motivation
==========

This approach has the following advantages over property files:

- You don't need to convert property value strings to Java types
- You get type-checking in your IDE
- It is easy to inherit from a default configuration
- You can easily unit test your configuration class or sanity check using reflection

There's very little code required to make this work - much less than more common approaches that use java.util.Properties and generally a set of enums as keys. 

Running the example project
===========================

You can run this example project from the project root like so:

```gradlew build release -Penvironment=prod```
 
or for development 

```gradlew build release -Penvironment=dev```

The configuration source are files copied into the release folder (build/release) from config/src/$environment. 


