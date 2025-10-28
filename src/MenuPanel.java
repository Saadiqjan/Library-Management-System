import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuPanel extends JPanel 
{
    private JPanel mainPanel;
    private CardLayout cardLayout;

    private JButton search;
    private JButton adminLogin;
    private JButton exit;

    public MenuPanel (JPanel mainPanel, CardLayout cardLayout)
    {
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;

        search = new JButton("Search");
        search.setBounds(550, 300, 300, 100);
        search.addActionListener(new SearchListener());

        adminLogin = new JButton("Admin Login");
        adminLogin.setBounds(550, 450, 300, 100);
        adminLogin.addActionListener(new AdminLoginListener());
        
        exit = new JButton("Exit");
        exit.setBounds(550, 600, 300, 100);
        exit.addActionListener(new ExitListener());

        add(search);
        add(adminLogin);
        add(exit);
    }    

    public class SearchListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            cardLayout.show(mainPanel, "Search");
        }
    }

    public class AdminLoginListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            cardLayout.show(mainPanel, "Admin");
        }
    }

    public class ExitListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            System.exit(0);
        }
    }
}
