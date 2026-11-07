
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;

public class Peliculas {

    private String clave, Titulo;
    private ImageIcon cartel;

    public Peliculas(String clave, String Titulo, ImageIcon cartel) {
        this.clave = clave;
        this.Titulo = Titulo;
        this.cartel = cartel;
    }

    public int insertar(Conexion cnx) {
        try {
            String sql = "INSERT INTO peliculas VALUES (?,?,?)";
            PreparedStatement ps = cnx.con.prepareStatement(sql);
            ps.setString(1, clave);
            ps.setString(2, Titulo);
            ps.setBytes(3, cnx.ImagenBytes(cartel));
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
            return 0;
        }
    }
}
