import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class health_monitor_APP {
    private static health_info_DAO healthInfoDAO = new health_info_DAO();
    private static med_remind_manager medRemindManager = new med_remind_manager();
    private static doctor_portal_DAO doctorPortalDAO = new doctor_portal_DAO();
    private static recommend_system recommendSystem = new recommend_system();
    
    public static void main(String[] args) {
        // Create health data for a patient
        health_info healthData = new health_info(1, 1, 70.5, 65.0, 170.0, 25, 8000, 80, "2021-10-01");
        
        // Insert health data into the database
        healthInfoDAO.createHealthInfo(healthData);
        
        // Retrieve health data from the database based on ID
        health_info retrievedHealthData = healthInfoDAO.getHealthInfoByID(1);
        System.out.println("Retrieved Health Data: " + retrievedHealthData);
        
        // Retrieve health data from the database based on patient ID and date
        List<health_info> healthInfoList = healthInfoDAO.getHealthInfoByPatientId("2021-10-01");
        System.out.println("Health Data List: " + healthInfoList);
        
        // Update health data in the database
        healthData.setWeight(71.0);
        healthInfoDAO.updateHealthInfo(healthData);
        
        // Delete health data from the database based on ID
        healthInfoDAO.deleteHealthInfo(1);
        
        // Retrieve doctor information by ID
        Doctor doctor = doctorPortalDAO.getDoctorById(1);
        System.out.println("Doctor Information: " + doctor);

        // Retrieve health information for a patient
        List<HealthInfo> patientHealthInfo = doctorPortalDAO.getHealthInfoByPatientId(1);
        System.out.println("Patient Health Information: " + patientHealthInfo);

        // Retrieve medication reminders for a patient
        List<MedRemind> patientMedReminders = doctorPortalDAO.getMedRemindByPatientId(1);
        System.out.println("Patient Medication Reminders: " + patientMedReminders);

        // Add a new health information entry
        HealthInfo newHealthInfo = new HealthInfo(1, 70.5, 65.0, 170.0, 25, 8000, 80, Date.valueOf("2021-10-01"));
        doctorPortalDAO.addHealthInfo(newHealthInfo);

        // Add a new medication reminder
        MedRemind newMedRemind = new MedRemind(1, "Medication Name", "Take 1 pill daily", Date.valueOf("2021-10-01"), Date.valueOf("2021-10-31"));
        doctorPortalDAO.addMedRemind(newMedRemind);

        // Update an existing health information entry
        HealthInfo updatedHealthInfo = new HealthInfo(1, 71.0, 65.0, 170.0, 25, 8000, 80, Date.valueOf("2021-10-01"));
        doctorPortalDAO.updateHealthInfo(updatedHealthInfo);

        // Update an existing medication reminder
        MedRemind updatedMedRemind = new MedRemind(1, "Updated Medication Name", "Take 1 pill daily", Date.valueOf("2021-10-01"), Date.valueOf("2021-10-31"));
        doctorPortalDAO.updateMedRemind(updatedMedRemind);

        // Delete a health information entry
        doctorPortalDAO.deleteHealthInfo(1);

        // Delete a medication reminder
        doctorPortalDAO.deleteMedRemind(1);
    }
}
