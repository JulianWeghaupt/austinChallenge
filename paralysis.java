import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

public class paralysis{

    private final static int attempts=1000000000;
    private final static int tries=231;
    private final static int needed= 177;
    private final static int options= 4;

    private final static Random random= new Random();

    public static void main(String [] args){

        LocalTime start= LocalTime.now();

        System.out.println("Maximum paralysis in " + attempts + " is " + makeAttempts(attempts, needed, tries, options));

        LocalTime finish= LocalTime.now();

        System.out.println("Time to finish: " + Duration.between(start, finish).toMillis() + "ms");
    }

    public static int makeAttempts(int attempts, int needed, int tries, int options) {
        

        int maxLanded=0;;
        for (int i=1; i<=attempts; i++){

            int landed= makeTry();
            if(maxLanded<landed){
                maxLanded=landed;
            }
            if (maxLanded>= needed){
                System.out.println("Landed " + needed + " successes at try number " + i);
                return maxLanded;
            }
        }
        return maxLanded;
    }

    private static int makeTry (){
        int landed=0;

        for (int i=0; i<tries; i++){
            if(random.nextInt(options)==0)
              landed+=1;
        }

        return landed;
    }
}