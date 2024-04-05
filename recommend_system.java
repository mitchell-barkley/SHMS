import java.util.ArrayList;
import java.util.List;

public class recommend_system {
    private static final int MIN_HEART_RATE = 60;
    private static final int MAX_HEART_RATE = 100;
    private static final int MIN_STEPS = 10000;

    public List<String> recommendActivities(health_info healthData) {
        List<String> recommendations = new ArrayList<>();
        if (healthData.getHeart_rate() < MIN_HEART_RATE) {
            recommendations.add("Increase your heart rate by doing some cardio exercises.");
        }
        if (healthData.getHeart_rate() > MAX_HEART_RATE) {
            recommendations.add("Lower your heart rate by doing some relaxation exercises.");
        }
        if (healthData.getSteps() < MIN_STEPS) {
            recommendations.add("Increase your daily steps by going for a walk or run.");
        }
        if (healthData.getWeight() > healthData.getWeightGoal()) {
            recommendations.add("Try to reduce your weight by following a healthy diet and exercise routine.");
        }
        return recommendations;
    }
}
