import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import db.DatabaseConnection;

public class SearchPanel extends JPanel
{
    // Store main panel and card layout
    private JPanel mainPanel;
    private CardLayout cardLayout;

    // Store Nested Panels
    private JPanel resultPanel;
    private JPanel searchBarPanel;

    // Store searchBarPanel's components
    private JTextField searchBar;
    private JButton searchButton;
    
    // Store resultPanel's components
    private DefaultListModel<String> model = new DefaultListModel<>();
    private JList<String> resultList;
    private JScrollPane scroll;

    public SearchPanel(JPanel mainPanel, CardLayout cardLayout)
    {
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));
        setBackground(MainFrame.BACKGROUND_COLOR);

        searchBarPanel = new JPanel();
        searchBarPanel.setLayout(new FlowLayout());
        searchBarPanel.setBackground(MainFrame.BACKGROUND_COLOR);

        resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());

        searchBar = new JTextField(30);
        searchBar.setFont(MainFrame.BUTTON_FONT);

        searchButton = new JButton("Search");
        searchButton.setFont(MainFrame.BUTTON_FONT);
        searchButton.addActionListener(new SearchListener());

        resultList = new JList<String>(model);

        resultList.setCellRenderer((listComp, value, index, isSelected, cellHasFocus) -> {
            JTextArea area = new JTextArea(value);
            area.setLineWrap(true);
            area.setWrapStyleWord(true);
            area.setOpaque(true);
            area.setFont(MainFrame.LIST_FONT);

            if (isSelected) 
            {
                area.setBackground(listComp.getSelectionBackground());
                area.setForeground(listComp.getSelectionForeground());
            }

            return area;
        });

        scroll = new JScrollPane(resultList);
        scroll.setPreferredSize(new Dimension(400, 500));
        resultList.setFixedCellHeight(75);

        searchBarPanel.add(searchBar);
        searchBarPanel.add(searchButton);

        resultPanel.add(scroll, BorderLayout.CENTER);

        add(searchBarPanel);
        add(resultPanel);
    }

    public class SearchListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            String search = "%" + searchBar.getText() + "%";
            String query = "SELECT title, author, isbn FROM books WHERE title LIKE ? OR author LIKE ?";

            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query))
            {
                pstmt.setString(1, search);
                pstmt.setString(2, search);
                ResultSet rs = pstmt.executeQuery();
                String result = "";
                model.clear();

                while (rs.next())
                {
                    result = rs.getString("title") + " by " + rs.getString("author") + "\nISBN: " + rs.getString("isbn");
                    model.addElement(result);
                }

                conn.close();
            }
            catch (SQLException se)
            {
                se.printStackTrace();
            }
        }
    }
}
