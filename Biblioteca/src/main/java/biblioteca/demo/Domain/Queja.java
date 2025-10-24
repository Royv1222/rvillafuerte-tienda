package biblioteca.demo.domain;

import jakarta.persistence.*;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity @Table(name = "queja")
public class Queja {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    private String email;
    private String telefono;

    // En tu SQL la columna se llama 2po (ENUM...), no la cambiamos
    @Column(name = "2po")
    private String tipo; // "QUEJA", "SUGERENCIA" o "CONSULTA"

    private String asunto;

    @Lob
    private String mensaje;

    private Boolean tratado = Boolean.FALSE;

  @Column(name = "created_at", insertable = false, updatable = false)
private java.sql.Timestamp createdAt;
}
