public class doctor extends user {
    private String medLicenseNum;
    private String specialization;

    public doctor(int id, String firstName, String lastName, String email, String password, boolean isAdmin, String medLicenseNum, String specialization) {
        super(id, firstName, lastName, email, password, isAdmin);
        this.medLicenseNum = medLicenseNum;
        this.specialization = specialization;
    }

    public String getMedLicenseNum() {
        return medLicenseNum;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setMedLicenseNum(String medLicenseNum) {
        this.medLicenseNum = medLicenseNum;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override

    public String toString() {
        return "doctor{" +
                "medLicenseNum='" + medLicenseNum + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
