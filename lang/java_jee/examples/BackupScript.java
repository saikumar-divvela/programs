import java.io.*;
public class BackupScript{
	private void createBackupScript(String scriptFileName){
		  StringBuffer buffer = new StringBuffer();
		  String backupPartition = new String("/var/lib");
		  String backupPartitionLimit  = new String("100");
		  String backupLocation = new String("/var/lib/mss-backups/");
		  String fileName = new String("msp_backup");
		  String tarFileName = new String("msp_backup.tgz");
		  String listFileName  = new String("msp_backup_filelist");

		  buffer.append("#!/bin/sh\n" + "set -x\n\n");
		  // Check if the partition has enough space
		   buffer.append("### Check if the partition has enough space\n" +
		                    // "diskUsed=`df -k | grep \"" + backupPartition + "\" | awk '{print $5}' | cut -d\"%\" -f1`\n" +
		      			  "  diskUsed=`df -k \"" + backupPartition + "\" | awk '{print $5}' | cut -d\"%\" -f1 | grep -v Use`\n" +
		                    "echo \"Partition " + backupPartition + " is $diskUsed% used.\"\n" +
		                    "if [ \"$diskUsed\" -lt \"" + backupPartitionLimit + "\" ]\nthen\n" +
		                    "  echo \"Starting backup...\"\n\n");

		      // Shutdown semmd
		  buffer.append("  ### Shutdown semm\n" + "  /etc/init.d/semm stop\n" +
		                    "  sleep 2\n\n");
		  buffer.append("  ### Shutdown mysql\n" + "  /etc/init.d/mysql stop\n\n");
		  // Add the tar command to the script
		  buffer.append("  echo \"Creating " + backupLocation + tarFileName + "...\"\n" +
		                    "  tar cvhfz " + backupLocation + tarFileName + " `grep -v \"MSP Version:\" " +
		                                    backupLocation + listFileName + "`\n\n");

		  buffer.append("  ### Check if the partition has enough space left\n" +
		                    //"  diskLeft=`df -k | grep \"" + backupPartition + "\" | awk '{print $5}' | cut -d\"%\" -f1`\n" +
		                    "  diskLeft=`df -k \"" + backupPartition + "\" | awk '{print $5}' | cut -d\"%\" -f1 | grep -v Use`\n" +
		                    "  echo \"Partition " + backupPartition + " is $diskLeft% used.\"\n" +
		                    "  if [ \"$diskLeft\" -gt \"" + backupPartitionLimit + "\" ]\n" +
		                    "  then\n" +
		                    "    ### Failure\n" +
		                    "    echo \"Partition " + backupPartition + " does not have enough space.\"\n" +
		                    "    echo \"Backup " + backupLocation + tarFileName + " will be removed.\"\n" +
		                    "    rm -f " + backupLocation + fileName + "*\n" +
		                    "    echo \"Backup Failed.\"\n" +
		                    "  else\n" +
		                    "    tar tvzf " + backupLocation + tarFileName + " > /dev/null 2>&1\n" +
		                    "    if [ ! -s " + backupLocation + tarFileName + " -o $? -ne 0 ] \n" +
							"    then\n" +
							"      echo \"MSP Backup operation is not successful. The tar file " + backupLocation + tarFileName + " contains errors.\"\n" +
        					"      echo \"Please take the backup again\"\n" +
        					"      touch "+backupLocation+fileName+".err\n" +
		                    "    else \n" +
	 	                    "      ### Success\n" +
		                    "      ### Change the owner, group and permissions for the backup files\n" +
		                    "      chown mss " + backupLocation + fileName + "*\n" +
		                    "      chgrp backup " + backupLocation + fileName + "*\n" +
		                    "      chmod 0660 " + backupLocation + fileName + "*\n" +
		                    "      echo \"Backup Completed.\"\n" +
		                    "    fi\n" +
		                    "  fi\n\n");
		  // Start mysql
      	  buffer.append("  ### Start mysql\n" + "  /etc/init.d/mysql start\n\n");
      	  // Start semmd
    	  buffer.append("  ### Start semm\n" + "  /etc/init.d/semm start\n");
		  buffer.append("  sleep 5\n");
		  buffer.append("else\n" +
		                    "  ### Failure\n" +
		                    "  echo \"Partition " + backupPartition + " does not have enough space.\"\n" +
		                    "  rm -f " + backupLocation + fileName + "*\n" +
		                    "  echo \"Backup Failed.\"\n" +
                  "fi\n");
          try {
          	RandomAccessFile script = new RandomAccessFile(scriptFileName, "rw");
          	script.writeBytes(buffer.toString());
          	script.close();
	  	  } catch(Exception e){
		  		System.out.println("Exception occurred"+e);
		  }


	}
	public static void main(String args[]){
		String scriptFileName = new String("c:\\backup_script");
		BackupScript bk_script = new BackupScript();
		bk_script.createBackupScript(scriptFileName);
	}

}