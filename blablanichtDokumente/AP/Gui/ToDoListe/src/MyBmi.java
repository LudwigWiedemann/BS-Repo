import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyBmi extends JFrame{
	
	public static void main(String[] args) {
		MyBmi bmi = new MyBmi();
	}
	
	Container con = getContentPane();
	
	JPanel panel = new JPanel();
	JLabel label1 = new JLabel("Anzahl: ");
	JLabel label2 = new JLabel("Preis: ");
	JTextField tf1 = new JTextField(20);
	JTextField tf2 = new JTextField(20);
	JPanel panel2 = new JPanel(new GridLayout(1,2));
	JButton button1 = new JButton("calculate price");
	JButton button2 = new JButton("show result");
	JLabel label3 = new JLabel("", JLabel.CENTER);
	
	int totalAmount = 0;
	
	public MyBmi() {
		super();
		setTitle("BMI");
		
		addWindowListener( new WindowAdapter () {
			@Override
			public void windowClosing(final WindowEvent e) {
				System.exit(0);
			}
		});
		
		con.setLayout(new BorderLayout());
		panel.setLayout(new GridLayout(2,2));
		button1.setSize(30, 30);
		panel.add(label1);
		panel.add(tf1);
		panel.add(label2);
		panel.add(tf2);
		
		panel2.add(button1);
		panel2.add(button2);
		con.add(panel, BorderLayout.NORTH);
		con.add(label3, BorderLayout.CENTER);
		con.add(panel2, BorderLayout.SOUTH);
		
		
		button1.addActionListener((e) -> {
			int count = Integer.parseInt(tf1.getText());
			int price = Integer.parseInt(tf2.getText());
			
			totalAmount = count * price;		
		});
		
		button2.addActionListener(e -> {
			label3.setText(String.valueOf(totalAmount));
			tf1.setText("");
			tf2.setText("");
			tf1.requestFocus();
			
		});
		
		
		
		setSize(400,400);
		setVisible(true);
	}
	
}
