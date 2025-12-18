import javax.swing.*;
import java.sql.*;
import com.formdev.flatlaf.FlatLightLaf;

public class Main
{
    private static MainFrame mainFrame;

    public static void main(String[] args)
    {
        try 
        {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            mainFrame = new MainFrame();
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.pack();
            mainFrame.setVisible(true);
        });   
    }
}
