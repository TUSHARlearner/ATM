
import java.util.HashMap;

import java.util.Scanner;

public class ATM {
  public static void main(String[] args) {
    ATMop obj = new ATMop();
  }
}

class Data {
  float balance;

}

class ATMop {
  
  Scanner sc = new Scanner(System.in);
  HashMap<Integer, Data> map = new HashMap<>();

  ATMop() {
    System.out.println("***********************");
    System.out.println("Welcome to our ATM");
    op();      //using this op for starting function below
  }

  public void op() {
    System.out.println("***********************");
    System.out.println("Enter your pin code");
    int pincode = sc.nextInt();

    if (map.containsKey(pincode) == true) {
      Data obj = map.get(pincode);
      menu(obj);
    } else {
      System.out.println("***********************");
      System.out.println("please create account first ");
      System.out.println("set your pin code");
      int pin = sc.nextInt();
      Data obj = new Data();
      map.put(pin, obj);
      menu(obj);

    }
  }

  public void menu(Data obj) {
    System.out.println("***********************");
    System.out.println("Please Enter Valid Number");
    System.out.println("1. Check Balance");
    System.out.println("2.  Deposit Money");
    System.out.println("3.  Withdraw Money");
    System.out.println("4.  Check Another Account");
    System.out.println("5.  EXIT");

    int x = sc.nextInt();
    if (x == 1) {
      Check_Balance(obj);
    } else if (x == 2) {
      Deposit(obj);
    } else if (x == 3) {
      Withdraw(obj);
    } else if (x == 4) {
      op();
    } else if (x == 5) {
      System.out.println("Thank you !");

    } else {
      System.out.println("Please Enter valid number");
      menu(obj);
    }

  }

  public void Withdraw(Data obj) {
    System.out.println("Enter your amount");
    float a = sc.nextFloat();

    obj.balance = obj.balance - a;
    System.out.println("Amount withdraw successfully");
  }

  public void Deposit(Data obj) {
    System.out.println("Enter your amount");
    float a = sc.nextFloat();

    obj.balance = obj.balance + a;
    System.out.println("Amount deposited successfully");

  }

  public void Check_Balance(Data obj) {
    System.out.println("Your balance " + obj.balance);
  }

}
