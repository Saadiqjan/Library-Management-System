import java.sql.*;

public class Main
{
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

        new MainFrame().setVisible(true);
    }
}
