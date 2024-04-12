import java.util.ArrayList;
import java.util.List;

public class health_info_DAO {
    public boolean createHealthInfo(health_info healthData) {
        return true;
    }

    public health_info getHealthInfoByID(int id) {
        // Retrieve health data from the database based on ID
        return new health_info(1, 1, 70.5, 65.0, 170.0, 25, 8000, 80, "2021-10-01");
    }

    public List<health_info> getHealthInfoByPatientId(String date) {
        // Retrieve health data from the database based on patient ID and date
        List<health_info> healthInfoList = new ArrayList<>();
        healthInfoList.add(new health_info(1, 1, 70.5, 65.0, 170.0, 25, 8000, 80, "2021-10-01"));
        healthInfoList.add(new health_info(2, 1, 71.0, 65.0, 170.0, 25, 8500, 82, "2021-10-02"));
        return healthInfoList;
    }

    public boolean updateHealthInfo(health_info healthData) {
        // Update health data in the database
        List<health_info> healthInfoList = new ArrayList<>();
        healthInfoList.add(new health_info(1, 1, 70.5, 65.0, 170.0, 25, 8000, 80, "2021-10-01"));
        return true;
    }

    public boolean deleteHealthInfo(int id) {
        // Delete health data from the database based on ID
        List<health_info> healthInfoList = new ArrayList<>();
        healthInfoList.remove(new health_info(1, 1, 70.5, 65.0, 170.0, 25, 8000, 80, "2021-10-01"));
        return true;
    }

    public List<health_info> getHealthInfoByPatientIdAndDate(int patientId, String date) {
        // Retrieve health data from the database based on patient ID and date
        List<health_info> healthInfoList = new ArrayList<>();
        healthInfoList.add(new health_info(1, 1, 70.5, 65.0, 170.0, 25, 8000, 80, "2021-10-01"));
        return healthInfoList;
    }

    public void addMedRemind(med_remind medRemind) {
        List<med_remind> medRemindList = new ArrayList<>();
        medRemindList.add(new med_remind(1, 1, "Medication A", "1 pill", "Daily", "2021-10-01", "2021-10-31"));
    }

    public List<med_remind> getMedRemindById(int patientId) {
        List<med_remind> medRemindList = new ArrayList<>();
        medRemindList.add(new med_remind(1, 1, "Medication A", "1 pill", "Daily", "2021-10-01", "2021-10-31"));
        return medRemindList;
    }

    public void updateMedRemind(med_remind medRemind) {
        List<med_remind> medRemindList = new ArrayList<>();
        medRemindList.add(new med_remind(1, 1, "Medication A", "1 pill", "Daily", "2021-10-01", "2021-10-31"));
    }

    public void deleteMedRemind(int medRemindId) {
        List<med_remind> medRemindList = new ArrayList<>();
        medRemindList.remove(new med_remind(1, 1, "Medication A", "1 pill", "Daily", "2021-10-01", "2021-10-31"));
    }
}
