import javax.swing.*;

public class CreateUserGUI {
    private JFrame frame;
    private JTextField nameField;
    private JButton createButton;
    private JPanel panel;

    public CreateUserGUI() {
        frame = new JFrame("Create User");

        // Create a JPanel for holding the components
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create a JTextField for entering the name
        nameField = new JTextField(20);
        panel.add(new JLabel("Name: "));
        panel.add(nameField);

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

    private void createUser() {
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
