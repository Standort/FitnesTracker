import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Swimming extends Exercise {
    private JFrame frame ;
    private List<String> speedOptions;
    private List<String> strokeOptions;
    private JComboBox<String> speedDropdown;
    private JComboBox<String> strokeDropdown;
    private int speed;
    private double resistance;
    public Swimming() {
        speedOptions = new ArrayList<>();
        speedOptions.add("Slow");
        speedOptions.add("Medium");
        speedOptions.add("Fast");

        strokeOptions = new ArrayList<>();
        strokeOptions.add("Breaststroke");
        strokeOptions.add("Freestyle");
        strokeOptions.add("Butterfly");

        frame = new JFrame("Swimming Options");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel speedLabel = new JLabel("Select Speed:");
        speedDropdown = new JComboBox<>(speedOptions.toArray(new String[0]));
        panel.add(speedLabel);
        panel.add(speedDropdown);

        JLabel strokeLabel = new JLabel("Select Stroke:");
        strokeDropdown = new JComboBox<>(strokeOptions.toArray(new String[0]));
        panel.add(strokeLabel);
        panel.add(strokeDropdown);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSpeed = (String) speedDropdown.getSelectedItem();
                String selectedStroke = (String) strokeDropdown.getSelectedItem();
                switch(selectedSpeed){
                    case "Slow":
                        speed=1;
                        break;
                    case "Medium":
                        speed=2;
                        break;
                    case "Fast":
                        speed=3;
                        break;
                    default:
                        System.out.println("Swimming speed error");
                }
                switch(selectedStroke){
                    case "Breaststroke":
                        resistance=1;
                        break;
                    case "Freestyle":
                        resistance=2;
                        break;
                    case "Butterfly":
                        resistance=3;
                        break;
                    default:
                        System.out.println("Swimming style error");
                }

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

        double modifyPercent = resistance + dSpeed;
        System.out.println(resistance + " resitance je " + dSpeed + " speed je " + modifyPercent + " modify");
        return modifyPercent;
    }
    public JFrame returnJFrame(){
        return frame;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Swimming::new);
    }
}
