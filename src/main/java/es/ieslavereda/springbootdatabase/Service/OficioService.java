package es.ieslavereda.springbootdatabase.Service;

import es.ieslavereda.springbootdatabase.Model.Oficio;
import es.ieslavereda.springbootdatabase.Repository.OficioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service

public class OficioService {
    @Autowired
    private OficioRepository oficioRepository;

    public List<Oficio> getAll() throws SQLException {
        return oficioRepository.getAll();
    }

    public Oficio updateOficio(Oficio oficio) throws SQLException {
        return oficioRepository.update(oficio);
    }

    public Oficio addOficio(Oficio oficio) throws SQLException {
        return oficioRepository.create(oficio);
    }

    public Oficio delete(int idOficio) throws SQLException {
        return oficioRepository.delete(idOficio);
    }
}
