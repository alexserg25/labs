import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class Main extends JComponent implements ActionListener {
    private double scale;
    private Color color;
    private Timer timer;
    public double x =10;
    public double y =10;

    public Main(Color color, int delay) {
        scale = 1.0;
        timer = new Timer(delay, this);
        this.color = color;
        setPreferredSize(new Dimension(500, 500));
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        int width = 500;
        int height = 500;
        g.fillRect(0, 0, width, height);
        g2d.setColor(Color.black);
        g2d.drawRect(0, 0, width - 1, height - 1);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(color);
        g2d.scale(scale, scale);
        x++;
        y++;
        Ellipse2D el = new Ellipse2D.Double(x, y, 20, 20);
        g2d.fill(el);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Space");
                JPanel panel = new JPanel();
                final Main moving = new Main(Color.green, 20);
                panel.add(moving);
                frame.getContentPane().add(panel);
                final JButton button = new JButton("Start");
                button.addActionListener(new ActionListener() {
                    private boolean pulsing = false;
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (pulsing) {
                            pulsing = false;
                            moving.stop();
                            button.setText("Start");
                        } else {
                            pulsing = true;
                            moving.start();
                            button.setText("Stop");
                        }
                    }
                });
                panel.add(button);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setVisible(true);
            }
        });
    }

    /*
    public Main()
    {
        super();
        this.setSize(640, 480);
        this.getContentPane().setLayout(null);
        this.add(getJLabel(), null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.add(getJTextField(), null);
//        this.add(getJButton(), null);
        this.setTitle("Space");
    }
    private JLabel getJLabel() {
        JLabel jLabel = new JLabel();
        if(jLabel == null) {
            jLabel = new JLabel();
            jLabel.setBounds(34, 49, 53, 18);
            jLabel.setText("Name:");
        }
        return jLabel;
    }

    /*
    private javax.swing.JLabel getJLabel() {
        if(jLabel == null) {
            jLabel = new javax.swing.JLabel();
            jLabel.setBounds(34, 49, 53, 18);
            jLabel.setText("Name:");
        }
        return jLabel;
    }

    private javax.swing.JTextField getJTextField() {
        if(jTextField == null) {
            jTextField = new javax.swing.JTextField();
            jTextField.setBounds(96, 49, 160, 20);
        }
        return jTextField;
    }

    private javax.swing.JButton getJButton() {
        if(jButton == null) {
            jButton = new javax.swing.JButton();
            jButton.setBounds(103, 110, 71, 27);
            jButton.setText("OK");
        }
        return jButton;
    }
*/
    /*
    public static void main(String[] args)
    {
        Main w = new Main();
        w.setVisible(true);
    }

     */
}
