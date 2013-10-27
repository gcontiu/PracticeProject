package dependency.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import dependency.ShopperBean;
import dependency.model.Caches;
import dependency.model.Elvis;
import dependency.model.ICache;
import dependency.module.MyGuiceModule;

public class Server {

    public static void main(String... args) {

//        ICache cache = Caches.getMerchantCache();
//
//        Injector injector = Guice.createInjector(new MyGuiceModule());
//
//
//        ShopperBean shopperBean = new ShopperBean();
//
//        shopperBean.printMerchant();


        System.out.println(Elvis.INSTANCE.getAge());

    }
}
