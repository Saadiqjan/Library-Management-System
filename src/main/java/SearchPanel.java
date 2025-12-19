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
    private DefaultListModel<Book> model = new DefaultListModel<>();
    private JList<Book> resultList;
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
        searchBar.setBackground(MainFrame.BUTTON_COLOR);
        searchBar.setForeground(MainFrame.BUTTON_TEXT_COLOR);

        searchButton = new JButton("Search");
        searchButton.setFont(MainFrame.BUTTON_FONT);
        searchButton.setBackground(MainFrame.BUTTON_COLOR);
        searchButton.setForeground(MainFrame.BUTTON_TEXT_COLOR);
        searchButton.addActionListener(new SearchListener());

        resultList = new JList<Book>(model);

        resultList.setCellRenderer((listComp, value, index, isSelected, cellHasFocus) -> {
            JTextArea area = new JTextArea(value.getDisplayString());
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
        resultList.addMouseListener(new ListListener());

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
            String query = "SELECT title, author, isbn, copies_available FROM books WHERE title LIKE ? OR author LIKE ?";

            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query))
            {
                pstmt.setString(1, search);
                pstmt.setString(2, search);
                ResultSet rs = pstmt.executeQuery();
                Book result;
                model.clear();

                while (rs.next())
                {
                    result = new Book(rs.getString("title"), rs.getString("author"), rs.getString("isbn"), rs.getInt("copies_available"));
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

    public class ListListener implements MouseListener
    {
        @Override
        public void mouseClicked(MouseEvent e) 
        {
            int index = resultList.locationToIndex(e.getPoint());
            Book selected = resultList.getModel().getElementAt(index);
        }

        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {} 
    }
}
