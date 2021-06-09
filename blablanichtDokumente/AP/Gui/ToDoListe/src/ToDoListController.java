import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ToDoListController extends AbstractListModel<Entry> implements ListModel<Entry> {

    List<Entry> toDoList = new ArrayList<>();

    @Override
    public int getSize() {
        return  toDoList.size();
    }

    @Override
    public Entry getElementAt(int index) {
        return toDoList.get(index);
    }

    public ToDoListController() {
        loadList();
    }

    void loadList() {
        try {
            File f = new File("todoList.txt");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(f), StandardCharsets.UTF_8
                    ));
            String line;
            while ((line = in.readLine()) != null ) {
                if (!line.trim().equals("")) {
                    Entry newEntry = new Entry(line);
                    addElement(newEntry);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    protected void saveList() {
        try {
            StringBuilder text = new StringBuilder();
            for (int i = 0; i < toDoList.size(); i++) {
                text.append("\n").append(getElementAt(i));
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

    public void removeAllElements() {
        toDoList.clear();
    }

    public void remove(int idx) {
        toDoList.remove(idx);
    }

    public void addElement(Entry toAdd) {
        toDoList.add(toAdd);
    }
}
