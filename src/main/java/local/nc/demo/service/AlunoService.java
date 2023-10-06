/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package local.nc.demo.service;

import java.util.List;
import local.nc.demo.model.Aluno;
import org.springframework.data.domain.Page;

/**
 *
 * @author jose
 */
public interface AlunoService {
    
    public List<Aluno> listaAlunos();
    
    public Page<Aluno> pageAluno(int pageNumber, int sizePage);
}
