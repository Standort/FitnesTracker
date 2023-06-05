import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Hub extends GUI {

    private String goalType;
    private double newCalories;
    private double calories;

    public Hub(User user) {

        calories = calculateBMR(user);
        frame = new JFrame("Hub");

        calorieCounterLabel = new JLabel("Calories: " + calories);
        calorieCounterLabel.setHorizontalAlignment(SwingConstants.CENTER);
        calorieCounterLabel.setFont(new Font("Arial", Font.BOLD, 24));

        goalButton = new JButton("Set Goal");
        goalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Goal button clicked");
                Goal goal = new Goal();
                JFrame jFrame = goal.returnJFrame();
                jFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent ee) {

                        newCalories = goal.calculateNewCalories();
                        if(Double.isNaN(newCalories)){
                            newCalories=0.0;
                        }
                        if(Double.isNaN(calories))
                         calories = calculateBMR(user);
                        goal.readGoal();
                        goalType = goal.getGoalType();
                        System.out.println(goalType);
                        System.out.println("Old cal" + calories);
                        System.out.println("new calories: " + newCalories);
                        if (goalType.equals("Lose")) {
                            calories -= newCalories;
                            setCalories(calories);
                        } else if (goalType.equals("Gain")) {
                            calories += newCalories;
                            setCalories(calories);
                        }
                        System.out.println(calories);
                        calorieCounterLabel.setText("Calories: " + calories);
                    }
                });

            }
        });

        exerciseButton = new JButton("Exercise");
        exerciseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Exercise exercise = new Exercise(1);
                System.out.println("Exercise button clicked");
                exercise.returnJFrame().addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent ee) {
                        String exerciseString = exercise.returnExercise();
                        switch (exerciseString) {
                            case "Running":
                                Running running = new Running();
                                running.returnJFrame().addWindowListener(new WindowAdapter() {
                                    @Override
                                    public void windowClosed(WindowEvent ea) {
                                        newCalories = exercise.returnCaloriesBurnt() * running.returnCalorieModifier();
                                        System.out.println(newCalories);
                                        calories += newCalories;
                                        setCalories(calories);
                                        System.out.println("Kalorije po korakih: " + calories);
                                        calorieCounterLabel.setText("Calories: " + calories);
                                    }
                                });
                                break;
                            case "Cycling":
                            System.out.println("Cycl test");
                                Cycling cycling = new Cycling();
                                cycling.returnJFrame().addWindowListener(new WindowAdapter() {
                                    @Override
                                    public void windowClosed(WindowEvent ea) {
                                        newCalories = exercise.returnCaloriesBurnt() * cycling.returnCalorieModifier();
                                        System.out.println(newCalories);
                                        calories += newCalories;
                                        setCalories(calories);
                                        System.out.println("Kalorije po korakih: " + calories);
                                        calorieCounterLabel.setText("Calories: " + calories);
                                    }
                                });
                                break;
                            case "Strength training":
                            System.out.println("Strength test");
                            StrengthT strengthT = new StrengthT();
                            strengthT.returnJFrame().addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowClosed(WindowEvent ea) {
                                    newCalories = exercise.returnCaloriesBurnt() * strengthT.returnCalorieModifier();
                                    System.out.println(newCalories);
                                    calories += newCalories;
                                    setCalories(calories);
                                    System.out.println("Kalorije po korakih: " + calories);
                                    calorieCounterLabel.setText("Calories: " + calories);
                                }
                            });
                            case "Swimming":
                            System.out.println("Swimming test");
                            Swimming swimming = new Swimming();
                            swimming.returnJFrame().addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowClosed(WindowEvent ea) {
                                    newCalories = exercise.returnCaloriesBurnt() * swimming.returnCalorieModifier();
                                    System.out.println(newCalories);
                                    calories += newCalories;
                                    setCalories(calories);
                                    System.out.println("Kalorije po korakih: " + calories);
                                    calorieCounterLabel.setText("Calories: " + calories);
                                }
                            });
                            case "Jump rope":
                            System.out.println("jump test");
                            JumpRope jumpRope = new JumpRope();
                            jumpRope.returnJFrame().addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowClosed(WindowEvent ea) {
                                    newCalories = exercise.returnCaloriesBurnt() * jumpRope.returnCalorieModifier();
                                    System.out.println(newCalories);
                                    calories += newCalories;
                                    setCalories(calories);
                                    System.out.println("Kalorije po korakih: " + calories);
                                    calorieCounterLabel.setText("Calories: " + calories);
                                }
                            });
                            default:
                                System.out.println("Ni");
                                break;
                        }
                        ;

                    }
                });
            }
        });

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
                        System.out.println("Pokurjene kalorije" + newCalories + " prejsne kalorije" + calories);
                        calories += newCalories;
                        setCalories(calories);
                        System.out.println("Kalorije po korakih: " + calories);
                        calorieCounterLabel.setText("Calories: " + calories);
                    }
                });
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(goalButton);
        buttonPanel.add(exerciseButton);
        buttonPanel.add(stepButton);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(calorieCounterLabel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);

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

    public void setCalories(double nCalories) {
        this.calories = Math.round(nCalories);
    }

    public static void main(String[] args) {
    }
}
