package vehicle;

 public  class car extends vehicle {
    int gear=0;
    boolean ac;
    public car()
    {
        this.gear=gear;
        this.ac=ac;
    }
    car(int g,boolean a)
    {
        gear=g;
        ac=a;
    }
     public void start()
     {
         System.out.println("the car just started");
     }
     public void stop()
     {
         System.out.println("the car has stopped");
     }
   public void goreverse() 
   {
       System.out.println("car is taking reverse");
   }
   public void start(int gears)
   {
       System.out.println("the car has started with gear no "+gears);
   }
}

