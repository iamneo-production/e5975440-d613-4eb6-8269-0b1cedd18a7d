package com.reminder.reminderservice.mailsenderservice;


import com.reminder.reminderservice.mdeicationrepository.MedicationRepository;
import com.reminder.reminderservice.mdeicationrepository.UserRepository;
import com.reminder.reminderservice.model.Medication;
import com.reminder.reminderservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.util.*;

@Service
public class MailSenderService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private MedicationRepository medicationRepository;
    @Autowired

    private UserRepository userRepository;


    public void sendReminder()
    {
        while(true)
        {
            LocalTime time  = LocalTime.now();
            LocalTime currTime = time.minusSeconds(time.getSecond());
            Map<String, List<String>> bodyMap = new HashMap<>();
            List<Medication> medicationList = medicationRepository.findAllByReminderTime(currTime);
            for(Medication med: medicationList)
            {
                List<String> body = new ArrayList<>();
                User user = userRepository.findById(med.getPatientId()).orElseThrow();
                body.add(med.getMedicationName());
                bodyMap.put(user.getEmail(), body);
            }

            for(Map.Entry<String, List<String>> entry : bodyMap.entrySet())
            {
                String body = "Hello here is the your list of medicines to take \n"+entry.getValue()+"\nFrom Team 15";
                sendEmail(entry.getKey(), "Take your Medicine in-time", body);
            }

        }
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void sendMail()
//    {
//        sendService.sendEmail();
//    }



    public void sendEmail(String toEmail, String subject, String body)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("dasarisniz27398@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);

    }

}
