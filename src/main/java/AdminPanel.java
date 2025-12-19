import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminPanel extends JPanel
{
    private JPanel mainPanel;
    private CardLayout cardLayout;

    private CardLayout formLayout;
    private JPanel formPanel;

    public AdminPanel(JPanel mainPanel, CardLayout cardLayout)
    {
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;

        setLayout(new BorderLayout(15, 15));
        setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        setBackground(MainFrame.BACKGROUND_COLOR);

        add(createButtons(), BorderLayout.WEST);
        add(createFormPanel(), BorderLayout.EAST);
    }

    private JPanel createButtons()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));
        panel.setBackground(MainFrame.BACKGROUND_COLOR);

        JButton addBook = new JButton("Add Book");
        JButton removeBook = new JButton("Remove Book");
        JButton addMember = new JButton("Add Member");
        JButton removeMember = new JButton("Remove Member");
        JButton back = new JButton("Back");

        addBook.addActionListener(e -> formLayout.show(formPanel, "ADD_BOOK"));
        removeBook.addActionListener(e -> formLayout.show(formPanel, "REMOVE_BOOK"));
        addMember.addActionListener(e -> formLayout.show(formPanel, "ADD_MEMBER"));
        removeMember.addActionListener(e -> formLayout.show(formPanel, "REMOVE_MEMBER"));
        back.addActionListener(e -> cardLayout.show(mainPanel, "Menu"));

        panel.add(addBook);
        panel.add(removeBook);
        panel.add(addMember);
        panel.add(removeMember);
        panel.add(back);

        for (Component comp : panel.getComponents())
        {
            if (comp instanceof JButton)
            {
                JButton button = (JButton) comp;

                button.setFont(MainFrame.BUTTON_FONT);
                button.setAlignmentX(JButton.LEFT_ALIGNMENT);
                button.setBackground(MainFrame.BUTTON_COLOR);
                button.setForeground(MainFrame.BUTTON_TEXT_COLOR);
                button.setBorderPainted(false);
            }
        }

        return panel;
    }

    private JPanel createFormPanel() 
    {
        formLayout = new CardLayout();
        formPanel = new JPanel(formLayout);

        formPanel.add(createAddBookForm(), "ADD_BOOK");
        formPanel.add(createRemoveBookForm(), "REMOVE_BOOK");
        formPanel.add(createAddMemberForm(), "ADD_MEMBER");
        formPanel.add(createRemoveMemberForm(), "REMOVE_MEMBER");

        JPanel panel = new JPanel();
        panel.setBackground(MainFrame.BACKGROUND_COLOR);

        formPanel.add(panel, "EMPTY");

        formLayout.show(formPanel, "EMPTY");

        return formPanel;
    }

    private JPanel createAddBookForm() 
    {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(MainFrame.BACKGROUND_COLOR);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        JTextField titleField = new JTextField(20);
        JTextField authorField = new JTextField(20);
        JTextField isbnField = new JTextField(20);

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Title:"), gbc);
        gbc.gridx = 1;
        panel.add(titleField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Author:"), gbc);
        gbc.gridx = 1;
        panel.add(authorField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("ISBN:"), gbc);
        gbc.gridx = 1;
        panel.add(isbnField, gbc);

        JButton submit = new JButton("Add Book");
        gbc.gridx = 1; gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(submit, gbc);

        for (Component comp : panel.getComponents())
        {
            comp.setFont(MainFrame.BUTTON_FONT);
            comp.setForeground(MainFrame.BUTTON_TEXT_COLOR);
            comp.setBackground(MainFrame.BUTTON_COLOR);
        }

        return panel;
    }

    private JPanel createRemoveBookForm() 
    {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(MainFrame.BACKGROUND_COLOR);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        JTextField isbnField = new JTextField(20);

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("ISBN:"), gbc);
        gbc.gridx = 1;
        panel.add(isbnField, gbc);

        JButton submit = new JButton("Remove Book");
        gbc.gridx = 1; gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(submit, gbc);

        for (Component comp : panel.getComponents()) {
            comp.setFont(MainFrame.BUTTON_FONT);
            comp.setForeground(MainFrame.BUTTON_TEXT_COLOR);
            comp.setBackground(MainFrame.BUTTON_COLOR);
        }

        return panel;
    }

    private JPanel createAddMemberForm() 
    {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(MainFrame.BACKGROUND_COLOR);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        JTextField nameField = new JTextField(20);
        JTextField emailField = new JTextField(20);

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        panel.add(emailField, gbc);

        JButton submit = new JButton("Add Member");
        gbc.gridx = 1; gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(submit, gbc);

        for (Component comp : panel.getComponents()) {
            comp.setFont(MainFrame.BUTTON_FONT);
            comp.setForeground(MainFrame.BUTTON_TEXT_COLOR);
            comp.setBackground(MainFrame.BUTTON_COLOR);
        }

        return panel;
    }

    private JPanel createRemoveMemberForm() 
    {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(MainFrame.BACKGROUND_COLOR);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        JTextField emailField = new JTextField(20);

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        panel.add(emailField, gbc);

        JButton submit = new JButton("Remove Member");
        gbc.gridx = 1; gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(submit, gbc);

        for (Component comp : panel.getComponents()) {
            comp.setFont(MainFrame.BUTTON_FONT);
            comp.setForeground(MainFrame.BUTTON_TEXT_COLOR);
            comp.setBackground(MainFrame.BUTTON_COLOR);
        }

        return panel;
    }
}