package com.pizza.view;

public class Menu {
  public void displayMenu() {

      System.out.println("=======================================================================");
      System.out.println("               Write XY to choose the option, where: ");
      System.out.println("=======================================================================");
      System.out.println("X - entity number:               |          Y - CRUD number:");
      System.out.println("  1 - courier                    |            1 - GET ALL");
      System.out.println("  2 - courierStatus              |            2 - GET ONE");
      System.out.println("  3 - customer                   |            3 - CREATE");
      System.out.println("  4 - deliveryArea               |            4 - UPDATE");
      System.out.println("  5 - orderInfo                  |            5 - DELETE");
      System.out.println("  6 - orderStatus");
      System.out.println("E.G. courier   (X=1) - get all (Y=1): 11");
      System.out.println("     customer  (X=3) - update  (Y=4): 34");
      System.out.println("     orderInfo (X=4) - get one (Y=2): 42");
      System.out.println("=======================================================================");

  }
}
