import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TodoList extends JFrame {

    // List<Entry> toDoList = new ArrayList<>();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new TodoList();
    }

    // Buttons
    JPanel panelButtons = new JPanel();
    JButton add = new JButton("Add");
    JButton remove = new JButton("Remove");
    JButton removeAll = new JButton("Remove All");
    JButton exit = new JButton("Exit");

    // initialize new ListModel (not in use)
    private final DefaultListModel<Entry> model = new DefaultListModel<>();

    // use our own controller instead of the defaultListModel
    //private final ToDoListController controller = new ToDoListController();

    // initialize a list and pass the controller in the constructor
    JList<Entry> listUI = new JList<>(model);

    // add a scroll pane and add the list to it
    JScrollPane sp = new JScrollPane(listUI);

    //add panels and text fields
    JPanel panelInput = new JPanel();
    JLabel labelItem = new JLabel("Item: ");
    JLabel labelCount = new JLabel("Count: ");
    JTextField tfItem = new JTextField(15);
    JTextField tfCount = new JTextField(9);
    Container con = getContentPane();

    public TodoList() {
        super();
        panelButtons.setLayout(new GridLayout(4, 1));
        panelInput.setLayout(new FlowLayout(FlowLayout.LEFT));
        setTitle("Todo list");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                onExit();
            }
        });

        // add the UI elements to the container
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

        // add action listeners
        exit.addActionListener((e) -> onExit());
        add.addActionListener(e -> onAddItem());
        removeAll.addActionListener(e -> model.removeAllElements());
        remove.addActionListener((e) -> {
            int idx = listUI.getSelectedIndex();
            if (idx > -1) {
                model.remove(idx);
            }
            tfItem.requestFocus();
        });
        tfItem.addKeyListener(new KeyAdapter () {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    tfCount.requestFocus();
                }
            }
        });
        tfCount.addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    onAddItem();
                }
            }
        });
        setSize(400, 300);
        setVisible(true);
    }

    private void onExit() {
        saveList();
        System.exit(0);
    }

    public void onAddItem() {
        Entry toAdd = new Entry(tfItem.getText(), Integer.parseInt(tfCount.getText()));
        model.addElement(toAdd);
        tfItem.setText("");
        tfItem.requestFocus();
        tfCount.setText("");
        saveList();
    }

    protected void saveList() {
        try {
            StringBuilder text = new StringBuilder();
            for (int i = 0; i < model.getSize(); i++) {
                text.append("\n").append(model.getElementAt(i));
            }
            File f = new File("todoList.txt");
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
}

