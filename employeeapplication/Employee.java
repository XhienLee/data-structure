/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure.employeeapplication;

/**
 *
 * @author Segn Lee
 */
public class Employee {
   
   private String name;
   private String position;
   private byte age;
   private int id;
   
   //constructors
   Employee(){
      name = position = "";
      age = 0;
      id = 0;
   }
   
   Employee(String n, String p, byte a, int i){
      position = p;
      age      = a;
      id       = i;
      name     = n;
   }
   
   Employee(Employee E){
      name = E.name;
      position = E.position;
      age = E.age;
      id = E.id;
   }

    
   // setters or mutators
   public void setName(String n){
      name = n;
   }
   public void setPosition(String p){
      position = p;
   }
   public void setAge(byte a){
      age = a;
   }
   public void setID(int i){
      id = i;
   }

   public String getName(){
      return name;
   }
   public String getPosition(){
      return position;
   }
   public byte getAge(){
      return age;
   }
   public int getID(){
      return id;
   }
   
   //equals method
   public boolean equals(Employee E){
      
      return ((name.equals(E.name) && position.equals(E.position) && id==E.id)? true:false);
   }
   
   public String toString(){
      return "Name: "+name+"\nPosition: "+position
             +"\nAge: "+age+"\nID: "+id;
   }
   
}