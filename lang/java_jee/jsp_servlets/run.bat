@echo off
rem set pwd=%CD%
rem set TOMCAT_HOME=C:\Saikumar\installed\Tomcat 5.0
rem set CATALINA_BASE=%TOMCAT_HOME%
rem set CATALINA_HOME=%TOMCAT_HOME%
rem set CATALINA_TMPDIR=%TOMCAT_HOME%\temp
rem set JAVA_HOME=C:\Program Files\Java\jdk1.5.0_08\
rem if "%1"=="tom" "C:\Saikumar\installed\Tomcat 5.0\bin\shutdown"
javac -cp .;"C:\Saikumar\installed\Tomcat 5.0\common\lib\servlet-api.jar"  %1.java
copy %1.class "C:\Saikumar\installed\Tomcat 5.0\webapps\servlets\WEB-INF\classes"

