/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 * @author rushi
 */
public class Payroll {
     
     static double[] WageaT = new double[150];    // Array to store value of Wage after tax
    
    public static void taxCalculater(Employee em, int i)        //tax calculation class is created
    {
        char type=em.getWorkType();     // get the value
        double wage=em.getWage();       // get the value
        double WageAT = 0;
        
        if(type == 'T')         //Argument
        {
            WageAT = (wage - (wage*0.15));
        }
        if(type == 'C')         //Argument
        {
            WageAT = (wage - (wage*0.18));
        }
        if(type == 'F')         //Argument
        {
            WageAT = (wage -(wage*0.20)-(wage*0.10));
        }
        
        WageaT[i] = WageAT;
        
        System.out.println("Employee's Wage After TAX " +WageAT);
        System.out.println("**********************************");
    }

    
    public static void main(String[] args) {
       
    String EName;
    int Eid;
    char WorkType;
    double Wage;
    
    int input=0,i=0;
    Scanner s1 = new Scanner(System.in);     //Scaner s1 created
    
    Employee[] em = new Employee[150];      //Array of the class Employee
    
        System.out.println("Enter 0 to View employee details.");
        System.out.println("Enter 1 to calculate Employee's Tax.");
        
       
        
        for(int k=0; k<=150; k++)     //Loop
        {
            System.out.println("Which option would you like?");
            input = s1.nextInt();
            
            
            if(input==0)        //Argument
            {
                int CE=0,TE=0,FE=0;
                double netPayment=0, grossPayment=0;
                for(int j=0;j<i;j++)   //Loop       
                {
                  System.out.println(""+em[j].getName()+","+em[j].getEid()+","+em[j].getWorkType()+","+em[j].getWage()+","+WageaT[j]);
                  
                   switch (em[j].getWorkType()) {
                        case 'T':
                            TE++;
                            break;
                        case 'C':
                            CE++;
                            break;
                        case 'F':
                            FE++;
                            break;
                        default:
                            break;
                    }
                   grossPayment += em[j].getWage();
                   netPayment += WageaT[j];
                }
                System.out.println("\nTotel Number of Employee's you have enter " + (i+1));
                System.out.println("\nWork Types: " + TE + " Temporary, " + CE + " Contract, " + FE + " Full-time");
                System.out.println("\nTotal wages before taxes: $" + grossPayment);
                System.out.println("Total wages after taxes: $" + netPayment + "\n");
            }
            if (input==1) //Argument
            {
                s1.nextLine();
                System.out.println("What is the Employee Name?");
                EName = s1.nextLine();
                if((EName.indexOf(' ') == -1 ) || (EName.length() < 5))     //Argument
                {
                    throw new RuntimeException("employee name must have at least one space and cannot be less than 5 characters");      //Excaption handling
                }
                
                System.out.println("What is the employee ID?");
                Eid = s1.nextInt();
                if (Eid <= 0)           //Argument
                {
                    throw new ArithmeticException("employee ID must be a positive integer");        //Excaption handling
                }
                
                System.out.println("What is the employee's work type?");
                WorkType =s1.next().charAt(0);
                
                System.out.println("What is the employee's wage?");
                Wage = s1.nextDouble();
                if(Wage<0)          //Argument
                {
                    throw new ArithmeticException("Pay must be positive");      //Excaption handling
                }
                switch (WorkType)   //Switch Statement
                {
                    case 'T':
                        if(Wage > 90 || Wage < 0)       //Argument
                        {
                            throw new ArithmeticException("the hourly pay cannot exceed 90.00 but can be 0");       //Excaption handling
                        }
                         break;
                    case 'C':
                        if(Wage > 3500 || Wage < 1000)  //Argument
                        {
                            throw new ArithmeticException("the bi-weekly pay cannot be below 1000.00 or more than 3500.00");        //Excaption handling
                        }
                         break;
                    case 'F':
                        if(Wage < 3000) //Argument
                        {
                            throw new ArithmeticException("Monthly pay must be more than $3000");       //Excaption handling
                        }   break;
                    default:
                        break;
                }
                
                em[i] = new Employee();
                em[i].setEName(EName);
                em[i].setEID(Eid);
                em[i].setWorkType(WorkType);
                em[i].setWage(Wage);
                
                taxCalculater(em[i],i);
                i++;
        }
       

    }
}    
}
