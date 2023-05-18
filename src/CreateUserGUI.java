import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class CreateUserGUI extends GUI{
   
    private User user;
    private String temp;
    private boolean isUserCreated = false;
    private List<UserCreationListener> creationListeners;
    private JComboBox<String> genderComboBox;
    JLabel genderLabel = new JLabel("Gender:");
    JTextField genderField = new JTextField(20);
    public interface UserCreationListener {
        void onUserCreated(User user);
    }
    public void addUserCreationListener(UserCreationListener listener) {
        creationListeners.add(listener);
    }

    public CreateUserGUI() {
        frame = new JFrame("Create User");
        creationListeners = new ArrayList<>();
        // Create a JPanel for holding the components
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create a JTextField for entering the name
        nameField = new JTextField(0);
        panel.add(new JLabel("Name: "));
        panel.add(nameField);

        heightField = new JTextField(0);
        panel.add(new JLabel("Height: "));
        panel.add(heightField);

        weightField = new JTextField(0);
        panel.add(new JLabel("Weight: "));
        panel.add(weightField);

        dateOfBirth = new JTextField(0);
        panel.add(new JLabel("Date of birth: "));
        panel.add(dateOfBirth);

        String[] genderOptions = {"Male", "Female"};

        // Create the gender JComboBox
        genderComboBox = new JComboBox<>(genderOptions);
        panel.add(new JLabel("Gender: "));
        panel.add(genderComboBox);

      
        // Create a JButton for creating the user
        createButton = new JButton("Create");
        createButton.addActionListener(e -> createUser());
        panel.add(createButton);

        // Add the panel to the frame's content pane
        frame.getContentPane().add(panel);

        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of the CreateUserGUI
        SwingUtilities.invokeLater(CreateUserGUI::new);
    }

    public boolean checkData() {// preveri ce je prov vse unešeno
        String name = nameField.getText();
        String heightText = heightField.getText();
        String weightText = weightField.getText();
        String dateOfBirthText = dateOfBirth.getText();
        temp = dateOfBirthText;
        // Check if name is not empty
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter a name.");
            return false;
        }

        // Check if height is a valid float value
        try {
            float height = Float.parseFloat(heightText);
            if (height <= 0) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid height greater than 0.");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid numeric height value.");
            return false;
        }

        // Check if weight is a valid float value
        try {
            float weight = Float.parseFloat(weightText);
            if (weight <= 0) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid weight greater than 0.");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid numeric weight value.");
            return false;
        }

        // Check if dateOfBirth is in a valid format
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate.parse(dateOfBirthText, formatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid date of birth in the format yyyy-MM-dd.");
            return false;
        }

        return true;
    }
    public String getSelectedGender() {
        return (String) genderComboBox.getSelectedItem();
    }
    private void createUser() {
        if (checkData()) {
           
            isUserCreated = true;
            // Get the entered name from the text field
            String name = nameField.getText();
            //user.setName(name);
            // Get the entered height from the text field
            float height = Float.parseFloat(heightField.getText());
           // user.setHeight(height);
            // Get the entered weight from the text field
            float weight = Float.parseFloat(weightField.getText());
           // user.setWeight(weight);
            //// Get the entered date of birth from the text field
            LocalDate dateOfBirthData = LocalDate.parse(temp);

            String gender = getSelectedGender();
            //user.setDateOfBirth(dateOfBirthData);
            user = new User(name, dateOfBirthData, height, weight, gender);
            // Perform further operations to create the user
            // ...
            UserData userData = new UserData("user.txt");
            userData.saveUser(user);
            // Display a message or perform any other actions
            for (UserCreationListener listener : creationListeners) {
                listener.onUserCreated(user);
            }
            JOptionPane.showMessageDialog(frame, "User created: " + name);

            // Reset the text field
            nameField.setText("");
            heightField.setText("");
            weightField.setText("");
            dateOfBirth.setText("");
            frame.dispose();
         
        }

    }
    public boolean getUserCreated() {
        return isUserCreated;
    }
    public User returnUser() {
        return user;
    }
}
