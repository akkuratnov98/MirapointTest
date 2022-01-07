import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.sql.*;

public class BaseJDBC {

    String login = "root";
    String password = "admin";
    String url = "jdbc:mysql://localhost:3306/test";
    Connection conn;

    public BaseJDBC() {
        try {
            conn = DriverManager.getConnection(url, login, password);
            Statement statement = conn.createStatement();

            statement.executeUpdate("update books set name = 'Ivan11' where id = 1");

            BufferedImage bufferedImage = ImageIO.read(new File(String.valueOf(Paths.get("src/main/resources/image/img_2.png"))));
            Blob blob = conn.createBlob();
            try (OutputStream outputStream = blob.setBinaryStream(1)) {
                ImageIO.write(bufferedImage, "png", outputStream);
            }
            PreparedStatement statement1 = conn.prepareStatement("update books set img = ? where id = 1");
            statement1.setBlob(1, blob);
            //statement1.setTime(2, new Date());
            statement1.execute();
            System.out.println(statement1);

            ResultSet rs = statement1.executeQuery("select img from books");
            while (rs.next()) {
                Blob blob2 = rs.getBlob("img");
                BufferedImage image2 = ImageIO.read(blob.getBinaryStream());
                File outputFile = new File("saved.png");
                ImageIO.write(image2, "png", outputFile);
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }
}

