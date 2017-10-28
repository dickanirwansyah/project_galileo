/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.accordion.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author java-spring
 */
@Entity
@Table(name = "mobil", 
        catalog = "springAccordion")
public class Mobil implements Serializable{
    
    @Id @Column(name = "idmobil", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idmobil;
    
    @Column(name = "images", nullable = false)
    @NotBlank(message = "images masih kosong !")
    private String images;
    
    @Column(name = "name", nullable = false, unique = true)
    @NotBlank(message = "name car masih kosong !")
    private String name;
    
    @Column(name = "tahun", nullable = false)
    @NotBlank(message = "tahun mobil masih kosong !")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tahun;
    
    @ManyToOne
    @JoinColumn(name = "idkategori", nullable = false)
    private Kategori kategori;
    
    @Column(name = "active")
    private boolean active;
    
    public Mobil(){
        
    }
    
    public int getIdmobil(){
        return idmobil;
    }
    
    public void setIdmobil(int idmobil){
        this.idmobil = idmobil;
    }
    
    public String getImages(){
        return images;
    }
    
    public void setImages(String images){
        this.images = images;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public Date getTahun(){
        return tahun;
    }
    
    public void setTahun(Date tahun){
        this.tahun = tahun;
    }
    
    public Kategori getKategori(){
        return kategori;
    }
    
    public void setKategori(Kategori kategori){
        this.kategori = kategori;
    }
    
    public boolean getActive(){
        return active;
    }
    
    public void setActive(boolean active){
        this.active = active;
    }
}
