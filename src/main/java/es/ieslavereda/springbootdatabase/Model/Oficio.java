package es.ieslavereda.springbootdatabase.Model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Oficio {
    private int idOficio;
    private String descripcion;
    private String imageUrl;
}
