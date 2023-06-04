import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Exercise extends GUI{
   private double caloriesBurnt; 
   private String exercise;
   public Exercise(){

   }
    public Exercise(int a) {//a nic ne naredi, samo da Running ne klice to
        frame = new JFrame("Enter Exercise");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

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

        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
    }

    private List<Workout> getAvailableExercises() {
        List<Workout> workouts = new ArrayList<>();
        workouts.add(new Workout(0, "Running", 15));
        workouts.add(new Workout(1, "Cycling", 7));
        workouts.add(new Workout(2, "Swimming", 12));
        workouts.add(new Workout(3, "Strength training", 3));
        workouts.add(new Workout(4, "Jump rope", 13));
        return workouts;
    }

    private void submitExercise() {
        setExercise(exerciseComboBox.getSelectedItem().toString());

        int duration = Integer.parseInt(durationField.getText());
        List<Workout> availableExercises = getAvailableExercises();
        for (Workout exer : availableExercises) {
            if(exer.getName().equals(returnExercise())){

                caloriesBurnt = exer.getCaloriesPerMinute()*duration;
                break;
            }
        }

        frame.dispose();
    }
    public void setExercise(String exercise){
        this.exercise = exercise;
    }
    public double returnCaloriesBurnt(){
        return caloriesBurnt;
    }
    public String returnExercise(){
        return exercise;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Exercise::new);
    }
}
