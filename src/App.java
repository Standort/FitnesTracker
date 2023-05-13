import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        LocalDate dateOfBirth = LocalDate.of(1990, 5, 13);
        User user = new User("John Doe", dateOfBirth, 180.0f, 75.0f, "Male");
        Workout workout = new Workout(0, "Cycling", 15.0f);
        //Session session = new Session(user, workout, 2, "WeightLifting");
        WeightLiftingSession wlSession = new WeightLiftingSession(user, workout, 10, null);
        CardioSession cardio = new CardioSession(user, workout, 10, null);
        DisplayWindow displayWindow = new DisplayWindow("Test");


    }
}
