# BookshoutRPCMicroServiceJava

## Setup
```
  git clone git@github.com:EricRoos/BookshoutRPCMicroServiceJava.git
```

### For Eclipse
Import as maven project. Then setup a maven build:

```
Right click project > Run as > Maven Build...

```

For goals put:
```
clean install org.javalite:activejdbc-instrumentation:1.4.12:instrument exec:java -Dexec.mainClass="PromoServiceDriver"
```

Create Multiple builds for each service you expect and replace PromoServiceDriver with the fully qualified class name for the class
that contains a main function you want to execute.


### Other IDEs
No clue... Sorry. Feel free to edit in whatever you like. See below for commands to run on the command line to run code locally.



### Command Line
if maven is not installed
```
  brew install mvn
```
Edit your code in vim, emacs, whatever. I appluad your effort. To run your main class:
```
  mvn clean install org.javalite:activejdbc-instrumentation:1.4.12:instrument exec:java -Dexec.mainClass="PromoServiceDriver"
```
