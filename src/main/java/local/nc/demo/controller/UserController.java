/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.nc.demo.controller;

import java.security.Principal;
import java.util.List;
import local.nc.demo.model.Aluno;
import local.nc.demo.model.DataTable;
import local.nc.demo.model.UserDtls;
import local.nc.demo.repository.UserRepository;
import local.nc.demo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author jose
 */
@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private AlunoService alunoService;
    
    @ModelAttribute
    private void userDetails(Model m, Principal p){
        String email = p.getName();
        UserDtls user = userRepo.findByEmail(email);
        //Page<Aluno> pageAlunos = alunoService.pageAluno(1);
        //List<Aluno> alunos = pageAlunos.getContent();
        //List<Aluno> alunos = alunoService.listaAlunos();
        //int totalPages = pageAlunos.getTotalPages();
        //long totalItems = pageAlunos.getTotalElements();
        
        //m.addAttribute("currentPage", 1);
        //m.addAttribute("totalPages", totalPages);
        //m.addAttribute("totalItems", totalItems);
        m.addAttribute("user", user);
        //m.addAttribute("alunos", alunos);
    }
    
//    @GetMapping("/{pageNumber}")
//    private String getOnePage(Model model, @PathVariable("pageNumber") int currentPage){
//        Page<Aluno> page = alunoService.pageAluno(currentPage);
//        int totalPages = page.getTotalPages();
//        long totalItems = page.getTotalElements();
//        List<Aluno> alunos = page.getContent();
//        
//        model.addAttribute("currentPage", currentPage);
//        model.addAttribute("totalPages", totalPages);
//        model.addAttribute("totalItems", totalItems);
//        model.addAttribute("alunos", alunos);
//        
//        return "user/home";
//    }
    
    @GetMapping("/datatableAlunos")
    public @ResponseBody DataTable getAlunosDataTable (
            @RequestParam int draw, @RequestParam int start, @RequestParam int length){
        DataTable dataTable = new DataTable();
        int pageNumber = ((start + length)/length) - 1;
        List<Aluno> alunosSize = alunoService.listaAlunos();
        Page<Aluno> page = alunoService.pageAluno(pageNumber,length);
        //int totalPages = page.getTotalPages();
        //System.out.println(totalPages);
        List<Aluno> alunos = page.getContent();
        System.out.println("Draw: " + draw);
        System.out.println("Start: " + start);
        System.out.println("Length: " + length);
        
        dataTable.setDraw(draw);
        dataTable.setRecordsTotal(alunosSize.size());
        dataTable.setRecordsFiltered(alunosSize.size());
        
        
        dataTable.setData(alunos);
        
        return dataTable;
    }
    
    @GetMapping("/")
    public String home(){
        return "user/home";
    }
}
