package com.reminder.reminderservice.mdeicationrepository;

import com.reminder.reminderservice.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalTime;
import java.util.List;

public interface MedicationRepository extends JpaRepository<Medication, Integer> {
    @Query("select m from Medication m where m.reminderTime=localTime")
    List<Medication> findAllByReminderTime(LocalTime localTime);
}
