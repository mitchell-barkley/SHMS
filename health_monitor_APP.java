import java.util.List;

public class health_monitor_APP {
    private static doctor_portal_DAO doctorPortalDAO = new doctor_portal_DAO();
    private static user user = new user(1, "John", "Doe", "drjohn@med.com", "drjohn", true);
    
    public static void main(String[] args) {
        while (true) {
            // Get user input
            System.out.println("Enter your user ID:");
            int userId = Integer.parseInt(System.console().readLine());
            System.out.println("Enter your password:");
            String password = System.console().readLine();

            // Check if user is valid
            if (user.getId() == userId && user.getPassword().equals(password)) {
                System.out.println("Welcome, " + user.getFirstName() + " " + user.getLastName() + "!");
                break;
            } else {
                System.out.println("Invalid user ID or password. Please try again.");
            }

            if (user.isAdmin()) {
                // Get health info by patient id
                health_info healthInfo = doctorPortalDAO.getHealthInfoByPatientId(1);
                System.out.println(healthInfo);
                
                // Get med remind by patient id
                List<med_remind> medRemind = doctorPortalDAO.getMedRemindByPatientId(1);
                for (med_remind medRemindItem : medRemind) {
                    System.out.println(medRemindItem);
                }
            }

            if (!user.isAdmin()) {
                // Create a new health_info object
                health_info healthInfo = new health_info(1, 1, 150.0, 140.0, 5.5, 25, 10000, 70, "2021-10-01");
                
                // Create a new med_remind object
                med_remind medRemind = new med_remind(1, 1, "Ibuprofen", "200mg", "3 times a day", "2021-10-01", "2021-10-10");
                
                // Add health info to the database
                doctorPortalDAO.addHealthInfo(healthInfo);
                
                // Add med remind to the database
                doctorPortalDAO.addMedRemind(medRemind);
                
                // Get health info by patient id
                health_info healthInfoById = doctorPortalDAO.getHealthInfoByPatientId(1);
                System.out.println(healthInfoById);
                
                // Get med remind by patient id
                List<med_remind> medRemindByPatientId = doctorPortalDAO.getMedRemindByPatientId(1);
                for (med_remind medRemindItem : medRemindByPatientId) {
                    System.out.println(medRemindItem);
                }
                
                // Update health info
                healthInfo.setWeight(160.0);
                doctorPortalDAO.updateHealthInfo(healthInfo);
                
                // Update med remind
                medRemind.setDosage("400mg");
                doctorPortalDAO.updateMedRemind(medRemind);
                
                // Delete health info
                doctorPortalDAO.deleteHealthInfo(1);
                
                // Delete med remind
                doctorPortalDAO.deleteMedRemind(1);
                
                // Get health info by patient id and date
                List<health_info> healthInfoByPatientIdAndDate = doctorPortalDAO.getHealthInfoByPatientIdAndDate(1, "2021-10-01");
                for (health_info healthInfoItem : healthInfoByPatientIdAndDate) {
                    System.out.println(healthInfoItem);
                }
            }
        }
    }
}

    //     // Create a new doctor object
    //     doctor doctor = new doctor(1, "John", "Doe", "doctorjohn@gmail.com", "drjohn", true);
    //     System.out.println(doctor);

    //     // Get doctor by ID
    //     doctor doctorById = doctor_portal_DAO.getDoctorById(1);
    //     System.out.println(doctorById);

    //     // Create a new patient object
    //     user patient = new user(1, "Jane", "Doe", "jdoe@gmail.com", "janedoe", false);
    //     System.out.println(patient);

    //     // Create a new health_info object
    //     health_info healthInfo = new health_info(1, 1, 150.0, 140.0, 5.5, 25, 10000, 70, "2021-10-01");
        
    //     // Create a new med_remind object
    //     med_remind medRemind = new med_remind(1, 1, "Ibuprofen", "200mg", "3 times a day", "2021-10-01", "2021-10-10");
        
    //     // Add health info to the database
    //     doctorPortalDAO.addHealthInfo(healthInfo);
        
    //     // Add med remind to the database
    //     doctorPortalDAO.addMedRemind(medRemind);
        
    //     // Get health info by patient id
    //     health_info healthInfoById = doctorPortalDAO.getHealthInfoByPatientId(1);
    //     System.out.println(healthInfoById);
        
    //     // Get med remind by patient id
    //     List<med_remind> medRemindByPatientId = doctorPortalDAO.getMedRemindByPatientId(1);
    //     for (med_remind medRemindItem : medRemindByPatientId) {
    //         System.out.println(medRemindItem);
    //     }
        
    //     // Update health info
    //     healthInfo.setWeight(160.0);
    //     doctorPortalDAO.updateHealthInfo(healthInfo);
        
    //     // Update med remind
    //     medRemind.setDosage("400mg");
    //     doctorPortalDAO.updateMedRemind(medRemind);
        
    //     // Delete health info
    //     doctorPortalDAO.deleteHealthInfo(1);
        
    //     // Delete med remind
    //     doctorPortalDAO.deleteMedRemind(1);
        
    //     // Get health info by patient id and date
    //     List<health_info> healthInfoByPatientIdAndDate = doctorPortalDAO.getHealthInfoByPatientIdAndDate(1, "2021-10-01");
    //     for (health_info healthInfoItem : healthInfoByPatientIdAndDate) {
    //         System.out.println(healthInfoItem);
    //     }
    // }
