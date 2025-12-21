import javax.swing.*;
import db.DatabaseConnection;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AdminPanel extends JPanel
{
    private JPanel mainPanel;
    private CardLayout cardLayout;

    private CardLayout formLayout;
    private JPanel formPanel;

    private JTextField titleField;
    private JTextField authorField;
    private JTextField isbnField;
    private JTextField copiesField;

    private JTextField isbnRemField;

    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;

    private JTextField emailRemField;

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

        titleField = new JTextField(20);
        authorField = new JTextField(20);
        isbnField = new JTextField(20);
        copiesField = new JTextField(10);

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

        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Copies Available:"), gbc);
        gbc.gridx = 1;
        panel.add(copiesField, gbc);

        JButton submit = new JButton("Add Book");
        gbc.gridx = 1; gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(submit, gbc);
        submit.addActionListener(e -> addBook());

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

        isbnRemField = new JTextField(20);

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("ISBN:"), gbc);
        gbc.gridx = 1;
        panel.add(isbnRemField, gbc);

        JButton submit = new JButton("Remove Book");
        gbc.gridx = 1; gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(submit, gbc);
        submit.addActionListener(e -> removeBook());

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

        nameField = new JTextField(20);
        emailField = new JTextField(20);
        phoneField = new JTextField(20);

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        panel.add(emailField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Phone:"), gbc);
        gbc.gridx = 1;
        panel.add(phoneField, gbc);

        JButton submit = new JButton("Add Member");
        gbc.gridx = 1; gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(submit, gbc);
        submit.addActionListener(e -> addMember());

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

        emailRemField = new JTextField(20);

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        panel.add(emailRemField, gbc);

        JButton submit = new JButton("Remove Member");
        gbc.gridx = 1; gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(submit, gbc);
        submit.addActionListener(e -> removeMember());

        for (Component comp : panel.getComponents()) {
            comp.setFont(MainFrame.BUTTON_FONT);
            comp.setForeground(MainFrame.BUTTON_TEXT_COLOR);
            comp.setBackground(MainFrame.BUTTON_COLOR);
        }

        return panel;
    }

    private void addBook()
    {
        String query = "INSERT INTO books (title, author, isbn, copies_available) values (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query))
        {
            String title = titleField.getText().trim();
            String author = authorField.getText().trim();
            String isbn = isbnField.getText().trim();
            int copies_available = Integer.parseInt(copiesField.getText().trim());

            if (title.isEmpty() || author.isEmpty() || isbn.isEmpty())
            {
                throw new Exception("Empty fields");
            }

            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, isbn);
            pstmt.setInt(4, copies_available);

            pstmt.executeUpdate();

            conn.close();
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private void removeBook()
    {
        String query = "REMOVE FROM books WHERE isbn=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query))
        {
            String isbn = isbnRemField.getText().trim();

            if (isbn.isEmpty())
            {
                throw new Exception("Empty FIelds");
            }

            pstmt.setString(1, isbn);

            pstmt.executeUpdate();

            conn.close();
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private void addMember()
    {
        String query = "INSERT INTO members (name, email, phone, join_date) values (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query))
        {
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String phone = phoneField.getText().trim();
            java.util.Date date = new java.util.Date();

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty())
            {
                throw new Exception("Empty fields");
            }

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.setDate(4, new java.sql.Date(date.getTime()));

            pstmt.executeUpdate();

            conn.close();
        }   
        catch (SQLException se)
        {
            se.printStackTrace();
        }   
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private void removeMember()
    {
        String query = "REMOVE FROM members WHERE email=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query))
        {
            String email = emailRemField.getText().trim();

            if (email.isEmpty())
            {
                throw new Exception("Empty FIelds");
            }

            pstmt.setString(1, email);

            pstmt.executeUpdate();

            conn.close();
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}