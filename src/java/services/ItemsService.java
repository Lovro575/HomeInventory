/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.CategoriesDB;
import dataaccess.ItemsDB;
import dataaccess.UsersDB;
import java.util.List;
import models.Categories;
import models.Items;
import models.Users;

/**
 *
 * @author User
 */
public class ItemsService {
    
    public Items get(int itemID) throws Exception {
        ItemsDB itemsDB = new ItemsDB();
        Items items = itemsDB.get(itemID);
        return items;
    }
    
    public List<Items> getAll() throws Exception {
        ItemsDB itemsDB = new ItemsDB();
        List<Items> items = itemsDB.getAll();
        return items;
    }
        
    public void insert(int itemID, int category, String itemName, double price, String owner) throws Exception {
        Items items = new Items(itemID, itemName, price);
        
        //get the category
        CategoriesDB categoriesDB = new CategoriesDB();
        Categories categories = categoriesDB.get(category);
        
        //get the owner
        UsersDB usersDB = new UsersDB();
        Users users = usersDB.get(owner);
        
        //set category and owner and insert into database
        items.setCategory(categories);
        items.setOwner(users);
        ItemsDB itemsDB = new ItemsDB();
        itemsDB.insert(items);
    }
    
    public void update(int itemID, int category, String itemName, double price, String owner) throws Exception {
       Items items = new Items(itemID, itemName, price);
        
       //get the category
       CategoriesDB categoriesDB = new CategoriesDB();
       Categories categories = categoriesDB.get(category);
       
       //get the owner
       UsersDB usersDB = new UsersDB();
       Users users = usersDB.get(owner);
       
       //set category and owner and insert into database
       items.setCategory(categories);
       items.setOwner(users);
       ItemsDB itemsDB = new ItemsDB();
       itemsDB.update(items);
    }
    
    public void delete(int itemID) throws Exception {
        Items items = new Items();
        items.setItemID(itemID);
        ItemsDB itemsDB = new ItemsDB();
        itemsDB.delete(items);
    }
}
