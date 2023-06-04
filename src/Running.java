import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Running extends Exercise {
    private List<String> speedOptions;
    private List<String> runningTypeOptions;
    private int speed;
    private int incline;
    private JFrame frame;
    public Running() {
        speedOptions = new ArrayList<>();
        speedOptions.add("05 km/h");
        speedOptions.add("07 km/h");
        speedOptions.add("10 km/h");
        speedOptions.add("12 km/h");
        speedOptions.add("15 km/h");

        runningTypeOptions = new ArrayList<>();
        runningTypeOptions.add("00% Incline");
        runningTypeOptions.add("15% Incline");
        runningTypeOptions.add("20% Incline");

        frame = new JFrame("Running Options");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel speedLabel = new JLabel("Select Speed:");
        JComboBox<String> speedDropdown = new JComboBox<>(speedOptions.toArray(new String[0]));
        panel.add(speedLabel);
        panel.add(speedDropdown);

        JLabel runningTypeLabel = new JLabel("Select Running Type:");
        JComboBox<String> runningTypeDropdown = new JComboBox<>(runningTypeOptions.toArray(new String[0]));
        panel.add(runningTypeLabel);
        panel.add(runningTypeDropdown);

        JButton button = new JButton("Get Selected Options");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSpeedString = (String) speedDropdown.getSelectedItem();
                String selectedRunningTypeString = (String) runningTypeDropdown.getSelectedItem();

                char charSpeed[] = new char[2];
                char charType[] = new char[2];

                charSpeed[0] = selectedSpeedString.charAt(0);
                charSpeed[1] = selectedSpeedString.charAt(1);

                charType[0] = selectedRunningTypeString.charAt(0);
                charType[1] = selectedRunningTypeString.charAt(1);
                speed = Integer.parseInt(String.valueOf(charSpeed));
                incline = Integer.parseInt(String.valueOf(charType));

                frame.dispose();
            }
        });
        panel.add(button);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    public double returnCalorieModifier(){
        double dIncline = incline;
        dIncline /=10;
        double dSpeed = speed;
        double modifyPercent = dIncline + 0.2*dSpeed;
        System.out.println(dIncline + " incline je " + speed + " speed je " + modifyPercent + " modify");
        return modifyPercent;
    }
    public JFrame returnJFrame(){
        return frame;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Running::new);
    }
}
