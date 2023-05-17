import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginOrRegister {
    private JFrame frame;
    private JButton registerButton;
    private JButton loginButton;
    private UserData userData;

    public LoginOrRegister() {
        userData = new UserData("user.txt");
        frame = new JFrame("Login or Register");

        // Create a JPanel for holding the components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create a "Register" button
        registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Redirect to CreateUserGUI when the "Register" button is clicked
                CreateUserGUI createUserGUI = new CreateUserGUI();
                createUserGUI.addUserCreationListener(new CreateUserGUI.UserCreationListener() {
                    @Override
                    public void onUserCreated(User user) {
                        // User has been created, perform further operations or display a message
                        System.out.println("User created: " + user.getName());
                    }
                });
            }
        });
        panel.add(registerButton);
        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }

        });
        panel.add(loginButton);
        // Add the panel to the frame's content pane
        frame.getContentPane().add(panel);

        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void login() {
        // Check if the user is registered
        if (userData.loadUser() != null) {
            System.out.println("Login successful");
            frame.dispose(); // Close the window
        } else {
            System.out.println("User not found");
        }
    }
    public JFrame returnWindow(){
        return frame;
    }
    public UserData returnUserData() {
        return userData;
    }
    public static void main(String[] args) {
        // Create an instance of the LoginOrRegister class
        SwingUtilities.invokeLater(LoginOrRegister::new);
    }
}
