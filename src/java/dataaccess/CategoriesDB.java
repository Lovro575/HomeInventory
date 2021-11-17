/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import models.Categories;

/**
 *
 * @author Lovro H
 */
public class CategoriesDB {
    
    public List<Categories> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<Categories> categories = em.createNamedQuery("Categories.findAll", Categories.class).getResultList();
            return categories;
        } finally {
            em.close();
        }
    }
    
    public Categories get(int index) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Categories categories = em.find(Categories.class, index);
            return categories;
        } finally {
            em.close();
        }
    }
    
}
