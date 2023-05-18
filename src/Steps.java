import javax.swing.*;

public class Steps extends GUI {
    private User user; 
    private int numOfSteps;
    public double returnCalsBurned(int steps){
        double stepLength = user.getHeight()*0.415*steps/100; 
        double caloriesPerKgPerKm = 0.78*user.getWeight();
        double caloriesBurnt = stepLength*caloriesPerKgPerKm/1000;
        return caloriesBurnt;
        
    }
    public int returnNumOfSteps(){
        return numOfSteps;
    }
    public double returnCalsBurned(){
        double stepLength = user.getHeight()*0.415*numOfSteps; 
        double caloriesPerKgPerKm = 0.78*user.getWeight();
        double caloriesBurnt = stepLength*caloriesPerKgPerKm/10;
        //System.out.println(caloriesBurnt);
        return caloriesBurnt;
        
    }
    public Steps(User user) {
        this.user = user;
        frame = new JFrame("Enter Steps");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a JPanel for holding the components
        JPanel panel = new JPanel();

        // Create a JTextField for entering the number of steps
        stepsField = new JTextField(10);
        panel.add(new JLabel("Number of Steps: "));
        panel.add(stepsField);

        // Create a JButton for submitting the steps
        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> submitSteps());
        panel.add(submitButton);

        // Add the panel to the frame's content pane
        frame.getContentPane().add(panel);

        // Set frame properties
        frame.pack();
        frame.setVisible(true);
    }

    private void submitSteps() {
        // Get the entered number of steps from the text field
        numOfSteps = Integer.parseInt(stepsField.getText());
       // double test = returnCalsBurned(numOfSteps);
        // Perform further operations with the steps data
        // For example, you can update the user's step count or perform calculations

        // Close the window
        frame.dispose();
    }

    public static void main(String[] args) {
    }
}
