# Maven Tutorial

## 1. What is Maven

* Maven is a project management and comprehension tool primarily used for Java projects. It handles  two major headaches in software development: Build Automation (compiling, testing, and packaging your code) and Dependency Management (downloading and managing external libraries like JUnit or Spring).

## 2. Module 1: The Core Philosophy of Maven

* Before Maven, Java developers used tools like Ant. Ant was purely a scripting tool—you had to explicitly write scripts telling it exactly how to compile your code, where to put it, and what to name it. If you joined a new team, you had to learn their specific build script from scratch.

* Maven changed this by introducing two revolutionary concepts:
  
  * **Convention over Configuration:** Maven assumes a standard project layout (src/main/java, src/test/java, target/). By adhering to these conventions, you don't need to configure how to build your project; Maven already knows. You only configure what is unique to your project (like its name and dependencies).
  
  * **Dependency Management:** Instead of manually downloading .jar files and committing them to your source control (the old lib/ folder way), you simply declare what you need in a single file (pom.xml). Maven fetches them automatically.

### The Ecosystem: Central vs. Local

* **Maven Central Repository:** A massive, global server on the internet hosting millions of open-source Java libraries (like Spring, JUnit, Apache Commons).

* **Local Repository (~/.m2/repository):** A hidden folder on your computer. When you request a dependency, Maven checks here first. If it's not found, it downloads it from Maven Central and caches it in this .m2 folder forever.

## Module 2: The Anatomy of a Project (The POM)

* The brain of any Maven project is the **pom.xml (Project Object Model)** file located in the root directory.

**The GAV Coordinates:** 

Every artifact (project or library) in the Maven universe must have a unique identifier made of three parts, known as the GAV coordinates:

1. **groupId:** Defines the organization or project group. It generally follows Java package naming rules (e.g., org.springframework, com.yourname).

2. **artifactId:** The specific name of the project or module you are building (e.g., core-java-learning, spring-web).

3. **version:** The version of your project. If it ends in -SNAPSHOT (e.g., 1.0-SNAPSHOT), it means the code is currently in active development and not yet finalized.

**A Minimal pom.xml**

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    
    <!-- Maven Model Version (Always 4.0.0) -->
    <modelVersion>4.0.0</modelVersion>

    <!-- The GAV for THIS project -->
    <groupId>com.corejava</groupId>
    <artifactId>learning-project</artifactId>
    <version>1.0-SNAPSHOT</version>

    <!-- Project-wide variables -->
    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

</project>
```
## Module 3: Dependency Management

* Dependencies are declared inside a <dependencies> block in your POM.

**Scopes:**

Not all dependencies are needed at all times. Maven uses scopes to determine when a library should be included.

**compile (Default):** Available everywhere. Included in the final build. (e.g., Spring Framework).

**test:** Only available in src/test/java. Not included in the final build. (e.g., JUnit).

**provided:** You need it to compile, but the server you deploy to will already have it, so don't include it in the final build. (e.g., Jakarta Servlet API when deploying to Tomcat).

**runtime:** You don't need it to compile your code, but the application needs it to run. (e.g., MySQL JDBC Driver).

**Transitive Dependencies:** If you declare a dependency on Library A, and Library A requires Library B, Maven automatically downloads Library B for you. This is called a transitive dependency. You can view this tree in your terminal using the command: mvn dependency:tree.

## Module 4: The Build Lifecycle and Phases

Maven execution is based on a strict concept called the Build Lifecycle. There are three built-in lifecycles: default (builds your project), clean (cleans up), and site (generates project documentation).

The default lifecycle is the most important. It is divided into sequential phases. The golden rule of Maven is: Executing a phase executes every phase before it in the lifecycle.

**The Key Phases in the Default Lifecycle:**

1. **validate:** Checks if the project structure is correct and all required information is available.

2. **compile:** Translates your raw .java files in src/main/java into compiled .class bytecode.

3. **test-compile:** Compiles the test source code in src/test/java.

4. **test:** Executes unit tests using a framework like JUnit. If a test fails, the build stops immediately.

5. **package:** Takes the compiled code and packages it into a distributable format (like a .jar or .war file) inside the target/ directory.

6. **install:** Copies the final .jar/.war into your local ~/.m2/repository. This allows other Maven projects on your machine to use this project as a dependency.

**Powerful Flags to Know:**

-DskipTests: Example: mvn clean package -DskipTests. This compiles the tests but does not execute them. Useful when you need a quick build and already know the tests pass.

-X: Example: mvn test -X. Turns on extreme debug logging. Use this when a build fails mysteriously and you need to see exactly what Maven is doing behind the scenes.


**Recommended settings.json Configurations**
To make VS Code work perfectly with your new Maven structure, add these specific configurations to your .vscode/settings.json file.

```json
{
    // 1. Tell VS Code to hide the compiled output folders from your file explorer 
    // so they don't clutter your view.
    "files.exclude": {
        "**/target": true,
        "**/.classpath": true,
        "**/.project": true,
        "**/.settings": true,
        "**/.factorypath": true
    },

    // 2. Hide compiled classes from VS Code's global search (Ctrl+Shift+F)
    // so you don't get duplicate search results.
    "search.exclude": {
        "**/target": true
    },

    // 3. Keep the Maven Explorer clean by showing a flat list 
    // rather than deeply nested folder hierarchies.
    "maven.view": "flat",

    // 4. Automatically update your project's build path in VS Code 
    // whenever you change the pom.xml file.
    "java.configuration.updateBuildConfiguration": "automatic",

    // 5. (Optional) Create your own custom "favorite" commands 
    // that will appear at the top of the Maven Explorer.
    "maven.terminal.favorites": [
        {
            "alias": "Clean & Install (Skip Tests)",
            "command": "clean install -DskipTests"
        }
    ]
}
```

```ps1
mvn clean compile

mvn exec:java "-Dexec.mainClass=edu.corejava.ArrayCreation"
```

```yml
java -cp target/core-java-lessons-1.jar edu.corejava.Arrays.ArrayCreation
```