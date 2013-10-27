package dependency.module;

import com.google.inject.AbstractModule;
import dependency.IShopperBean;
import dependency.ShopperBean;
import dependency.model.Caches;
import dependency.model.ICache;

public class MyGuiceModule extends AbstractModule {


    @Override
    protected void configure() {

        bind(ICache.class).toInstance(Caches.getInstance());
        bind(IShopperBean.class).to(ShopperBean.class);
    }
}
