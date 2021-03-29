import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CopyWindow extends JFrame{
    public static void main(String[] args) {
        new CopyWindow();
    }

    private final JLabel label;
    private JTextArea ta;

    public CopyWindow() {
        super();
        setTitle("CopyWindow");
            addWindowListener( new WindowAdapter() {
                @Override
                public void windowClosing(final WindowEvent e) {
                    exit();
                }
            });
        final Container con = getContentPane();
        con.setLayout(new BorderLayout());
        label = new JLabel("Copy Window", JLabel.CENTER);
        ta = new JTextArea();
        final JButton copy = new JButton("copy");

        con.add(label, BorderLayout.SOUTH);
        con.add(ta, BorderLayout.NORTH);
        con.add(copy, BorderLayout.EAST);

        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                copy();
            }
        });
        ta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if ( e.getKeyCode() == KeyEvent.VK_ENTER) {
                    copy();
                }
            }
        });
        setSize(400, 100);
        setVisible(true);
    }

    private void copy(){
        label.setText(ta.getText());
        ta.setText("");
        ta.requestFocus();
    }
    private void exit() {
        System.exit(0);
    }

}
