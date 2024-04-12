import org.mindrot.jbcrypt.BCrypt;
import java.sql.*;

public class user_DAO {
    public boolean createUser(user user) {
        Connection conn = DB_Connect.connect();
        String hashPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        String query = "INSERT INTO user (firstName, lastName, email, password, isAdmin) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, hashPassword);
            ps.setBoolean(5, user.isAdmin());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    };

    public static user getUserById(int id) {
        Connection conn = DB_Connect.connect();
        String query = "SELECT * FROM user WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new user(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"), query, rs.getBoolean("isAdmin"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    };

    public user getUserByEmail(String email) {
        Connection conn = DB_Connect.connect();
        String query = "SELECT * FROM user WHERE email = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new user(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"), query, rs.getBoolean("isAdmin"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    };

    public boolean updateUser(user user) {
        Connection conn = DB_Connect.connect();
        String query = "UPDATE user SET firstName = ?, lastName = ?, email = ?, password = ?, isAdmin = ? WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            ps.setBoolean(5, user.isAdmin());
            ps.setInt(6, user.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    };

    public boolean deleteUser(int id) {
        Connection conn = DB_Connect.connect();
        String query = "DELETE FROM user WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    };

    public boolean verifyPassword(String email, String password) {
        Connection conn = DB_Connect.connect();
        String query = "SELECT password FROM user WHERE email = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return BCrypt.checkpw(password, rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    };
}
