import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Hub {
    private JFrame frame;
    private JLabel calorieCounterLabel;
    private JButton goalButton;
    private JButton exerciseButton;
    private JButton stepButton;
    private User user;
    private String goalType;
    private double weight;
    private int duration;
    private double newCalories;

    public Hub(User user) {

        this.user = user;
        // Goal goal = new Goal();

        double calories = calculateBMR(user);
        frame = new JFrame("Hub");

        // Create calorie counter label
        calorieCounterLabel = new JLabel("Calories: " + calories);
        calorieCounterLabel.setHorizontalAlignment(SwingConstants.CENTER);
        calorieCounterLabel.setFont(new Font("Arial", Font.BOLD, 24));

        // Create goal button
        goalButton = new JButton("Set Goal");
        goalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform goal button action

                System.out.println("Goal button clicked");
                Goal goal = new Goal();
                JFrame jFrame = goal.returnFrtFrame();
                jFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent ee) {
                  
                     
                        newCalories = goal.calculateNewCalories();
                        double calories = calculateBMR(user);
                        goal.readGoal();
                        goalType = goal.getGoalType();
                        System.out.println(goalType);
                        System.out.println("Old cal" + calories);
                        System.out.println("new calories: " + newCalories);
                        if (goalType.equals("Lose")) {
                            calories -= newCalories;
                        } else if (goalType.equals("Gain")) {
                            calories += newCalories;
                        }
                        calories = Math.round(calories);
                        System.out.println(calories);
                        calorieCounterLabel.setText("Calories: " + calories);
                    }
                });

            }
        });

        // Create exercise button
        exerciseButton = new JButton("Exercise");
        exerciseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform exercise button action
                System.out.println("Exercise button clicked");
            }
        });

        // Create step button
        stepButton = new JButton("Step");
        stepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform step button action
                System.out.println("Step button clicked");
            }
        });

        // Create panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(goalButton);
        buttonPanel.add(exerciseButton);
        buttonPanel.add(stepButton);

        // Create main panel and add components
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(calorieCounterLabel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the panel to the frame's content pane
        frame.getContentPane().add(panel);

        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public double calculateBMR(User user) {
        double bmr;
        System.out.println(user.getCurrentAge());
        if (user.getGender().equalsIgnoreCase("male")) {
            bmr = 10 * user.getWeight() + 6.25 * user.getHeight() - 5 * user.getCurrentAge() + 5;
        } else {
            bmr = 10 * user.getWeight() + 6.25 * user.getHeight() - 5 * user.getCurrentAge() - 161;
        }
        return bmr;
    }

    public static void main(String[] args) {
    }
}
