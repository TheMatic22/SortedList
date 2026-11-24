import javax.swing.*;
import java.awt.*;

public class SortedListGUI extends JFrame {

    private SortedList list = new SortedList();

    private JTextField addField = new JTextField(15);
    private JButton addButton = new JButton("Add");
    private JTextField searchField = new JTextField(15);
    private JButton searchButton = new JButton("Search");
    private JTextArea displayArea = new JTextArea(15, 40);

    public SortedListGUI() {
        super("Sorted List");
        setLayout(new BorderLayout());

        JPanel addPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        addPanel.add(new JLabel("Add string:"));
        addPanel.add(addField);
        addPanel.add(addButton);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.add(new JLabel("Search for:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.add(addPanel);
        topPanel.add(searchPanel);

        displayArea.setEditable(false);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        addButton.addActionListener(e -> addString());
        searchButton.addActionListener(e -> searchString());


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void addString() {
        String text = addField.getText().trim();
        if (text.isEmpty()) {
            return;
        }

        list.add(text);

        displayArea.append("Added \"" + text + "\"\n");
        displayArea.append(list.toString() + "\n");

        addField.setText("");
        addField.requestFocus();
    }

    private void searchString() {
        String text = searchField.getText().trim();
        if (text.isEmpty()) {
            return;
        }

        displayArea.append("Search: " + list.search(text) + "\n\n");

        searchField.setText("");
        searchField.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SortedListGUI::new);
    }
}
