package dependency.model;


public class Caches implements ICache {

    private int version;

    private static Caches instance;


    private Caches() {}

    public static Caches getInstance() {
        if (instance == null) {
            instance = new Caches();
            instance.version = 1;
        }
        return instance;

    }

    public int getVersion() {
        return version;
    }

    public static ICache getMerchantCache() {
        return new MerchantCache();
    }

    static class MerchantCache implements ICache{

    }
}


