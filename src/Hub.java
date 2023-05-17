import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hub {
    private JFrame frame;
    private JLabel calorieCounterLabel;
    private JButton goalButton;
    private JButton exerciseButton;
    private JButton stepButton;
    private User user;
    public Hub(User user){
        this();
        this.user = user;
        
    }
    public Hub() {
        frame = new JFrame("Hub");

        // Create calorie counter label
        calorieCounterLabel = new JLabel("Calories: 0");
        calorieCounterLabel.setHorizontalAlignment(SwingConstants.CENTER);
        calorieCounterLabel.setFont(new Font("Arial", Font.BOLD, 24));

        // Create goal button
        goalButton = new JButton("Set Goal");
        goalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform goal button action

                System.out.println("Goal button clicked");
                Goal goal = new Goal();
            }
        });

        // Create exercise button
        exerciseButton = new JButton("Exercise");
        exerciseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform exercise button action
                System.out.println("Exercise button clicked");
            }
        });

        // Create step button
        stepButton = new JButton("Step");
        stepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform step button action
                System.out.println("Step button clicked");
            }
        });

        // Create panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(goalButton);
        buttonPanel.add(exerciseButton);
        buttonPanel.add(stepButton);

        // Create main panel and add components
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(calorieCounterLabel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the panel to the frame's content pane
        frame.getContentPane().add(panel);

        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Hub::new);
    }
}
