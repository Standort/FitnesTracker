import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StrengthT extends Exercise {
    private JFrame frame;
    private List<String> exerciseOptions;
    private JComboBox<String> exerciseDropdown;
    private JComboBox<Integer> repDropdown;
    private int reps;
    private double resistance;
    public StrengthT() {
        exerciseOptions = new ArrayList<>();
        exerciseOptions.add("Bench-Press");
        exerciseOptions.add("Squats");
        exerciseOptions.add("Burpees");
        exerciseOptions.add("Push-Ups");
        exerciseOptions.add("Deadlifts");
        frame = new JFrame("Strength Training Options");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel exerciseLabel = new JLabel("Select Exercise:");
        exerciseDropdown = new JComboBox<>(exerciseOptions.toArray(new String[0]));
        panel.add(exerciseLabel);
        panel.add(exerciseDropdown);

        JLabel repLabel = new JLabel("Select Reps:");
        repDropdown = new JComboBox<>(getRepOptions());
        panel.add(repLabel);
        panel.add(repDropdown);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedExercise = (String) exerciseDropdown.getSelectedItem();
                int selectedReps = (int) repDropdown.getSelectedItem();
                switch(selectedExercise){
                    case "Bench-Press": 
                        resistance=1;
                        break;
                    case "Squats":
                        resistance=2;
                        break;
                    case "Burpees":
                        resistance=3;
                        break;
                    case "Push-ups":
                        resistance=1.2;
                        break;
                    case "Deadlifts":
                        resistance=3;
                        break;
                    default: 
                        System.out.println("Exercise errror");
                }

                frame.dispose();
            }
        });
        panel.add(submitButton);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private Integer[] getRepOptions() {
        List<Integer> repOptions = new ArrayList<>();
        repOptions.add(1);
        repOptions.add(5);
        repOptions.add(10);
        repOptions.add(15);
        repOptions.add(20);
        return repOptions.toArray(new Integer[0]);
    }
    public double returnCalorieModifier(){
       
        double dReps = reps;
        dReps /=20;
        double modifyPercent = resistance + dReps;
        System.out.println(resistance + " resitance je " + reps + " reps je " + modifyPercent + " modify");
        return modifyPercent;
    }
    public JFrame returnJFrame(){
        return frame;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(StrengthT::new);
    }
}

