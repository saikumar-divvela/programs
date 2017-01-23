
'''
msg={}
msg = MIMEText("hello there")
msg["Subject"] ="test email"
msg["From"]="saikumar.divvela@gmail.com"
msg["To"]="sai.divvela@samsung.com"

smtp_host = "smtp.gmail.com"
smtp_port = 465
gmail_user="saikumar.divvela@gmail.com"
gmail_pwd="neeru$123"


s = smtplib.SMTP(smtp_host,587)
#s = smtplib.SMTP_SSL(smtp_host,465)
s.ehlo()
s.starttls()
s.login(gmail_user, gmail_pwd)
s.sendmail(msg["From"],msg["To"],"hello there")
s.quit()
print ('mail sent')
'''

import smtplib
# python -m smtpd -n -c DebuggingServer localhost:1025
from email.mime.text import MIMEText

# Define to/from
sender = 'admin@rahilo.com'
recipient = 'saikumar.divvela@gmail.com'

# Create message
msg = MIMEText("Message text")
msg['Subject'] = "Test message"
msg['From'] = sender
msg['To'] = recipient

# Create server object with SSL option
server = smtplib.SMTP_SSL('smtp.zoho.com', 465)
# Perform operations via server
server.login('admin@rahilo.com', 'neeru$123')
server.sendmail(sender, [recipient], msg.as_string())
print "sent email"
server.quit()
