import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class med_remind_manager {
    private List<med_remind> reminders;

    public med_remind_manager() {
        reminders = new ArrayList<>();
    }

    public void addReminder(med_remind reminder) {
        reminders.add(reminder);
    }

    public List<med_remind> getRemindersForPatient(int patient_id) {
        List<med_remind> patientReminders = new ArrayList<>();
        for (med_remind reminder : reminders) {
            if (reminder.getPatient_id() == patient_id) {
                patientReminders.add(reminder);
            }
        }
        return patientReminders;
    }

    public List<med_remind> getDueReminders(int patient_id) {
        List<med_remind> dueReminders = new ArrayList<>();
        LocalDateTime currentDT = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for (med_remind reminder : reminders) {
            if (reminder.getPatient_id() == patient_id) {
                LocalDateTime startDate = LocalDateTime.parse(reminder.getStartDate(), formatter);
                LocalDateTime endDate = LocalDateTime.parse(reminder.getEndDate(), formatter);
                if (currentDT.isAfter(startDate) && currentDT.isBefore(endDate)) {
                    dueReminders.add(reminder);
                }
            }
        }
        return dueReminders;
    }
}
