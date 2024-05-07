package es.ieslavereda.springbootdatabase.Repository;

import es.ieslavereda.springbootdatabase.Model.Oficio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OficioRepository {
    @Autowired
    @Qualifier("mysqlDataSource")
    DataSource dataSource;


    public List<Oficio> getAll() throws SQLException {
        List<Oficio> oficios = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM oficio")){
                 while (resultSet.next()) {
                     oficios.add(Oficio.builder().idOficio(resultSet.getInt("idOficio"))
                             .descripcion("descripcion")
                             .imageUrl("imageurl")
                             .build());
                 }
        }
        return oficios;
    }

    public Oficio update(Oficio oficio) throws SQLException {
        String sql = "UPDATE oficio SET descripcion = ?,imageurl=? WHERE idOficio = ?";
        try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, oficio.getDescripcion());
            preparedStatement.setString(2, oficio.getImageUrl());
            preparedStatement.executeUpdate();

        }
        return oficio;
    }

    public Oficio create(Oficio oficio) throws SQLException {
        String sql = "INSERT INTO oficio(idOficio,descripcion,imageurl) VALUES(?,?,?)";
        try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, oficio.getIdOficio());
            preparedStatement.setString(2, oficio.getDescripcion());
            preparedStatement.setString(3, oficio.getImageUrl());
        }

        return oficio;
    }

    public Oficio delete(int idOficio) throws SQLException {
        String sql = "DELETE FROM oficio WHERE idOficio = " + idOficio;
        try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.executeUpdate();
        }
        return Oficio.builder().idOficio(idOficio).build();
    }
}
