import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuPanel extends JPanel 
{
    private JPanel mainPanel;
    private CardLayout cardLayout;

    private JButton search;

    public MenuPanel (JPanel mainPanel, CardLayout cardLayout)
    {
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;

        search = new JButton("Search for a Book");
        search.setBounds(550, 300, 300, 100);
        search.addActionListener(new SearchListener());
        
        add(search);
    }    

    public class SearchListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            cardLayout.show(mainPanel, "Search");
        }
    }
}
