package es.ieslavereda.springbootdatabase.Controller;

import es.ieslavereda.springbootdatabase.Model.Oficio;
import es.ieslavereda.springbootdatabase.Service.OficioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;
@RestController
public class OficioController extends BaseController{

    private final Logger LOG = Logger.getLogger(getClass().getCanonicalName());

    @Autowired
    private OficioService oficioService;

    @GetMapping("/Oficio")
    public ResponseEntity<?> getOficios() {
        LOG.log(Level.INFO,"Obteniendo todos  los Oficios");
        return new ResponseEntity<>(oficioService.getAll(), HttpStatus.OK);

    }
}

