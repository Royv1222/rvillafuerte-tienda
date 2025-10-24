package biblioteca.demo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity @Table(name = "libro")
public class Libro {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "2tulo")
  @NotBlank(message = "El título es obligatorio")
  private String titulo;

  @NotBlank(message = "El autor es obligatorio")
  private String autor;

  private String isbn;

  @Lob private String descripcion;

  @ManyToOne(optional = false)
  @JoinColumn(name = "categoria_id", nullable = false)
  @NotNull(message = "Seleccione una categoría")
  private Categoria categoria;

  @Column(name = "fecha_publicacion")
  private java.sql.Date fechaPublicacion;

  private Boolean disponible = Boolean.TRUE;

  @DecimalMin(value = "0.0", inclusive = true, message = "El precio no puede ser negativo")
  private BigDecimal precio;

  @Column(name = "created_at", insertable = false, updatable = false)
private java.sql.Timestamp createdAt;

@Column(name = "updated_at", insertable = false, updatable = false)
private java.sql.Timestamp updatedAt;
}
