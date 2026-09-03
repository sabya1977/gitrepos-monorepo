Below is the directory structure of my JavaSpringBoot project (this is to learn core, advanced and Spring framework). I want to use Maven as my build tool. As you see CoreJava has pom.xml, src/main/java/com/corejava and inside this folder I will create a folder for each chapter. My .java programs in these folders has statement as package com.corejava.<chapter_folder>. My git repo would have two branches main and test (taking code from main and test folders respectivly). target/ folder has the executables. 

I want to build similar structure for AdvancedJava and Spring. So please first validate the CoreJava/ structure for Maven, provide pom.xml for this structure (flag if the structure incorrect and suggest a new structure). Second, provide structure for AdvancedJava and Spring (we need to change the current structure) and let me know how to enable Maven for these two structures. 

JavaSpringBoot
│   .gitignore
│
├───.vscode
│       settings.json
│
├───AdvancedJava
│   ├───AdvJava
│   ├───Maven
│   ├───HibernateJPA
│   ├───JDBC
│   ├───JUnit
│   ├───RESTAPI
│   ├───EJB
│   ├───ServletJSP
│   └───Projets
│         ├───Maven
│         ├───JDBC
│         ├───JUnit
│         ├───ServletJSP
│         ├───EJB
│         └───HibernateJPA
│
├───CoreJava
│   │   pom.xml
│   │
│   ├───src
│   │   ├───main
│   │   │   └───java
│   │   │       └───com
│   │   │           └───corejava
│   │   │               ├───demo
│   │   │               │       App.java
│   │   │               │
│   │   │               └───method_overloading
│   │   │                       OverloadingDemo.java
│   │   │
│   │   └───test
│   │       └───java
│   │           └───com
│   │               └───corejava
│   │                       AppTest.java
│   │
│   └───target
│       ├───classes
│       │   └───com
│       │       └───corejava
│       │           ├───demo
│       │           │       App.class
│       │           │
│       │           └───method_overloading
│       │                   Calculator.class
│       │                   OverloadingDemo.class
│       │
│       ├───generated-sources
│       │   └───annotations
│       ├───maven-status
│       │   └───maven-compiler-plugin
│       │       └───compile
│       │           └───default-compile
│       │                   createdFiles.lst
│       │                   inputFiles.lst
│       │
│       └───test-classes
│           └───com
│               └───corejava
│                       AppTest.class
│
├───Misc
│   ├───CloudDeployment
│   ├───DesignPatterns
│   ├───Docker
│   ├───Git
│   ├───HTTPFundamentals
│   └───Maven
├───Notes
│       lessons.md
│
└───Spring
    ├───GettingStarted
    ├───ExploringSpringFramework
    ├───WorkingJavaConfig
    ├───SpringBootGettingStarted    
    ├───SpringJDBC    
    ├───SpringBootWeb
    ├───WebMVC
    ├───SpringBootREST            
    ├───SpringDataJPA
    ├───SpringDataREST
    ├───SpringAOP
    └───Projects
          ├───JobApp 
          ├───SpringBootMVC
          ├───SecuringJobApp
          └───QuizApp
