import java.util.List;

public class doctor_portal_DAO {
    private UserDAO userDAO;
    private HealthInfoDAO healthInfoDAO;
    
    public doctor_portal_DAO() {
        userDAO = new UserDAO();
        healthInfoDAO = new HealthInfoDAO();
    }

    public Doctor getDoctorById(int doctorId) {
        User user = userDAO.getUserById(doctorId);
        Doctor doctor = new Doctor(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.isAdmin(), user.getMedLicenseNum(), user.getSpecialization());
        return doctor;
    }

    public List<HealthInfo> getHealthInfoByPatientId(int patientId) {
        return healthInfoDAO.getHealthInfoByPatientId(patientId);
    }

    public List<MedRemind> getMedRemindByPatientId(int patientId) {
        return healthInfoDAO.getMedRemindByPatientId(patientId);
    }

    public void addHealthInfo(HealthInfo healthInfo) {
        healthInfoDAO.addHealthInfo(healthInfo);
    }

    public void addMedRemind(MedRemind medRemind) {
        healthInfoDAO.addMedRemind(medRemind);
    }

    public void updateHealthInfo(HealthInfo healthInfo) {
        healthInfoDAO.updateHealthInfo(healthInfo);
    }

    public void updateMedRemind(MedRemind medRemind) {
        healthInfoDAO.updateMedRemind(medRemind);
    }

    public void deleteHealthInfo(int healthInfoId) {
        healthInfoDAO.deleteHealthInfo(healthInfoId);
    }

    public void deleteMedRemind(int medRemindId) {
        healthInfoDAO.deleteMedRemind(medRemindId);
    }

    public List<HealthInfo> getHealthInfoByPatientIdAndDate(int patientId, String date) {
        return healthInfoDAO.getHealthInfoByPatientIdAndDate(patientId, date);
    }

    public List<MedRemind> getMedRemindByPatientIdAndDate(int patientId, String date) {
        return healthInfoDAO.getMedRemindByPatientIdAndDate(patientId, date);
    }
}
