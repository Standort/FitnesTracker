import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Goal extends GUI{
    private String goalType;
    private double weight;
    private int duration;

    public Goal(){
        frame = new JFrame("Set Goal");

        // Create buttons
        loseButton = new JButton("Lose Weight");
        maintainButton = new JButton("Maintain Weight");
        gainButton = new JButton("Gain Weight");

        // Add action listeners to buttons
        loseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double
                        .parseDouble(JOptionPane.showInputDialog(frame, "Enter desired weight loss in kg:"));
                int duration = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter desired duration in days:"));
                saveGoal("Lose", amount, duration);
                calculateGoal("Lose", amount, duration);
                frame.dispose();
            }
        });

        maintainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveGoal("Maintain", 0, 0);
                calculateGoal("Maintain", 0, 0);
                frame.dispose();
            }
        });

        gainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double
                        .parseDouble(JOptionPane.showInputDialog(frame, "Enter desired weight gain in kg:"));
                int duration = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter desired duration in days:"));
                saveGoal("Gain", amount, duration);
                calculateGoal("Gain", amount, duration);
                frame.dispose();
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
        readGoal();
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

    public void readGoal() {
        try (BufferedReader reader = new BufferedReader(new FileReader("usergoal.txt"))) {
            String line = reader.readLine();
            if (line != null) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    goalType = parts[0];
                    weight = Double.parseDouble(parts[1]);
                    duration = Integer.parseInt(parts[2]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getGoalType() {
        return goalType;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public int getDuration() {
        return duration;
    }
    public double calculateNewCalories() {
        double newCalories = weight / duration;
        newCalories*=7700;
        return newCalories;
    }
    public JFrame returnFrtFrame(){
        return frame;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Goal::new);
    }
}
