import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class TodoListe extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new TodoListe();
	}
	JPanel panelButtons = new JPanel();
	JButton add = new JButton("Add");
	JButton remove = new JButton("Remove");
	JButton removeAll = new JButton("Remove All");
	JButton exit = new JButton("Exit");
	
	private DefaultListModel<Entry> model = new DefaultListModel<Entry>();
	JList<Entry> list = new JList<Entry>(model);
	JScrollPane sp = new JScrollPane(list);
	
	JPanel panelInput = new JPanel();
	JLabel labelItem = new JLabel("Item: "); 
	JLabel labelCount = new JLabel("Count: "); 
	JTextField tfItem = new JTextField(15);
	JTextField tfCount = new JTextField(9);
	Container con = getContentPane();
	
	
	public TodoListe() {
		super();
		panelButtons.setLayout(new GridLayout(4,1));
		panelInput.setLayout(new FlowLayout(FlowLayout.LEFT));
		setTitle("Todo Liste");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent e ) {
				exit();
			}
		});
		panelInput.add(labelItem);
		panelInput.add(tfItem);
		panelInput.add(labelCount);
		panelInput.add(tfCount);
		panelButtons.add(add);
		panelButtons.add(remove);
		panelButtons.add(removeAll);
		panelButtons.add(exit);
		con.add(panelInput, BorderLayout.NORTH);
		con.add(panelButtons, BorderLayout.EAST);
		con.add(sp, BorderLayout.CENTER);
		
		
		exit.addActionListener((e) -> exit());
		add.addActionListener(e -> addTf());
		removeAll.addActionListener(e -> model.removeAllElements());
		remove.addActionListener((e) ->  {
			int idx = list.getSelectedIndex();
			if (idx > -1) {
				model.remove(idx);
			}
			tfItem.requestFocus();
		});
		tfItem.addKeyListener(new KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					addTf();
				}
			};
		});

		setSize(400, 300);
		setVisible(true);
	}

	private void exit() {
		System.exit(0);
	}
	
	public void addTf() {
		Entry toAdd = new Entry(tfItem.getText(), Integer.parseInt(tfCount.getText()));
		model.addElement(toAdd);
		tfItem.setText("");
		tfItem.requestFocus();
		tfCount.setText("");
	}
	
	private class Entry {
		private String item = "";
		private int count = 0;
		
		private Entry(String item, int count) {
			this.item = item;
			this.count = count;
		}
		
		private String getItem() {
			return this.item;
		}
		
		private int getCount() {
			return this.count;
		}
		
		@Override
		public String toString() {
			return item + "          " + count;
		}
	}
}
