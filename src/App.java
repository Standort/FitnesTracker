import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) throws Exception {
        LocalDate dateOfBirth = LocalDate.of(1990, 5, 13);
        User user = new User("John Doe", dateOfBirth, 180.0f, 75.0f, "Male");
        Workout workout = new Workout(0, "Cycling", 15.0f);
        //Session session = new Session(user, workout, 2, "WeightLifting");
        WeightLiftingSession wlSession = new WeightLiftingSession(user, workout, 10, null);
        CardioSession cardio = new CardioSession(user, workout, 10, null);
        //DisplayWindow displayWindow = new DisplayWindow("Test");
        //displayWindow.setText("Test text");
        SwingUtilities.invokeLater(() -> {

            CreateUserGUI createUserGUI = new CreateUserGUI();
          

            // Retrieve the user data after the window is closed
       
            

            // Perform further operations using the retrieved user data
            // ...

            // Display a message or perform any other actions
            JOptionPane.showMessageDialog(null, "User created: " + user.getName());

        });

    }
}
