import org.mindrot.jbcrypt.BCrypt;
import java.sql.*;

public class UserDAOExample {
    public static boolean createUser(user user) {
        boolean bool = false;
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        String query = "INSERT INTO user (firstName, lastName, email, password, isAdmin) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = DB_Connect.connect();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, hashedPassword);
            ps.setBoolean(5, user.isAdmin());
            int updatedRows = ps.executeUpdate();
            if (updatedRows > 0) {
                bool = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bool;
    }

    public static user getUserById(int id) {
        int userId = 0;
        String firstName = "";
        String lastName = "";
        String email = "";
        String password = "";
        boolean isAdmin = false;

        String query = "SELECT * FROM user WHERE id = ?";
        try {
            Connection conn = DB_Connect.connect();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                userId = rs.getInt("id");
                firstName = rs.getString("firstName");
                lastName = rs.getString("lastName");
                email = rs.getString("email");
                password = rs.getString("password");
                isAdmin = rs.getBoolean("isAdmin");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new user(userId, firstName, lastName, email, password, isAdmin);
    }

    public static user getUserByEmail(String email) {
        int userId = 0;
        String firstName = "";
        String lastName = "";
        String userEmail = "";
        String password = "";
        boolean isAdmin = false;

        String query = "SELECT * FROM user WHERE email = ?";
        try {
            Connection conn = DB_Connect.connect();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                userId = rs.getInt("id");
                firstName = rs.getString("firstName");
                lastName = rs.getString("lastName");
                userEmail = rs.getString("email");
                password = rs.getString("password");
                isAdmin = rs.getBoolean("isAdmin");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new user(userId, firstName, lastName, userEmail, password, isAdmin);
    }

    public static boolean updateUser(user user) {
        boolean bool = false;
        String query = "UPDATE user SET firstName = ?, lastName = ?, email = ?, password = ?, isAdmin = ? WHERE id = ?";
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        try {
            Connection conn = DB_Connect.connect();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, hashedPassword);
            ps.setBoolean(5, user.isAdmin());
            ps.setInt(6, user.getId());
            int updatedRows = ps.executeUpdate();
            if (updatedRows > 0) {
                bool = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bool;
    }

    public static boolean deleteUser(int id) {
        boolean bool = false;
        String query = "DELETE FROM user WHERE id = ?";
        try {
            Connection conn = DB_Connect.connect();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            int updatedRows = ps.executeUpdate();
            if (updatedRows > 0) {
                bool = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bool;
    }

    public static boolean verifyPassword(String email, String password) {
        boolean bool = false;
        String query = "SELECT password FROM user WHERE email = ?";
        try {
            Connection conn = DB_Connect.connect();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            String hashedPassword = "";
            while (rs.next()) {
                hashedPassword = rs.getString("password");
            }
            if (BCrypt.checkpw(password, hashedPassword)) {
                bool = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bool;
    }
}
