import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame
{
    private JPanel mainPanel;
    private CardLayout cardLayout;

    private MenuPanel menuPanel;
    private SearchPanel searchPanel;

    public MainFrame() 
    {
        setTitle("Library");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        menuPanel = new MenuPanel(mainPanel, cardLayout);
        searchPanel = new SearchPanel(mainPanel, cardLayout);

        mainPanel.add(menuPanel, "Menu");
        mainPanel.add(searchPanel, "Search");

        add(mainPanel);
    }
}
