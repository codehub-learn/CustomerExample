package gr.codehub.myapp;


import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void main(String[] args)
             {
      Ui ui = new Ui();

                 try {
                     ui.doTest();
                 } catch (Exception e) {
                     System.out.println(e);
                 }

             }
}
