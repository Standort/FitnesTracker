import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            LoginOrRegister	loginOrRegister = new LoginOrRegister(); 
            JFrame jFrame = loginOrRegister.returnWindow();
            jFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    UserData userData = loginOrRegister.returnUserData();
                    User currentUser = userData.loadUser();
                    System.out.println(currentUser.getGender()); 
                    Hub hub = new Hub(currentUser);

                }
            });
        });
      

    }
}
