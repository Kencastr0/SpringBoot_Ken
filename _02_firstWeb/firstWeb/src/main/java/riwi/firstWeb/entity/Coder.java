package riwi.firstWeb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Entity indica que esta clase sera una entidad y podra ser mapeada
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
// Table nos permite dar configuracion a la tabla
@Table(name = "coder")
public class Coder {
    // @Id Indica que el atributo siguiente sera una llave primaria
    @Id
    // @GeneratedValue permite que el id sera autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String clan;

}
