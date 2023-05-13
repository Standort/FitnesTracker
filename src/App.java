import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        LocalDate dateOfBirth = LocalDate.of(1990, 5, 13);
        user user = new user("John Doe", dateOfBirth, 180.0f, 75.0f, "Male");
        Workout workout = new Workout(0, "Cycling", 15.0f);
        System.out.println(workout.getCaloriesPerMinute());
        // Accessing and printing user information
        System.out.println("User ID: " + user.getUserID());
        System.out.println("Name: " + user.getName());
        System.out.println("Date of Birth: " + user.getDateOfBirth());
        System.out.println("Height: " + user.getHeight());
        System.out.println("Weight: " + user.getWeight());
        System.out.println("Gender: " + user.getGender());
    }
}
