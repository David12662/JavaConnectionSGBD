package es.ieslavereda.springbootdatabase.Repository;

import es.ieslavereda.springbootdatabase.Bd.MyDataSource;
import es.ieslavereda.springbootdatabase.Model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {
    @Autowired
            @Qualifier("mysqlDataSource")
    DataSource dataSource;


    public List<Usuario> getAll() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        try(Connection con = dataSource.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");){
            while(rs.next()){
                usuarios.add(Usuario.builder().id(rs.getInt("idUsuario"))
                        .nombre(rs.getString("nombre"))
                        .apellidos(rs.getString("apellidos"))
                        .Oficio_idOficio(rs.getInt("Oficio_idOficio"))
                        .username(rs.getString("username"))
                        .password(rs.getString("password")).build());
            }
            return usuarios;

        }

    }
}
