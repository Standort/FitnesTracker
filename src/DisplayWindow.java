import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayWindow {
    private JFrame frame;
    private JLabel label;
    private JPanel contentPane;

    public DisplayWindow(String title) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        label = new JLabel();
        
        frame.getContentPane().add(label);
        
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    public void setText(String text) {
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
        DisplayWindow display = new DisplayWindow("Information Display");

        display.setText("Hello, World!");
    }
}
