
//Abstract classes and abstract methods and Interfaces
package myvehicle;

import java.util.Scanner;

import vehicle.*;

public class abc {

public static void main(String[] args) {
Scanner s1 = new Scanner(System.in);
vehicle v[]=new vehicle[2];
vehicle vehi;//object of abstract class cannot be created
fly f1=new hificar();// reference of fly to hificar
possys f2=new hificar();//reference of possys to hificar
v[0]=new car();//vehicle class object reference to car
v[1]=new hificar();//vehicle class object reference to hificar
car c=new car();//object of car
hificar h=new hificar();//object of hificar
car ch=new hificar();//object of car to hifi class
int choice=0;
int inc_speed=60;
int dec_speed=10;
int gears=2;
String place="Queens Palace";

do {
System.out.println("ENTER YOUR CHOICE ! ");
System.out.println("ENTER 1 FOR VEHICLE OBJECT");
System.out.println("ENTER 2 FOR REFERENCE OF VEHICLE OBJECT OF CAR CLASS");
System.out.println("ENTER 3 FOR REFERENCE OF VEHICLE OBJECT OF HIFICAR CLASS");
System.out.println("ENTER 4 FOR CAR OBJECT");
System.out.println("ENTER 5 FOR REFERENCE OF CAR OBJECT OF HIFICAR CLASS");
System.out.println("ENTER 6 FOR REFERENCE OF FLY AN OBJECT OF HIFICAR CLASS\"");
System.out.println("ENTER 7 FOR REFERENCE OF POSSYS INTERFACE AN OBJECT OF HIFICAR CLASS");
System.out.println("ENTER 8 FOR HIFICAR OBJECT");
choice=s1.nextInt();
switch(choice)
{
case 1:
 System.out.println("Since vehicle is an abstract class it cannot be instatiated");
break;
case 2:
 System.out.println("For Reference Of Vehicle Object Of Car Class-");
 v[0].start();
 v[0].stop();
 v[0].regVehicle();
 System.out.println(" ");
 break;
case 3:
 System.out.println("For Reference Of Vehicle Object Of Hificar Class-");
 v[1].start();
 v[1].stop();
 v[1].regVehicle();
System.out.println(" ");
 break;
 case 4:
 System.out.println("The methods for object of car-");
 c.start();
 c.stop();
 c.regVehicle();
 c.goreverse();
 c.start(gears);
 System.out.println(" ");
 break;
 case 5:
System.out.println("For Reference Of Car Object Of Hificar Class-");
ch.start();
ch.stop();
ch.start(gears);
ch.goreverse();
System.out.println(" ");
break;

case 6:
System.out.println("For Reference Of Fly An Object Of Hificar Class-");
f1.fly();
f1.flyfast(inc_speed);
f1.flyslow(dec_speed);
System.out.println(" ");
break;
case 7:
System.out.println("For Reference Of Possys Interface An Object Of Hificar Class-");
f2.searchlocation(place);
f2.showroadahead();
System.out.println(" ");
break;
case 8:
System.out.println("the methods for object of hificar-");
h.start();
h.stop();
h.regVehicle();
h.start(gears);
h.ferrari();
h.fly();
h.flyfast(inc_speed);
h.flyslow(dec_speed);
h.searchlocation(place);
h.showroadahead();
System.out.println("  ");
break;
 }
 }while(choice!=0);
 }

}
/*
ENTER YOUR CHOICE ! 
ENTER 1 FOR VEHICLE OBJECT
ENTER 2 FOR REFERENCE OF VEHICLE OBJECT OF CAR CLASS
ENTER 3 FOR REFERENCE OF VEHICLE OBJECT OF HIFICAR CLASS
ENTER 4 FOR CAR OBJECT
ENTER 5 FOR REFERENCE OF CAR OBJECT OF HIFICAR CLASS
ENTER 6 FOR REFERENCE OF FLY AN OBJECT OF HIFICAR CLASS"
ENTER 7 FOR REFERENCE OF POSSYS INTERFACE AN OBJECT OF HIFICAR CLASS
ENTER 8 FOR HIFICAR OBJECT
1
Since vehicle is an abstract class it cannot be instatiated
ENTER YOUR CHOICE ! 
ENTER 1 FOR VEHICLE OBJECT
ENTER 2 FOR REFERENCE OF VEHICLE OBJECT OF CAR CLASS
ENTER 3 FOR REFERENCE OF VEHICLE OBJECT OF HIFICAR CLASS
ENTER 4 FOR CAR OBJECT
ENTER 5 FOR REFERENCE OF CAR OBJECT OF HIFICAR CLASS
ENTER 6 FOR REFERENCE OF FLY AN OBJECT OF HIFICAR CLASS"
ENTER 7 FOR REFERENCE OF POSSYS INTERFACE AN OBJECT OF HIFICAR CLASS
ENTER 8 FOR HIFICAR OBJECT
2
For Reference Of Vehicle Object Of Car Class-
the car just started
the car has stopped
the vehicle has a valid registration
 
ENTER YOUR CHOICE ! 
ENTER 1 FOR VEHICLE OBJECT
ENTER 2 FOR REFERENCE OF VEHICLE OBJECT OF CAR CLASS
ENTER 3 FOR REFERENCE OF VEHICLE OBJECT OF HIFICAR CLASS
ENTER 4 FOR CAR OBJECT
ENTER 5 FOR REFERENCE OF CAR OBJECT OF HIFICAR CLASS
ENTER 6 FOR REFERENCE OF FLY AN OBJECT OF HIFICAR CLASS"
ENTER 7 FOR REFERENCE OF POSSYS INTERFACE AN OBJECT OF HIFICAR CLASS
ENTER 8 FOR HIFICAR OBJECT
3
For Reference Of Vehicle Object Of Hificar Class-
the hifcar has started
the hificar has stopped
the vehicle has a valid registration
 
ENTER YOUR CHOICE ! 
ENTER 1 FOR VEHICLE OBJECT
ENTER 2 FOR REFERENCE OF VEHICLE OBJECT OF CAR CLASS
ENTER 3 FOR REFERENCE OF VEHICLE OBJECT OF HIFICAR CLASS
ENTER 4 FOR CAR OBJECT
ENTER 5 FOR REFERENCE OF CAR OBJECT OF HIFICAR CLASS
ENTER 6 FOR REFERENCE OF FLY AN OBJECT OF HIFICAR CLASS"
ENTER 7 FOR REFERENCE OF POSSYS INTERFACE AN OBJECT OF HIFICAR CLASS
ENTER 8 FOR HIFICAR OBJECT
4
The methods for object of car-
the car just started
the car has stopped
the vehicle has a valid registration
car is taking reverse
the car has started with gear no 2
 
ENTER YOUR CHOICE ! 
ENTER 1 FOR VEHICLE OBJECT
ENTER 2 FOR REFERENCE OF VEHICLE OBJECT OF CAR CLASS
ENTER 3 FOR REFERENCE OF VEHICLE OBJECT OF HIFICAR CLASS
ENTER 4 FOR CAR OBJECT
ENTER 5 FOR REFERENCE OF CAR OBJECT OF HIFICAR CLASS
ENTER 6 FOR REFERENCE OF FLY AN OBJECT OF HIFICAR CLASS"
ENTER 7 FOR REFERENCE OF POSSYS INTERFACE AN OBJECT OF HIFICAR CLASS
ENTER 8 FOR HIFICAR OBJECT
5
For Reference Of Car Object Of Hificar Class-
the hifcar has started
the hificar has stopped
the hificar changed its gear to. 2
car is taking reverse
 
ENTER YOUR CHOICE ! 
ENTER 1 FOR VEHICLE OBJECT
ENTER 2 FOR REFERENCE OF VEHICLE OBJECT OF CAR CLASS
ENTER 3 FOR REFERENCE OF VEHICLE OBJECT OF HIFICAR CLASS
ENTER 4 FOR CAR OBJECT
ENTER 5 FOR REFERENCE OF CAR OBJECT OF HIFICAR CLASS
ENTER 6 FOR REFERENCE OF FLY AN OBJECT OF HIFICAR CLASS"
ENTER 7 FOR REFERENCE OF POSSYS INTERFACE AN OBJECT OF HIFICAR CLASS
ENTER 8 FOR HIFICAR OBJECT
6
For Reference Of Fly An Object Of Hificar Class-
the hificar cannot fly 
the hificar increased the speed to 60
the hificar decreased it speed to  10
 
ENTER YOUR CHOICE ! 
ENTER 1 FOR VEHICLE OBJECT
ENTER 2 FOR REFERENCE OF VEHICLE OBJECT OF CAR CLASS
ENTER 3 FOR REFERENCE OF VEHICLE OBJECT OF HIFICAR CLASS
ENTER 4 FOR CAR OBJECT
ENTER 5 FOR REFERENCE OF CAR OBJECT OF HIFICAR CLASS
ENTER 6 FOR REFERENCE OF FLY AN OBJECT OF HIFICAR CLASS"
ENTER 7 FOR REFERENCE OF POSSYS INTERFACE AN OBJECT OF HIFICAR CLASS
ENTER 8 FOR HIFICAR OBJECT
7
For Reference Of Possys Interface An Object Of Hificar Class-
the hificar is trying to search the given location : Queens Palace
the hificar has to travel 100 m ahead
 
ENTER YOUR CHOICE ! 
ENTER 1 FOR VEHICLE OBJECT
ENTER 2 FOR REFERENCE OF VEHICLE OBJECT OF CAR CLASS
ENTER 3 FOR REFERENCE OF VEHICLE OBJECT OF HIFICAR CLASS
ENTER 4 FOR CAR OBJECT
ENTER 5 FOR REFERENCE OF CAR OBJECT OF HIFICAR CLASS
ENTER 6 FOR REFERENCE OF FLY AN OBJECT OF HIFICAR CLASS"
ENTER 7 FOR REFERENCE OF POSSYS INTERFACE AN OBJECT OF HIFICAR CLASS
ENTER 8 FOR HIFICAR OBJECT
8
the methods for object of hificar-
the hifcar has started
the hificar has stopped
the vehicle has a valid registration
the hificar changed its gear to. 2
the hifi car is a ferrari
the hificar cannot fly 
the hificar increased the speed to 60
the hificar decreased it speed to  10
the hificar is trying to search the given location : Queens Palace
the hificar has to travel 100 m ahead
  
ENTER YOUR CHOICE ! 
ENTER 1 FOR VEHICLE OBJECT
ENTER 2 FOR REFERENCE OF VEHICLE OBJECT OF CAR CLASS
ENTER 3 FOR REFERENCE OF VEHICLE OBJECT OF HIFICAR CLASS
ENTER 4 FOR CAR OBJECT
ENTER 5 FOR REFERENCE OF CAR OBJECT OF HIFICAR CLASS
ENTER 6 FOR REFERENCE OF FLY AN OBJECT OF HIFICAR CLASS"
ENTER 7 FOR REFERENCE OF POSSYS INTERFACE AN OBJECT OF HIFICAR CLASS
ENTER 8 FOR HIFICAR OBJECT
0
*/
