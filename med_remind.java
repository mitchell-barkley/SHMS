public class med_remind {
    private int id;
    private int patient_id;
    private String med_name;
    private String dosage;
    private String schedule;
    private String startDate;
    private String endDate;

    public med_remind(int id, int patient_id, String med_name, String dosage, String schedule, String startDate, String endDate) {
        this.id = id;
        this.patient_id = patient_id;
        this.med_name = med_name;
        this.dosage = dosage;
        this.schedule = schedule;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public String getMed_name() {
        return med_name;
    }

    public String getDosage() {
        return dosage;
    }

    public String getSchedule() {
        return schedule;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public void setMed_name(String med_name) {
        this.med_name = med_name;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override

    public String toString() {
        return "med_remind{" +
                "id=" + id +
                ", patient_id=" + patient_id +
                ", med_name='" + med_name + '\'' +
                ", dosage='" + dosage + '\'' +
                ", schedule='" + schedule + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
