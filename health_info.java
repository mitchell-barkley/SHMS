import java.sql.Date;

public class health_info {
    private int id;
    private int patient_id;
    private double weight;
    private double weightGoal;
    private double height;
    private int age;
    private int steps;
    private int heart_rate;
    private String date;

    public health_info(int id, int patient_id, double weight,  double weightGoal, double height, int age, int steps, int heart_rate, String date) {
        this.id = id;
        this.patient_id = patient_id;
        this.weight = weight;
        this.weightGoal = weightGoal;
        this.height = height;
        this.age = age;
        this.steps = steps;
        this.heart_rate = heart_rate;
        this.date = date;
    }

    public health_info(int i, double d, double e, double f, int j, int k, int l, Date valueOf) {
        
    }

    public int getId() {
        return id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public double getWeight() {
        return weight;
    }

    public double getWeightGoal() {
        return weightGoal;
    }

    public double getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public int getSteps() {
        return steps;
    }

    public int getHeart_rate() {
        return heart_rate;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setWeightGoal(double weightGoal) {
        this.weightGoal = weightGoal;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void setHeart_rate(int heart_rate) {
        this.heart_rate = heart_rate;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override

    public String toString() {
        return "health_info{" +
                "id=" + id +
                ", patient_id=" + patient_id +
                ", weight=" + weight +
                ", height=" + height +
                ", age=" + age +
                ", steps=" + steps +
                ", heart_rate=" + heart_rate +
                ", date='" + date + '\'' +
                '}';
    }
}
