import java.sql.*;

public class StudentDAO {
    static final String URL = "jdbc:mysql://localhost:3306/school";
    static final String USER = "root", PASS = "yourpassword";

    static void insert(int id, String name) throws Exception {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement("INSERT INTO students(id, name) VALUES(?, ?)")) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.executeUpdate();
            System.out.println("Inserted: " + name);
        }
    }

    static void update(int id, String newName) throws Exception {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement("UPDATE students SET name=? WHERE id=?")) {
            ps.setString(1, newName);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Updated ID " + id + " to " + newName);
        }
    }

    public static void main(String[] args) throws Exception {
        insert(1, "Alice");
        update(1, "Alice Johnson");
    }
}