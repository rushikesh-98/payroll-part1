/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 *
 * @author rushi
 */

public class Employee {             // public class is creted 
    
    private String EName;
    private int Eid;
    private char WorkType;
    private double Wage;
      
    
    
    public String getName(){        //Accessor method get
        return EName;    }
    
    public void setEName(String EName)      //Mutator Method set
    {
        this.EName = EName;
    }       
    
     public int getEid(){
        return Eid;    }
    
    public void setEID(int Eid){
        this.Eid = Eid;
    }
    
     public char getWorkType(){
        return WorkType;    }
    
    public void setWorkType(char WorkType){
        this.WorkType = WorkType;
    }
    
     public double getWage(){
        return Wage;    }
    
    public void setWage(double Wage){
        this.Wage = Wage;
    }
    
      
    
   
   
}
