import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        BlobSQL blob = new BlobSQL();
        blob.blob();





















//        String login = "root";
//        String password = "admin";
//        String url = "jdbc:mysql://localhost:3306/test";
//        //Class.forName("com.mysql.jdbc.Driver");
//        try (Connection conn = DriverManager.getConnection(url, login, password);
//             Statement statement = conn.createStatement()) {
//            statement.executeUpdate("create table if not exists books (id mediumint not null auto_increment, name char(30) not null, img blob, primary key (id))");
//            //statement.executeUpdate("insert into books (name) values ('Inferno')");
//            //statement.executeUpdate("ALTER TABLE books ADD img blob null");
////            ResultSet rs = statement.executeQuery("Select * From books");
////            while (rs.next()) {
////                System.out.println(rs.getInt("id"));
////                System.out.println(rs.getString("name"));
////                System.out.println("---------------------------");
////            }
////            String userID = "1";
////            PreparedStatement prepareStatement = conn.prepareStatement("select * from Users where id = ?");
////            prepareStatement.setString(1, userID);
////            ResultSet rs1 = prepareStatement.executeQuery();
////            while (rs1.next()) {
////                System.out.println(rs1.getString("userID"));
////            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
