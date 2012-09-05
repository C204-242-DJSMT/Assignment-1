@echo off

rem javac -classpath junit.jar;. tests.java
javac -classpath junit.jar;. TMTesting.java
@echo finished compiling
pause

java -classpath junit.jar;. org.junit.runner.JUnitCore TMTesting

Pause