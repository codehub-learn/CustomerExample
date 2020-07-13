package gr.codehub.myapp;


import lombok.*;

import java.util.Date;


@Data
public class Customer {
   private String firstName;
   private String lastName;
   private String email;
   private Date Dob;
   private int code;
   private boolean isActive;
   private double balance;


   public double getReducedBalance(){
      if (balance>20000)
         return 20000;
      else if (balance>10000)
         return balance *.9;
      else
         return balance;
   }
}
