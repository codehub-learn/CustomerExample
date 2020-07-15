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

   public Customer setFirstName(String firstName){
      this.firstName = firstName;
      return this;
   }
   public Customer setLastName(String lastName){
      this.lastName = lastName;
      return this;
   }
   public Customer setBalance(double balance){
      this.balance = balance;
      return this;
   }

   public Customer setDob(Date Dob){
      this.Dob = Dob;
      return this;
   }



   public double getReducedBalance(){
      if (balance>20000)
         return 20000;
      else if (balance>10000)
         return balance *.9;
      else
         return balance;
   }
}
