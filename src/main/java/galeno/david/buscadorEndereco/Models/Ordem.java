package galeno.david.buscadorEndereco.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ordem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  private BigDecimal preco;
  private String tipo;
  private LocalDateTime data;
  private String status;

  @Column(name = "usuario_id")
  private Long usuarioId;
}
