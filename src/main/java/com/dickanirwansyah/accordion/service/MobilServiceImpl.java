/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.accordion.service;

import com.dickanirwansyah.accordion.dao.MobilDAO;
import com.dickanirwansyah.accordion.entity.Mobil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author java-spring
 */
@Service
@Transactional
public class MobilServiceImpl implements MobilService{

    @Autowired
    private MobilDAO mobilDAO;
    
    @Override
    public List<Mobil> findAllMobil() {
      return mobilDAO.findAllMobil();
    }

    @Override
    public List<Mobil> findMobilByActive() {
      return mobilDAO.findByActiveMobil();
    }

    @Override
    public Mobil findMobilById(int idmobil) {
       return mobilDAO.findOneMobilById(idmobil);
    }
    
}
