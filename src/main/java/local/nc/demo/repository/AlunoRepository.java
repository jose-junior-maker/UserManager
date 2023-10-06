/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package local.nc.demo.repository;

import java.util.List;
import local.nc.demo.model.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author jose
 */
public interface AlunoRepository extends JpaRepository<Aluno, String> {
    
    @Query(nativeQuery = true, value = "SELECT * FROM teste_table_alunos a where curso = 'Engenharia Elétrica'")
    public List<Aluno> findAll();
    
    @Query(nativeQuery = true, value = "SELECT * FROM teste_table_alunos a where curso = 'Engenharia Elétrica' order by nome asc")
    Page<Aluno> getByPage(Pageable pageable);
}
