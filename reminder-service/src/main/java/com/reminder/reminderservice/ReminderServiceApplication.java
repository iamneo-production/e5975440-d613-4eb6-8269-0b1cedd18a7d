package com.reminder.reminderservice;

import com.reminder.reminderservice.mailsenderservice.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;


@SpringBootApplication
public class ReminderServiceApplication {

	@Autowired
	MailSenderService senderService;
	public static void main(String[] args) {
		SpringApplication.run(ReminderServiceApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendMail()
	{
		senderService.sendReminder();
	}

}
