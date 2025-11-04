import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchPanel extends JPanel
{
    private JPanel mainPanel;
    private CardLayout cardLayout;

    private JTextField searchBar;
    private JButton searchButton;

    public SearchPanel(JPanel mainPanel, CardLayout cardLayout)
    {
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;

        setLayout(new FlowLayout());
        setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));
        setBackground(MainFrame.BACKGROUND_COLOR);

        searchBar = new JTextField(50);

        searchButton = new JButton("Search");

        add(searchBar);
        add(searchButton);
    }


}
