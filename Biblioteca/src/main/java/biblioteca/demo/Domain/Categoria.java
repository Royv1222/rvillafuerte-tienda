package biblioteca.demo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity @Table(name = "categoria")
public class Categoria {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "El nombre es obligatorio")
  private String nombre;

  private String descripcion;

  @Column(name = "created_at", insertable = false, updatable = false)
private java.sql.Timestamp createdAt;

@Column(name = "updated_at", insertable = false, updatable = false)
private java.sql.Timestamp updatedAt;
}
