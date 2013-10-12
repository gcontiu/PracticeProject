package imutability;


public class ImmutableCar {

    private final int doors;

    private final Tier tier;

    public ImmutableCar(int doors, Tier tier) {
        this.doors = doors;
        this.tier = tier;
    }

    public int getDoors() {
        return doors;
    }

    /**
     * Not trustable
     */
    @Deprecated
    public Tier getTier() {
        return tier;
    }

    public Tier getTierDefensiveCopy() {
        return new Tier(tier.getName(), tier.getSeason());
    }

    /**
     * Does not compile, tier is final.
     */
    @Deprecated
    public void setTier(Tier aTier) {
        // does not compile - tier is final.
//        this.tier = aTier;
    }

    @Override
    public String toString() {
        return "ImmutableCar{" +
                "doors=" + doors +
                ", tier=" + tier +
                '}';
    }
}
