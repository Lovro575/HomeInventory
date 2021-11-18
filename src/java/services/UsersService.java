/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.UsersDB;
import java.util.List;
import models.Users;

/**
 *
 * @author Lovro H
 */
public class UsersService {
    
    public Users get(String username) throws Exception {
        UsersDB usersDB = new UsersDB();
        Users users = usersDB.get(username);
        return users;
    }
    
    public List<Users> getAll() throws Exception {
        UsersDB userDB = new UsersDB();
        List<Users> users = userDB.getAll();
        return users;
    }
    
    public void insert(String username, String password, String email, String firstname, String lastname, boolean active, boolean admin) throws Exception {
        Users users = new Users(username, password, email, firstname, lastname, active, admin);
        UsersDB usersDB = new UsersDB();
        usersDB.insert(users);
    }
    
    public void update(String username, String password, String email, String firstname, String lastname, boolean active, boolean admin) throws Exception {
        Users users = new Users(username, password, email, firstname, lastname, active, admin);
        UsersDB usersDB = new UsersDB();
        usersDB.update(users);
    }
    
    public void delete(String username) throws Exception {
        Users users = new Users();
        users.setUsername(username);
        UsersDB usersDB = new UsersDB();
        usersDB.delete(users);
    }
}
