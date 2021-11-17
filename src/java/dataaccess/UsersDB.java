/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Items;
import models.Users;

/**
 *
 * @author Lovro H
 */
public class UsersDB {
/**
 * probably have to change the parameters of "item" because this class is for user
 */
    
    public List<Users> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<Users> users = em.createNamedQuery("Users.findAll", Users.class).getResultList();
            return users;
        } finally {
            em.close();
        }
    }
    
    public Users get(String username) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Users user = em.find(Users.class, username);
            return user;
        } finally {
            em.close();
        }
    }
    
    public void insert(Items item) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            Users user = item.getOwner();
            user.getItemsList().add(item);
            trans.begin();
            em.persist(item);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public void update(Items item) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(item);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public void delete(Items item) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            Users user = item.getOwner();
            user.getItemsList().remove(item);
            trans.begin();
            em.remove(em.merge(item));
            em.merge(user);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
}