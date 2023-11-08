package ufc.br.softflow.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table (name = "gerente_de_projetos")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class GerenteDeProjetos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

}
