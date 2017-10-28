/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.accordion.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 *
 * @author java-spring
 */
@Entity
@Table(name = "menu_accordion", 
        catalog = "springAccordion")
public class MenuAccordion implements Serializable{
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idmenu")
    private int idmenu;
    
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "parentid")
    @NotFound(action = NotFoundAction.IGNORE)
    private MenuAccordion accordion;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "link", nullable = false)
    private String link;
    
    @OneToMany(mappedBy = "accordion", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<MenuAccordion> subMenus;
    
    public int getIdmenu(){
        return idmenu;
    }
    
    public void setIdmenu(int idmenu){
        this.idmenu = idmenu;
    }
    
    public MenuAccordion getAccordion(){
        return accordion;
    }
    
    public void setMenuAccordion(MenuAccordion accordion){
        this.accordion = accordion;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getLink(){
        return link;
    }
    
    public void setLink(String link){
        this.link = link;
    }
    
    public Set<MenuAccordion> getSubMenus(){
        return subMenus;
    }
    
    public void setSubMenus(Set<MenuAccordion> subMenus){
        this.subMenus = subMenus;
    }
}
