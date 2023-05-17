import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Goal {
    private JFrame frame;
    private JButton loseButton;
    private JButton maintainButton;
    private JButton gainButton;

    public Goal() {
        frame = new JFrame("Set Goal");

        // Create buttons
        loseButton = new JButton("Lose Weight");
        maintainButton = new JButton("Maintain Weight");
        gainButton = new JButton("Gain Weight");

        // Add action listeners to buttons
        loseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter desired weight loss in kg:"));
                int duration = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter desired duration in days:"));
                saveGoal("Lose", amount, duration);
                calculateGoal("Lose", amount, duration);
            }
        });

        maintainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveGoal("Maintain", 0, 0);
                calculateGoal("Maintain", 0, 0);
            }
        });

        gainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter desired weight gain in kg:"));
                int duration = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter desired duration in days:"));
                saveGoal("Gain", amount, duration);
                calculateGoal("Gain", amount, duration);
            }
        });

        // Create panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(loseButton);
        buttonPanel.add(maintainButton);
        buttonPanel.add(gainButton);

        // Add the panel to the frame's content pane
        frame.getContentPane().add(buttonPanel);

        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void calculateGoal(String goalType, double amount, int duration) {
        LocalDate targetDate = LocalDate.now().plusDays(duration);

        JOptionPane.showMessageDialog(frame,
                "Goal: " + goalType + "\n" +
                        "Amount: " + amount + " kg\n" +
                        "Duration: " + duration + " days\n" +
                        "Target Date: " + targetDate);
    }

    private void saveGoal(String goalType, double amount, int duration) {
        String goalData = goalType + ", " + amount + ", " + duration;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usergoal.txt"))) {
            writer.write(goalData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Goal::new);
    }
}
