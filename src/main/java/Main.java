import javax.swing.*;
import com.formdev.flatlaf.FlatLightLaf;

public class Main
{
    private static MainFrame mainFrame;

    public static void main(String[] args)
    {
        // try (Connection conn = db.DatabaseConnection.getConnection()) 
        // {
        //     if (conn == null) 
        //     {
        //         System.out.println("Could not connect to DB.");
        //         return;
        //     }
        // } 
        // catch (SQLException e) 
        // {
        //     e.printStackTrace();
        // }

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
            mainFrame.setVisible(true);
        });   
    }
}
