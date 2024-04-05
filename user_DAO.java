import org.mindrot.jbcrypt.BCrypt;
import java.sql.*;

public class user_DAO {
    public boolean createUser(user user) {
        Connection conn = DB_Connect.connect();
        String query = "INSERT INTO user (firstName, lastName, email, password, isAdmin) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            ps.setBoolean(5, user.isAdmin());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
