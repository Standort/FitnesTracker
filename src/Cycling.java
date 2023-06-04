import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Cycling extends Exercise {
    private int speed;
    private int resistance;
    private JFrame frame;
    public Cycling() {
        List<String> speedOptions = new ArrayList<>();
        speedOptions.add("10 km/h");
        speedOptions.add("15 km/h");
        speedOptions.add("20 km/h");

        List<String> resistanceOptions = new ArrayList<>();
        resistanceOptions.add("Low");
        resistanceOptions.add("Medium");
        resistanceOptions.add("High");

        frame = new JFrame("Cycling Options");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel speedLabel = new JLabel("Select Speed:");
        JComboBox<String> speedDropdown = new JComboBox<>(speedOptions.toArray(new String[0]));
        panel.add(speedLabel);
        panel.add(speedDropdown);

        JLabel resistanceLabel = new JLabel("Select Resistance:");
        JComboBox<String> resistanceDropdown = new JComboBox<>(resistanceOptions.toArray(new String[0]));
        panel.add(resistanceLabel);
        panel.add(resistanceDropdown);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSpeedString = (String) speedDropdown.getSelectedItem();
                String selectedResistanceString = (String) resistanceDropdown.getSelectedItem();

                char charSpeed[] = new char[2];

                charSpeed[0] = selectedSpeedString.charAt(0);
                charSpeed[1] = selectedSpeedString.charAt(1);

                switch(selectedResistanceString){
                    case "Low": resistance = 1;
                    break;
                    case "Medium": resistance = 2;
                    break;
                    case "High": resistance = 3;
                    break;
                    default: System.out.println("resiatnce error");
                    break;
                }
                speed = Integer.parseInt(String.valueOf(charSpeed));


                frame.dispose();
            }
        });
        panel.add(submitButton);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    public double returnCalorieModifier(){
       
        double dSpeed = speed;
        dSpeed /=10;
        double modifyPercent = resistance + dSpeed;
        System.out.println(resistance + " resitance je " + speed + " speed je " + modifyPercent + " modify");
        return modifyPercent;
    }
    public JFrame returnJFrame(){
        return frame;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Running::new);
    }
}
