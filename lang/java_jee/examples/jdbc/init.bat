echo off
set OPTION=%1
set MYSQL=%MYSQL_HOME%\bin\mysql.exe

if "%MYSQL_HOME%" == " " goto SQL_ERROR

if "%OPTION%" == "clean" goto CLEAR

echo Creating test database ...
%MYSQL% -u root -f -w < createDatabase.sql
goto END

:CLEAR
echo Removing testdb and  test user ...
%MYSQL% -u root -f -w < cleanDatabase.sql
goto END

:SQL_ERROR
echo ERROR: mysql home is not set...

:END
echo Done