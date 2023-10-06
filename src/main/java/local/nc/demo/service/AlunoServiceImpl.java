/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.nc.demo.service;

import java.util.List;
import local.nc.demo.model.Aluno;
import local.nc.demo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author jose
 */
@Service
public class AlunoServiceImpl implements AlunoService {
    
    @Autowired
    private AlunoRepository alunoRepo;
    
    @Override
    public List<Aluno> listaAlunos() {
        return alunoRepo.findAll();
    }

    @Override
    public Page<Aluno> pageAluno(int pageNumber, int sizePage) {
        Pageable pegeable = PageRequest.of(pageNumber, sizePage);
        return alunoRepo.getByPage(pegeable);
    }
    
    
    
}
