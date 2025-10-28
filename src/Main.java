import java.sql.*;

public class Main
{
    private static MainFrame mainFrame;

    public static void main(String[] args)
    {
        try (Connection conn = db.DatabaseConnection.getConnection()) 
        {
            if (conn == null) 
            {
                System.out.println("Could not connect to DB.");
                return;
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}
