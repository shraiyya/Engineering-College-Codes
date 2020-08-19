package vehicle;

 public class hificar extends car implements fly,possys {

    
        public void stop() {
            System.out.println("the hificar has stopped");
        } 
    
        public void fly() {
            System.out.println("the hificar cannot fly ");
            
        }

    
        public void flyfast(int inc_speed) {
            System.out.println("the hificar increased the speed to "+inc_speed);
        }

        
        public void flyslow(int dec_speed) {
            System.out.println("the hificar decreased it speed to  "+dec_speed);
            
        }

        
        public void start(int gears) {
            System.out.println("the hificar changed its gear to. "+gears);
            
        }


        public void showroadahead() {
            System.out.println("the hificar has to travel 100 m ahead");
            
        }


    
        public void searchlocation(String place) {
            System.out.println("the hificar is trying to search the given location : "+place);
            
        }
        public void start() {
            System.out.println("the hifcar has started");
            
        }
        public void ferrari()
        {
            System.out.println("the hifi car is a ferrari");
        }

}

