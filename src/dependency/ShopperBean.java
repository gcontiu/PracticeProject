package dependency;

import com.google.inject.Inject;
import dependency.model.ICache;

public class ShopperBean implements IShopperBean {


    @Inject
    private ICache merchantCache;



    public void printMerchant() {
        System.out.print("merchantCache=" + merchantCache);
    }

}
