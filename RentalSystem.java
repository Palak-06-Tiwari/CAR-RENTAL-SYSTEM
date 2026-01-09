import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Car{
    private String carId;

    private String brand;
 
    private String model;

    private double rentPerDay;

    private boolean isAvailable;

    public Car(String carId,String brand,String model,double rentPerDay){
     this.carId=carId;
     this.brand=brand;
     this.model=model;
     this.rentPerDay=rentPerDay; 
     this.isAvailable=true; 
    }

    public String getcarId(){
        return carId;
    }

    public String getBrand(){
        return brand;
    }

    public String getModel(){
        return model;
    }

    public double getrentPerDay(){
        return rentPerDay;
    }
    
    public double calculatePrice(int rentalDays){
        return rentPerDay * rentalDays;
    }
    
    public boolean isAvailable(){
        return isAvailable;
    }

    public void rent(){
        isAvailable=false;
    }

    public void returnCar(){
        isAvailable=true;
    }
    
}

class Customer {
private String customerId;

private String name;

public Customer(String customerId,String name){
    this.customerId=customerId;
    this.name=name;
}

public String getCustomerId(){
    return name;
}

public String getName(){
    return name;
}
    
}



class Rental{
 private Car car; // car->reference to Car class object

 private Customer customer; //cutomer ->refernce to Customer class object

 private int days;

// “The Rental class uses composition by holding references
//  to Car and Customer objects, which are initialized
//   using a constructor during object creation.”

public Rental(Car car,Customer customer,int days){

    this.car=car;
    this.customer=customer;
    this.days=days;
}

public Car getCar(){
    return car;
}

public Customer getCustomer(){
  return customer;
}

public int getDay(){
    return days;
}

}


class carRentalSystem{

private List<Car> cars;

private List<Customer>customers;

private List<Rental>rentals;



public carRentalSystem(){
    cars=new ArrayList<>();
    customers=new ArrayList<>();
    rentals=new ArrayList<>();
}

public void addCar(Car car){
    cars.add(car);
}


public void addCustomer(Customer customer){
    customers.add(customer);
}


public void rentCar(Car car,Customer customer,int days){
    if(car.isAvailable()){
        car.rent();
        rentals.add(new Rental(car, customer, days));
    }
    else{
     System.out.println("car is not available for rent");   
    }
}


public void returnCar(Car car){
    car.returnCar();
    Rental rentaltoremove=null;
    for(Rental r:rentals){
       if(r.getCar()==car){
        rentaltoremove=r;
        break;
       } 
    }

    if(rentaltoremove!=null){
        rentals.remove(rentaltoremove);
    }
    else{
        System.out.println("car was not rented");
    }
}

public void menu(){
    Scanner sc=new Scanner(System.in);

    while(true){
       System.out.println("====CAR RENTAL SYSTEM====");
       System.out.println("1. Rent a car"); 
       System.out.println("2. Return a car"); 
       System.out.println("3. Exit"); 
       System.out.println("Enter Your Choice");

       int choice=sc.nextInt();
       sc.nextLine();

       if(choice==1){
        System.out.println("\n=== Rent a Car===");
        System.out.println("Enter Your Name");
        String customerName=sc.nextLine();

        System.out.println("\n Available Cars");
        for(Car car:cars){
            if(car.isAvailable()){
                System.out.println(car.getcarId()+"--"+car.getModel()+"--"+car.getBrand()+"--"+car.getrentPerDay()+"$");
            }
        }
         
        System.out.println("\n Enter the CarId you want to rent");
        String carId=sc.nextLine();
        
        System.out.println("Enter the number of days for rental");
        int rentalDays=sc.nextInt();
        sc.nextLine();
        
        Customer newCustomer=new Customer("CUS"+(customers.size()+1),customerName);
        addCustomer(newCustomer);


        Car selectedCar=null;
        for(Car c:cars){
            if(c.getcarId().equals(carId) && c.isAvailable()){
              selectedCar=c;
              break;
            }
        }


        if(selectedCar!=null){
            double totalprice=selectedCar.calculatePrice(rentalDays);
            System.out.println("\n==Renatl Information==\n");
            System.out.println("Customer Id:"+newCustomer.getCustomerId());
            System.out.println("Customer Name:"+newCustomer.getName());
            System.out.println("Car:"+selectedCar.getBrand()+" "+selectedCar.getModel());
            System.out.println("Rental Days:"+rentalDays);
            System.out.printf("Total Price: $%.2f%n", totalprice);

            System.out.println("\n Confirm Rental (Y/N):");
            String confirm=sc.nextLine();

            if(confirm.equalsIgnoreCase("Y")){
                rentCar(selectedCar, newCustomer, rentalDays);
                System.out.println("\n Car Rented Successfully \n");
            }else{
                System.out.println("\n Rental cancelled");
            }
        }
        else{
            System.out.println("\n Invalid car selection or car not available for rent");
        }

       }else if(choice==2){
         System.out.println("\n Return a Car");
         System.out.println("Enter the car id you want to return: ");
         String carId=sc.nextLine();

        Car carToReturn =null;
        for(Car c:cars){
            if(c.getcarId().equals(carId) && !c.isAvailable()){
             carToReturn=c;
             break;
            }
        }
        if(carToReturn!=null){
            Customer customer=null;
            for(Rental r:rentals){
                if(r.getCar()==carToReturn){
                    customer=r.getCustomer();
                    break;
                }
            }
            if(customer!=null){
                returnCar(carToReturn);
                System.out.println("Car returned successfully by "+ customer.getName());
            }
            else{
                System.out.println("Invalid car Id or car information is missing");
            }
         }else{
            System.out.println("Invalid car id or car is not rented");
         }
       }else if(choice==3){
        break;
       }
       else{
        System.out.println("\n Invalid choice.Please enter a valid choice");
       }
    }
    

    System.out.println("\n THANK YOU FOR USING CAR RENTAL SYSTEM");
}

}



    public class RentalSystem {
    public static void main(String[] args) {
       carRentalSystem rentalSystem=new carRentalSystem();

       Car car1=new Car("c001", "Toyota", "camry",60.0);
       Car car2=new Car("c002", "Honda", "Shine",50.0);
       Car car3=new Car("c003", "Mahindra", "Thar",150.0);
       Car car4 = new Car("c004", "Hyundai", "Creta", 80.0);
       Car car5 = new Car("c005", "Tata", "Nexon", 75.0);
       Car car6 = new Car("c006", "Maruti", "Swift", 55.0);
       Car car7 = new Car("c007", "Kia", "Seltos", 85.0);
       Car car8 = new Car("c008", "Skoda", "Slavia", 90.0);
       Car car9 = new Car("c009", "Volkswagen", "Virtus", 95.0);  
       Car car10 = new Car("c010", "MG", "Hector", 100.0);


       rentalSystem.addCar(car1);
       rentalSystem.addCar(car2);
       rentalSystem.addCar(car3);
       rentalSystem.addCar(car4);
       rentalSystem.addCar(car5);
       rentalSystem.addCar(car6);
       rentalSystem.addCar(car7);
       rentalSystem.addCar(car8);
       rentalSystem.addCar(car9);
       rentalSystem.addCar(car10);


       rentalSystem.menu();
    }
}