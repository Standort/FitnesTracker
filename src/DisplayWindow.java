import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayWindow {
    private JFrame frame;
    private JLabel label;
    private JPanel contentPane;

    public DisplayWindow(String title) {
        // Create the JFrame and set its title
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a JLabel for displaying the information
        label = new JLabel();
        
        // Add the label to the frame
        frame.getContentPane().add(label);
        
        // Set the size and visibility of the frame
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    public void setText(String text) {
        // Set the text of the label
        label.setText(text);
    }
    public void setVisible(boolean bool) {
        frame.setVisible(bool);
    }
    public void addToContentPane(JPanel panel) {
        contentPane.add(panel);
        contentPane.revalidate();
        contentPane.repaint();
    }
    public static void main(String[] args) {
        // Create an instance of the DisplayWindow
        DisplayWindow display = new DisplayWindow("Information Display");

        // Set the text to be displayed
        display.setText("Hello, World!");
    }
}
