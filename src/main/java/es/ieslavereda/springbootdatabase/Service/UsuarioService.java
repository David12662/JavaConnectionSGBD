package es.ieslavereda.springbootdatabase.Service;

import es.ieslavereda.springbootdatabase.Model.Usuario;
import es.ieslavereda.springbootdatabase.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll() throws SQLException {
        return usuarioRepository.getAll();
    }

    public Usuario updateUser(Usuario usuario) throws SQLException {
        return usuarioRepository.updateUser(usuario);
    }

    public Usuario addUsuario(Usuario usuario) throws SQLException {
        return usuarioRepository.createUser(usuario);
    }

    public Usuario deleteUser(int id) throws SQLException {
        return usuarioRepository.removeById(id);
    }
}
