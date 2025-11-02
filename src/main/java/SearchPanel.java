import java.awt.*;
import javax.swing.*;

public class SearchPanel extends JPanel
{
    private JPanel mainPanel;
    private CardLayout cardLayout;

    private JTextField searchBar;

    public SearchPanel(JPanel mainPanel, CardLayout cardLayout)
    {
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;
    }
}
