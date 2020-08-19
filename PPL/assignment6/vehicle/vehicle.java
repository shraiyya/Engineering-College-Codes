package vehicle;
import java.util.Scanner;
public abstract class vehicle
{
    int regisn=0;
    int hpow=0;
    int cost=0;
    vehicle(){
        
    }
    vehicle(int rn, int hp, int c)
    {
        regisn=rn;
        hpow=hp;
        cost=c;
    }
    public void regVehicle()
    {
        System.out.println("the vehicle has a valid registration");
    }
   public abstract void stop();
   public abstract void start();
}

