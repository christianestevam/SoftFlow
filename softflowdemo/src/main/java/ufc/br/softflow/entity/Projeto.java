/*
Projeto: Esta entidade representa um projeto de software individual no SoftFlow. Cada projeto pode ter atributos como ID do projeto, nome do projeto, descrição do projeto, data de início, data de término, status do projeto (em andamento, concluído, etc.), e talvez um campo para notas adicionais.
 */

package ufc.br.softflow.entity;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "projeto")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data

public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
