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
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

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

        genderComboBox = new JComboBox<>(genderOptions);
        panel.add(new JLabel("Gender: "));
        panel.add(genderComboBox);

      
        createButton = new JButton("Create");
        createButton.addActionListener(e -> createUser());
        panel.add(createButton);

        frame.getContentPane().add(panel);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CreateUserGUI::new);
    }

    public boolean checkData() {// preveri ce je prov vse unešeno
        String name = nameField.getText();
        String heightText = heightField.getText();
        String weightText = weightField.getText();
        String dateOfBirthText = dateOfBirth.getText();
        temp = dateOfBirthText;
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter a name.");
            return false;
        }

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
            String name = nameField.getText();
            float height = Float.parseFloat(heightField.getText());
           // user.setHeight(height);
            float weight = Float.parseFloat(weightField.getText());
           // user.setWeight(weight);
            LocalDate dateOfBirthData = LocalDate.parse(temp);

            String gender = getSelectedGender();
            //user.setDateOfBirth(dateOfBirthData);
            user = new User(name, dateOfBirthData, height, weight, gender);
            UserData userData = new UserData("user.txt");
            userData.saveUser(user);
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
