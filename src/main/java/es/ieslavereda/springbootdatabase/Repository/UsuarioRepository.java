package es.ieslavereda.springbootdatabase.Repository;

import es.ieslavereda.springbootdatabase.Bd.MyDataSource;
import es.ieslavereda.springbootdatabase.Model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
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

    public Usuario getById(int id) throws SQLException {
        try(Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM usuario WHERE idUsuario = " + id);){
            if(rs.next()){
                return rs.getObject("idUsuario", Usuario.class);
            }
        }

        return null;

    }

    public Usuario updateUser(Usuario usuario) throws SQLException {
        String sql="UPDATE usuario SET nombre=?,apellidos=?,Oficio_idOficio,username=?,password=? WHERE idUsuario =? " ;
        try(Connection con = dataSource.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getApellidos());
            pstmt.setInt(3, usuario.getOficio_idOficio());
            pstmt.setString(4, usuario.getUsername());
            pstmt.setString(5, usuario.getPassword());
            pstmt.setInt(6, usuario.getId());
            pstmt.executeUpdate();
        }

        return usuario;
    }

    public Usuario createUser(Usuario usuario) throws SQLException {
        String sql="INSERT into Usuario(id,nombre,apellidos,Oficio_idOficio,username,password) values (?,?,?,?,?,?)";
        try(Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, usuario.getId());
            pstmt.setString(2, usuario.getNombre());
            pstmt.setString(3, usuario.getApellidos());
            pstmt.setInt(4, usuario.getOficio_idOficio());
            pstmt.setString(5, usuario.getUsername());
            pstmt.setString(6, usuario.getPassword());
            pstmt.executeUpdate();
        }

        return usuario;

    }

    public Usuario removeById(int id) throws SQLException {
        String sql="DELETE FROM usuario WHERE idUsuario ="+id;
        Usuario usuario = getById(id);
       try(Connection con = dataSource.getConnection();
           PreparedStatement pstmt = con.prepareStatement(sql)
       ){

           pstmt.executeUpdate();
       }

       return usuario;
    }
}
