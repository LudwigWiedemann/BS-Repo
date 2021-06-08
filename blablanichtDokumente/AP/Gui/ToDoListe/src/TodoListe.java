import jdk.nashorn.internal.runtime.regexp.joni.constants.EncloseType;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;

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

    // Buttons
    JPanel panelButtons = new JPanel();
    JButton add = new JButton("Add");
    JButton remove = new JButton("Remove");
    JButton removeAll = new JButton("Remove All");
    JButton exit = new JButton("Exit");

    // initialize new ListModel
    private DefaultListModel<Entry> model = new DefaultListModel<>();
    // initialize a list and pass the model in the constructor
    JList<Entry> list = new JList<>(model);
    // add a scroll pane and add the list to it
    JScrollPane sp = new JScrollPane(list);

    //add panels and text fields
    JPanel panelInput = new JPanel();
    JLabel labelItem = new JLabel("Item: ");
    JLabel labelCount = new JLabel("Count: ");
    JTextField tfItem = new JTextField(15);
    JTextField tfCount = new JTextField(9);
    Container con = getContentPane();


    public TodoListe() {
        super();
        panelButtons.setLayout(new GridLayout(4, 1));
        panelInput.setLayout(new FlowLayout(FlowLayout.LEFT));
        setTitle("Todo Liste");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                exit();
            }
        });
        loadList();

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
        remove.addActionListener((e) -> {
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
            }
        });

        setSize(400, 300);
        setVisible(true);
    }

    private void exit() {
        this.saveList();
        System.exit(0);
    }

    private void saveList() {
        try {
            StringBuilder text = new StringBuilder();
            for (int i = 0; i < model.size(); i++) {
                text.append("\n").append(model.getElementAt(i));
            }
            File f = new File("datei.txt");
            BufferedWriter out = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(f), StandardCharsets.UTF_8
                    ));
            out.write(text.toString());
            out.newLine();
            out.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    private void loadList() {
        try {
            File f = new File("datei.txt");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(f), StandardCharsets.UTF_8
                    ));
            String line;
            while ((line = in.readLine()) != null ) {
                if (!line.trim().equals("")) {
                    Entry newEntry = new Entry(line);
                    model.addElement(newEntry);
                }
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    public void addTf() {
        Entry toAdd = new Entry(tfItem.getText(), Integer.parseInt(tfCount.getText()));
        model.addElement(toAdd);
        tfItem.setText("");
        tfItem.requestFocus();
        tfCount.setText("");
    }

    // inner class that is is public bc can only be accessed from the class, it sits in
    private class Entry {
        String item;
        int count;

        private Entry(String item, int count) {
            this.item = item;
            this.count = count;
        }

        private Entry(String lineInFile){
            String[] splitLine = lineInFile.split(" ");
            item = splitLine[0].trim();
            count = Integer.parseInt(splitLine[splitLine.length-1].trim());
        }

        String getItem() {
            return this.item;
        }

        int getCount() {
            return this.count;
        }

        @Override
        public String toString() {
            return item + "          " + count;
        }
    }
}
