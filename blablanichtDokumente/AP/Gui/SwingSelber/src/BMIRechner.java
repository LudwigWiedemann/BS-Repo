import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BMIRechner extends JFrame {
    public static void main(String[] args) {
        BMIRechner bmi = new BMIRechner();
    }

    final Container con = getContentPane();
    JTextField tfH = new JTextField(5);
    JTextField tfW = new JTextField(5);
    JTextArea ta = new JTextArea("Hier wird Ihr BMI ausgegeben",1, 1);
    JButton calc = new JButton("Berechne BMI");
    JPanel pan = new JPanel();

    public BMIRechner() {
        super();
        setTitle("BMIRechner");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });

        con.setLayout(new BorderLayout());
        pan.add(tfH);
        pan.add(tfW);
        ta.setSize(40,40);
        con.add(pan, BorderLayout.NORTH);
        con.add(calc, BorderLayout.SOUTH);
        con.add(ta, BorderLayout.CENTER);

        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long height = Integer.parseInt(tfH.getText());
                long weight = Integer.parseInt(tfW.getText());

                long result = height + weight;
                String output = String.valueOf(result);
                ta.setText(output);
                tfH.requestFocus();
                tfH.setText("");
                tfW.setText("");

            }
        });

        setSize(400, 200);
        setVisible(true);
    }


    private void exit() {
        System.exit(0);
    }
}
