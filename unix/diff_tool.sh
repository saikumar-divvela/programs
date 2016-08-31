#!/bin/bash

# This tool finds the difference of file contents in two directories and writes them in log file

JENKINS_PATH1="/home/sai/project/jenkins-scripts"
JENKINS_PATH2="/home/sai/project/jenkins-spin-code"
TMP_DIR="$HOME/tmp"
LOG_DIR="/home/sai/project"
MISSING_FILES="$LOG_DIR/missing_files.log"

print_info(){
    echo "JENKINS_PATH1:$JENKINS_PATH1"
    echo "JENKINS_PATH2:$JENKINS_PATH2"
    echo "LOG_DIR:$LOG_DIR"
    echo "MISSING_FILES:$MISSING_FILES"
    echo "TMP_DIR:$TMP_DIR" 	
}

do_diff () {
    pushd $1 1>/dev/null
    for file in `find . | cut -d. -f2- | grep -v '^$\|email_templates'`
    do
        file1=$1$file
        file2=$2$file
        if [ ! -d $file1 ]; then
            if [ ! -f $file2 ]; then
                echo "`basename $file1`" >> $MISSING_FILES	
            else
                diff $file1 $file2 >> $LOG_DIR$file'_diff.log'
                rm -f $file2  
                if [ ! -s $LOG_DIR$file'_diff.log' ]; then  
                    rm -f $LOG_DIR$file'_diff.log'
                fi
            fi
        else
	    mkdir $LOG_DIR$file    	
	fi 
    done
    popd 1>/dev/null
}


rm -rf $TMP_DIR
rm -rf $LOG_DIR
mkdir $TMP_DIR
mkdir $LOG_DIR

find $JENKINS_PATH1 -type f -name '*.pyc' -exec rm {} +
find $JENKINS_PATH2 -type f -name '*.pyc' -exec rm {} +

clear
print_info

echo "copying the files from $JENKINS_PATH2 to $TMP_DIR.."
echo "The following files are present in public server and missing in spin server" >> $MISSING_FILES
cp -R $JENKINS_PATH2/* $TMP_DIR
rm -rf $TMP_DIR/requests/email_templates

echo "Finding diff of $JENKINS_PATH1 and $TMP_DIR.."

do_diff $JENKINS_PATH1 $TMP_DIR
echo "\n\nThe following files are present in spin server and missing in public server" >> $MISSING_FILES
ls -lR $TMP_DIR | grep ^- | awk '{print $9}'| sort >> $MISSING_FILES
echo "Done.."




