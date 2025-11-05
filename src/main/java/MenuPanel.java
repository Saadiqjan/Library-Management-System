import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MenuPanel extends JPanel 
{
    private JPanel mainPanel;
    private CardLayout cardLayout;

    private JLabel title;

    private JButton search;
    private JButton adminLogin;
    private JButton exit;

    public MenuPanel (JPanel mainPanel, CardLayout cardLayout)
    {
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));
        setBackground(MainFrame.BACKGROUND_COLOR);

        title = new JLabel("Library Management System");
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        title.setFont(MainFrame.TITLE_FONT);
        title.setForeground(MainFrame.LABEL_COLOR);

        search = new JButton("Search");
        search.addActionListener(new SearchListener());

        adminLogin = new JButton("Admin Login");
        adminLogin.addActionListener(new AdminLoginListener());
        
        exit = new JButton("Exit");
        exit.addActionListener(new ExitListener());

        add(title);
        add(Box.createRigidArea(new Dimension(0, 40)));
        add(search);
        add(Box.createRigidArea(new Dimension(0, 40)));
        add(adminLogin);
        add(Box.createRigidArea(new Dimension(0, 40)));
        add(exit);

        for (Component comp : getComponents())
        {
            if (comp instanceof JButton)
            {
                JButton button = (JButton) comp;

                button.setFont(MainFrame.BUTTON_FONT);
                button.setAlignmentX(JButton.CENTER_ALIGNMENT);
                button.setBackground(MainFrame.BUTTON_COLOR);
                button.setForeground(MainFrame.BUTTON_TEXT_COLOR);
                button.setBorderPainted(false);
            }
        }
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
