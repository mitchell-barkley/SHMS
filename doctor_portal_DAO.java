import java.util.List;

public class doctor_portal_DAO {
    private user_DAO userDAO;
    private health_info_DAO healthInfoDAO;

    public doctor_portal_DAO(user_DAO userDAO, health_info_DAO healthInfoDAO) {
        this.userDAO = userDAO;
        this.healthInfoDAO = healthInfoDAO;
    }

    public doctor_portal_DAO(user_DAO userDAO) {
        this.userDAO = userDAO;
        this.healthInfoDAO = new health_info_DAO();
    }

    public doctor_portal_DAO(health_info_DAO healthInfoDAO) {
        this.userDAO = new user_DAO();
        this.healthInfoDAO = healthInfoDAO;
    }

    public doctor_portal_DAO() {
        userDAO = new user_DAO();
        healthInfoDAO = new health_info_DAO();
    }

    public static doctor getDoctorById(int doctorId) {
        user user = user_DAO.getUserById(doctorId);
        doctor doctor = new doctor(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.isAdmin());
        return doctor;
    }

    public health_info getHealthInfoByPatientId(int patientId) {
        return healthInfoDAO.getHealthInfoByID(patientId);
    }

    public List<med_remind> getMedRemindByPatientId(int patientId) {
        return healthInfoDAO.getMedRemindById(patientId);
    }

    public void addHealthInfo(health_info healthInfo) {
        healthInfoDAO.createHealthInfo(healthInfo);
    }

    public void addMedRemind(med_remind medRemind) {
        healthInfoDAO.addMedRemind(medRemind);
    }

    public void updateHealthInfo(health_info healthInfo) {
        healthInfoDAO.updateHealthInfo(healthInfo);
    }

    public void updateMedRemind(med_remind medRemind) {
        healthInfoDAO.updateMedRemind(medRemind);
    }

    public void deleteHealthInfo(int healthInfoId) {
        healthInfoDAO.deleteHealthInfo(healthInfoId);
    }

    public void deleteMedRemind(int medRemindId) {
        healthInfoDAO.deleteMedRemind(medRemindId);
    }

    public List<health_info> getHealthInfoByPatientIdAndDate(int patientId, String date) {
        return healthInfoDAO.getHealthInfoByPatientIdAndDate(patientId, date);
    }
}
