import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Exercise extends GUI{
   private double caloriesBurnt; 
    public Exercise() {
        frame = new JFrame("Enter Exercise");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a JPanel for holding the components
        JPanel panel = new JPanel();

        // Create a JComboBox for selecting the exercise
        exerciseComboBox = new JComboBox<>();
        List<Workout> availableExercises = getAvailableExercises();
        for (Workout exercise : availableExercises) {
            exerciseComboBox.addItem(exercise.getName());
        }
        panel.add(new JLabel("Exercise: "));
        panel.add(exerciseComboBox);

        // Create a JTextField for entering the duration
        durationField = new JTextField(10);
        panel.add(new JLabel("Duration (minutes): "));
        panel.add(durationField);

        // Create a JButton for submitting the exercise
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitExercise();
            }
        });
        panel.add(submitButton);

        // Add the panel to the frame's content pane
        frame.getContentPane().add(panel);

        // Set frame properties
        frame.pack();
        frame.setVisible(true);
    }

    private List<Workout> getAvailableExercises() {
        // Return a list of available exercises
        List<Workout> workouts = new ArrayList<>();
        workouts.add(new Workout(0, "Running", 15));
        workouts.add(new Workout(1, "Cycling", 7));
        workouts.add(new Workout(2, "Swimming", 12));
        workouts.add(new Workout(3, "Strength training", 3));
        return workouts;
    }

    private void submitExercise() {
        // Get the selected exercise from the dropdown
        String exercise = exerciseComboBox.getSelectedItem().toString();

        // Get the entered duration from the text field
        int duration = Integer.parseInt(durationField.getText());
        List<Workout> availableExercises = getAvailableExercises();
        for (Workout exer : availableExercises) {
            if(exer.getName().equals(exercise)){

                caloriesBurnt = exer.getCaloriesPerMinute()*duration;
                break;
            }
        }
        // Perform further operations with the exercise and duration data
        // For example, you can calculate calories burned or update the user's exercise log

        // Close the window
        frame.dispose();
    }
    public double returnCaloriesBurnt(){
        return caloriesBurnt;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Exercise::new);
    }
}
