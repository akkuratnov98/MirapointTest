import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.sql.*;

public class BlobSQL extends BaseJDBC {

    public BlobSQL(){
        super();
    }


    public void blob()  {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("update books set name = 'Ivan13' where id = 1");
        } catch (SQLException e) {
            e.printStackTrace();
        }


//               try {
//            BufferedImage bufferedImage = ImageIO.read(new File(String.valueOf(Paths.get("src/main/resources/image/img.png"))));
//            Blob blob = conn.createBlob();
//            try (OutputStream outputStream = blob.setBinaryStream(1)) {
//                ImageIO.write(bufferedImage, "png", outputStream);
//            }
//            Statement statement1 = conn.createStatement();
//            statement1.executeUpdate("update books set name = 'Ivan' where id = 1");

//            PreparedStatement statement = conn.prepareStatement("update books set name = 'Ivan2' where id = 1");
//            statement.setBlob(1, blob);
//            statement.execute();
//        } catch (SQLException | IOException e) {
//            e.printStackTrace();
//        }
        //ResultSet resultSet = stat.executeQuery();


    }
}
