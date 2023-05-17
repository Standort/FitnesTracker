import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) throws Exception {
        LocalDate dateOfBirth = LocalDate.of(1990, 5, 13);
       // User user = new User("John Doe", dateOfBirth, 180.0f, 75.0f, "Male");
        Workout workout = new Workout(0, "Cycling", 15.0f);
        //Session session = new Session(user, workout, 2, "WeightLifting");
        //WeightLiftingSession wlSession = new WeightLiftingSession(user, workout, 10, null);
        //CardioSession cardio = new CardioSession(user, workout, 10, null);
        //DisplayWindow displayWindow = new DisplayWindow("Test");
        //displayWindow.setText("Test text");
        SwingUtilities.invokeLater(() -> {
            LoginOrRegister	loginOrRegister = new LoginOrRegister(); 
            JFrame jFrame = loginOrRegister.returnWindow();
            jFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    UserData userData = loginOrRegister.returnUserData();
                    User currenUser = userData.loadUser();
                    Hub hub = new Hub(currenUser);

                }
            });
        });
      

    }
}
