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

        JPanel panel = new JPanel();

        stepsField = new JTextField(10);
        panel.add(new JLabel("Number of Steps: "));
        panel.add(stepsField);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> submitSteps());
        panel.add(submitButton);

        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
    }

    private void submitSteps() {
        numOfSteps = Integer.parseInt(stepsField.getText());
       // double test = returnCalsBurned(numOfSteps);

        frame.dispose();
    }

    public static void main(String[] args) {
    }
}
