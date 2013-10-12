package imutability;

import java.util.Date;

import static java.lang.System.*;

/**
 * Created with IntelliJ IDEA.
 * User: gelu
 * Date: 10/10/13
 * Time: 12:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainClass {

    public static void main(String ...args) throws InterruptedException {
        Planet planet = new Planet(1.1d, "theName", new Date());

        MainClass main = new MainClass();

        main.testImutability();

    }


    private void testImutability() {
        Tier tier = new Tier("Goodyear", 1);

        ImmutableCar car = new ImmutableCar(5, tier);
        out.println(car);

        out.println("Trying to change internal state of car:");

        car.getTierDefensiveCopy().setName("Continental");
        out.println(car);
    }




}
