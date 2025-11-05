import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

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
    private JList resultList;
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

        String[] data = {"one", "two", "three", "four", "two", 
        "three", "four", "two", "three", "four", "two", "three", 
        "four", "two", "three", "four", "two", "three", "four", 
        "two", "three", "four", "two", "three", "four", "two", 
        "three", "four", "two", "three", "four"};
        resultList = new JList<String>(data);
        scroll = new JScrollPane(resultList);
        resultList.setFont(MainFrame.BUTTON_FONT);

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
            System.out.println(searchBar.getText());
        }
    }
}
