package es.ieslavereda.springbootdatabase.Controller;

import es.ieslavereda.springbootdatabase.Model.Oficio;
import es.ieslavereda.springbootdatabase.Service.OficioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
@RestController
public class OficioController extends BaseController{

    private final Logger LOG = Logger.getLogger(getClass().getCanonicalName());

    @Autowired
    private OficioService oficioService;

    @GetMapping("/Oficio")
    public ResponseEntity<?> getOficios() {
        try {
            LOG.log(Level.INFO, "Obteniendo todos  los Oficios");
            return new ResponseEntity<>(oficioService.getAll(), HttpStatus.OK);
        }catch (SQLException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/Uoficio")
    public ResponseEntity<?> updateOficio(@RequestBody Oficio oficio) {
        try {
            LOG.log(Level.INFO, "Actualizando el oficio con id: " + oficio.getIdOficio());
            return new ResponseEntity<>(oficioService.updateOficio(oficio), HttpStatus.OK);
        }catch (SQLException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/newOficio")
    public ResponseEntity<?> addOficio(@RequestBody Oficio oficio) {
        try {
            LOG.log(Level.INFO, "Nuevo Oficio con id: " + oficio.getIdOficio());
            return new ResponseEntity<>(oficioService.addOficio(oficio),HttpStatus.OK);
        }catch (SQLException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/remOficio")
    public ResponseEntity<?> deleteOficio(@RequestBody Oficio oficio) {
        try {
            LOG.log(Level.INFO, "Eliminando Oficio con id: " + oficio.getIdOficio());
            return new ResponseEntity<>(oficioService.delete(oficio.getIdOficio()),HttpStatus.OK);
        }catch (SQLException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

