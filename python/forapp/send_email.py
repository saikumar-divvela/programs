import smtplib
# python -m smtpd -n -c DebuggingServer localhost:1025
from email.mime.text import MIMEText

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

import requests

def send_simple_message():
    return requests.post(
        "https://api.mailgun.net/v3/sandbox87890528e7b044a3bb2f63198a219d7e.mailgun.org/messages",
        auth=("api", "key-b83e5f211b2a961e3161238837bcc4a3"),
        data={"from": "Mailgun Sandbox <postmaster@sandbox87890528e7b044a3bb2f63198a219d7e.mailgun.org>",
              "to": "saikumar divvela <saikumar.divvela@gmail.com>",
              "subject": "Hello saikumar divvela",
              "text": "Congratulations saikumar divvela, you just sent an email with Mailgun!  You are truly awesome!  You can see a record of this email in your logs: https://mailgun.com/cp/log .  You can send up to 300 emails/day from this sandbox server.  Next, you should add your own domain so you can send 10,000 emails/month for free."})

print (send_simple_message())
