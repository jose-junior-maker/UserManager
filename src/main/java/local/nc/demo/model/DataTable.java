/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.nc.demo.model;

import java.util.List;
import lombok.Data;

/**
 *
 * @author jose
 */
@Data
public class DataTable {
    
    private Integer draw;
    private Integer recordsTotal;
    private Integer recordsFiltered;
    private List<Aluno> data;
    
    
}
