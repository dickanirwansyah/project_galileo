/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.accordion.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author java-spring
 */
@Entity
@Table(name = "kategori", 
        catalog = "springAccordion")
public class Kategori implements Serializable{
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idkategori", nullable = false, unique = true)
    private int idkategori;
    
    @Column(name = "name", nullable = false)
    @NotBlank(message = "Nama masih kosong harap diisi")
    private String name;
    
    @Column(name = "deskripsi", nullable = false)
    @NotBlank(message = "Deskripsi masih kosong harap diisi")
    private String deskripsi;
    
    @Column(name = "active")
    private boolean active;
    
    @JsonIgnore
    @OneToMany(mappedBy = "kategori")
    @Column(nullable = true)
    private Set<Mobil> mobils = new HashSet<Mobil>();
    
    public Kategori(){
        
    }
    
    public Set<Mobil> getMobils(){
        return mobils;
    }
    
    public void setMobils(Set<Mobil> mobils){
        this.mobils=mobils;
    }
    
    public int getIdkategori(){
        return idkategori;
    }
    
    public void setIdkategori(int idkategori){
        this.idkategori = idkategori;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getDeskripsi(){
        return deskripsi;
    }
    
    public void setDeskripsi(String deskripsi){
        this.deskripsi = deskripsi;
    }
    
    public boolean getActive(){
        return active;
    }
    
    public void setActive(boolean active){
        this.active = active;
    }
}
