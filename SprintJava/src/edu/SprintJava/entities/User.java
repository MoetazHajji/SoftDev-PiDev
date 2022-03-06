/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.entities;

/**
 *
 * @author moete
 */
public class User {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    private String username ;
    public User(String username, String pass, String role) {
        this.username = username;
        this.pass = pass;
        this.role = role;
    }

    private String pass ;
    private String role ;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User() {
    }

    public User(int id,String username, String pass, String role) {
        this.id=id;
        this.username = username;
        this.pass = pass;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "Username=" + username + ", pass=" + pass + ", role=" + role + '}';
    }
  
    
    
    
}
