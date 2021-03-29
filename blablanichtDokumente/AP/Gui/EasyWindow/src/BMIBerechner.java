import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BMIBerechner extends JFrame {

    JTextArea inputField;
    JButton start;
    JLabel result;

    public static void main(String[] args) {
        new BMIBerechner();
    }

    public BMIBerechner() {
        super();
        setTitle("Geben Sie ein: 'KG,cm'");
        addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                exit();
            }
        });
        final Container con = getContentPane();
        con.setLayout(new BorderLayout());
        inputField = new JTextArea();
        result = new JLabel("Your BMI: ", JLabel.CENTER);
        start = new JButton("Berechne");

        con.add(result, BorderLayout.SOUTH);
        con.add(inputField, BorderLayout.NORTH);
        con.add(start, BorderLayout.EAST);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(berechneBMI());
                inputField.setText("");
                inputField.requestFocus();
            }
        });
        setSize(400, 100);
        setVisible(true);
    }

    private void exit() {
        System.exit(0);
    }

    private String berechneBMI() {
        String[] values  = inputField.getText().split(",");
        int height = Integer.parseInt(values[0]);
        int weight = Integer.parseInt(values[1]);
        int result = (weight / (((height)/100)^2));
        return String.valueOf(result);
    }
}
