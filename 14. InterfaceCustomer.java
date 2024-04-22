/*
Consider there is a promotional offer where customers who have accumulated more than 1000 points in Reliance Mart and are using a Reliance Jio Sim card are
eligible for a special gift hamper.

Complete the code by taking two inputs from user, where the first input is points and the second is a boolean input which stores whether he/she is having a jio
sim or not and pass the inputs to the object of the class.

Define the functions in the Customer class which return the points and isJioUser respectively - Interface

*/

interface Customer {
    int getPoints();
    boolean isJioUser();
}

class Customers implements Customer {
    int points;
    boolean jioUser;
    
    Customers(int points, boolean jioUser) {
        this.points = points;
        this.jioUser = jioUser;
    }
    
    public int getPoints() {
        return points;
    }
    public boolean isJioUser() {
        return jioUser;
    }
}

public class Test extends Customers {
    Test(int points, boolean jioUser) {
        super(points, jioUser);
    }
    
    public static void main(String[] args) {
        Customers c = new Customers(1200,true);
        if(c.getPoints()>=1000 && c.isJioUser()) 
        System.out.print("Eligible");
        else 
        System.out.print("Not Eligible");
    }
}
