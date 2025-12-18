import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminPanel extends JPanel
{
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public AdminPanel(JPanel mainPanel, CardLayout cardLayout)
    {
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;

        
    }
}
