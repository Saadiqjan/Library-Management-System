import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame
{
    public static final Color BACKGROUND_COLOR = new Color(201, 173, 167);
    public static final Color LABEL_COLOR = new Color(34, 34, 59);
    public static final Color BUTTON_COLOR = new Color(242, 233, 228);
    public static final Color BUTTON_TEXT_COLOR = new Color(74, 78, 105);

    public static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 44);
    public static final Font BUTTON_FONT = new Font("Segoe UI", Font.PLAIN, 24);

    private JPanel mainPanel;
    private CardLayout cardLayout;

    private MenuPanel menuPanel;
    private SearchPanel searchPanel;
    private AdminPanel adminPanel;

    public MainFrame() 
    {
        setTitle("Library");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        menuPanel = new MenuPanel(mainPanel, cardLayout);
        searchPanel = new SearchPanel(mainPanel, cardLayout);
        adminPanel = new AdminPanel(mainPanel, cardLayout);

        mainPanel.add(menuPanel, "Menu");
        mainPanel.add(searchPanel, "Search");
        mainPanel.add(adminPanel, "Admin");

        add(mainPanel);
    }
}
