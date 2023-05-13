import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.*;

public class CreateUserGUI {
    private JFrame frame;
    private JTextField nameField;
    private JTextField heightField;
    private JTextField weightField;
    private JTextField dateOfBirth;
    private JButton createButton;
    private JPanel panel;

    public CreateUserGUI() {
        frame = new JFrame("Create User");

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
        // Create a JButton for creating the user
        createButton = new JButton("Create");
        createButton.addActionListener(e -> createUser());
        panel.add(createButton);

        // Add the panel to the frame's content pane
        frame.getContentPane().add(panel);

        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of the CreateUserGUI
        SwingUtilities.invokeLater(CreateUserGUI::new);
    }

    public boolean checkData() {
        String name = nameField.getText();
        String heightText = heightField.getText();
        String weightText = weightField.getText();
        String dateOfBirthText = dateOfBirth.getText();

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

    private void createUser() {
        if (checkData()) {
            // Get the entered name from the text field
            String name = nameField.getText();

            // Perform further operations to create the user
            // ...

            // Display a message or perform any other actions
            JOptionPane.showMessageDialog(frame, "User created: " + name);

            // Reset the text field
            nameField.setText("");
        }

    }
}
