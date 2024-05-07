package es.ieslavereda.springbootdatabase.Model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Usuario {

    private Integer id;
    private String nombre;
    private String apellidos;
    private Integer Oficio_idOficio;
    private String username;
    private String password;
}
