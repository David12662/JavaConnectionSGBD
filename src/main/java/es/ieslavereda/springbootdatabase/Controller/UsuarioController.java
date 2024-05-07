package es.ieslavereda.springbootdatabase.Controller;

import es.ieslavereda.springbootdatabase.Model.Usuario;
import es.ieslavereda.springbootdatabase.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class UsuarioController extends BaseController{
    @Autowired
    private UsuarioService usuarioService;

    private final Logger LOG = Logger.getLogger(getClass().getCanonicalName());

    @GetMapping("/usuarios")
    public ResponseEntity<?> getAllUsuarios(){
        try {
            LOG.log(Level.INFO,"Obteniendo todos los usuarios");
            return new ResponseEntity<>(usuarioService.getAll(), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>("Error al obtener los usuarios", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/user")
    public ResponseEntity<?> updateUsuario(@RequestBody Usuario usuario){
        try {
            LOG.log(Level.INFO,"Actualizando el usuario" + usuario.getId());
            return new ResponseEntity<>(usuarioService.updateUser(usuario), HttpStatus.OK);
        }catch (SQLException e) {
            return new ResponseEntity<>("Error al actualizar el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/users")
    public ResponseEntity<?> addUsuario(@RequestBody Usuario usuario){
        try {
            LOG.log(Level.INFO,"Añadiendo Usuarios");
            return new ResponseEntity<>(usuarioService.addUsuario(usuario), HttpStatus.OK);
        }catch (SQLException e) {
            return new ResponseEntity<>("Error al añadir usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable int id){
        try {
            LOG.log(Level.INFO,"Usuario eliminado");
            return new ResponseEntity<>(usuarioService.deleteUser(id), HttpStatus.OK);
        }catch (SQLException e){
            return new ResponseEntity<>("Error al eliminar el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
