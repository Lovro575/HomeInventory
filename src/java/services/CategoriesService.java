/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.CategoriesDB;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Categories;

/**
 *
 * @author User
 */
public class CategoriesService {
    
    public List<Categories> getAll() {
        CategoriesDB categoriesDB = new CategoriesDB();
        List<Categories> categories;
        
        try {
            categories = categoriesDB.getAll();
            return categories;
        } catch (Exception ex) {
            Logger.getLogger(CategoriesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Categories get(int index) {
        CategoriesDB categoriesDB = new CategoriesDB();
        
        try {
            Categories categories = categoriesDB.get(index);
        } catch (Exception ex) {
            Logger.getLogger(CategoriesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
