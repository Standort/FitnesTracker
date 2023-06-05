import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class JumpRope extends Exercise {
    private JFrame frame ;
    private List<String> heightOptions;
    private List<Integer> hopOptions;
    private JComboBox<String> heightDropdown;
    private JComboBox<Integer> hopDropdown;
    private int speed;
    private double resistance;
    public JumpRope() {
        heightOptions = new ArrayList<>();
        heightOptions.add("Low");
        heightOptions.add("Medium");
        heightOptions.add("High");

        hopOptions = new ArrayList<>();
        hopOptions.add(180);
        hopOptions.add(360);
        hopOptions.add(540);

        frame = new JFrame("Jump Rope Options");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel heightLabel = new JLabel("Select Jump Height:");
        heightDropdown = new JComboBox<>(heightOptions.toArray(new String[0]));
        panel.add(heightLabel);
        panel.add(heightDropdown);

        JLabel hopLabel = new JLabel("Select Number of Hops:");
        hopDropdown = new JComboBox<>(hopOptions.toArray(new Integer[0]));
        panel.add(hopLabel);
        panel.add(hopDropdown);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedHeight = (String) heightDropdown.getSelectedItem();
                int selectedHops = (int) hopDropdown.getSelectedItem();
                switch(selectedHeight){
                    case "Low":
                        resistance=1;
                        break;
                    case "Medium":
                        resistance=1.5;
                        break;
                    case "High":
                        resistance=2;
                        break;
                    default:
                        System.out.println("Swimming speed error");
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
        dSpeed /=180;
        double modifyPercent = (resistance + dSpeed)/2;
        System.out.println(resistance + " resitance je " + dSpeed + " speed je " + modifyPercent + " modify");
        return modifyPercent;
    }
    public JFrame returnJFrame(){
        return frame;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(JumpRope::new);
    }
}
