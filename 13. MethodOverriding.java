/*
Gaurav is a member of the automotive testing division. Gaurav is required to change the General statement to a Specific statement that describes the type of vehicle 
and its status after testing every vehicle. To assist Gaurav, create a program that modifies the prior statement and prints both the General statement and the Specific 
statement, accordingly. – Method Overriding
*/

public class vehicle
{
    public void testreport() {
        System.out.println("Vehicle is in good condition");
    }
}

public class car extends vehicle {
    public void testreport(){
        super.testreport();
        System.out.println("Car is in good condition");
   }
}

public class Main {
    public static void main(String[] args) {
        car obj=new car();
        obj.testreport();
    }
}
