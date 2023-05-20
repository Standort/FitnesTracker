import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Hub extends GUI{
   
    private String goalType;
    private double newCalories;
    private double calories;
    public Hub(User user) {

        calories = calculateBMR(user);
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
                JFrame jFrame = goal.returnJFrame();
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
                Exercise exercise = new Exercise();
                System.out.println("Exercise button clicked");
                exercise.returnJFrame().addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent ee) {
                        newCalories = exercise.returnCaloriesBurnt();
                        System.out.println(newCalories);
                         calories += newCalories;
                        calories = Math.round(calories);
                        System.out.println("Kalorije po korakih: " + calories);
                        calorieCounterLabel.setText("Calories: " + calories);
                    }
                });
            }
        });

        // Create step button
        stepButton = new JButton("Add Steps");
        stepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Steps steps = new Steps(user);
                System.out.println("Step button clicked");
                steps.returnJFrame().addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent ee) {
                        int stepCount = steps.returnNumOfSteps();
                        newCalories = steps.returnCalsBurned(stepCount);
                        System.out.println(newCalories);
                        calories += newCalories;
                        calories = Math.round(calories);
                        System.out.println("Kalorije po korakih: " + calories);
                        calorieCounterLabel.setText("Calories: " + calories);
                    }
                });
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
