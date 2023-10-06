/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.nc.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author jose
 */
@Data
@Entity
@Table(name = "teste_table_alunos")
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String grr;
    
    private String nome;
    private String data_nascimento;
    private String curso;
    private Integer carga_horaria_curso;
    private Integer periodo_curso;
    private Integer periodo_atual;
    private Integer reprovacoes;
    private Integer carga_horaria_integralizada;
}
