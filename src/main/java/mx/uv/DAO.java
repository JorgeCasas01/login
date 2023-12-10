package mx.uv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Data Access Object
public class DAO {

    public static RespuestaUsuario logingUs(String correo, String password) {
        PreparedStatement pst;
        ResultSet rs = null;
        Connection conexion;
        conexion = Conexion.getConnection();
        Usuario usuario = new Usuario();
        RespuestaUsuario respuesta = new RespuestaUsuario();
        respuesta.setEstado(400);

        try {
            String sql = "select * from usuario where correo= ? and password= ?";
            pst = (PreparedStatement) conexion.prepareStatement(sql);
            pst.setString(1, correo);
            pst.setString(2, password);
            rs = pst.executeQuery();
            while (rs.next()) {

                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setPassword(rs.getString("password"));
                usuario.setCorreo(rs.getString("correo"));
                respuesta.setEstado(200);
                respuesta.setContenido("Loging exitoso");
                respuesta.setUsuario(usuario);

            }

        } catch (Exception e) {
            System.out.println(e);
            // respuesta.setEstado(400);
            respuesta.setContenido(e.toString());

        } finally {
            try {
                conexion.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return respuesta;

    }

}
