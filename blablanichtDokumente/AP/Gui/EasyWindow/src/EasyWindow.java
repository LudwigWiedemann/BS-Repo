import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EasyWindow extends JFrame{

    public static void main(String[] args) {
        new EasyWindow();
    }

    private final JLabel label;

    public EasyWindow() {
        super();
        setTitle("easy Window");
        addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                exit();
            }
        });
        final Container con = getContentPane();
        con.setLayout(new BorderLayout());

        label = new JLabel("Dies ist ein Test", JLabel.CENTER);
        final JButton red = new JButton("rot");
        final JButton yellow = new JButton("gelb");
        final JButton exit = new JButton("Ende");

        con.add(label, BorderLayout.CENTER);
        con.add(red, BorderLayout.WEST);
        con.add(yellow, BorderLayout.EAST);
        con.add(exit, BorderLayout.SOUTH);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                exit();
            }
        });
        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                label.setForeground(Color.RED);
            }
        });

        yellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                label.setForeground(Color.YELLOW);
            }
        });
        setSize(400, 100);
        setVisible(true);
    }

    private void exit() {
        System.exit(0);
    }
}
