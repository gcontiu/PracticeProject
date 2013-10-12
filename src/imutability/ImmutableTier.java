package imutability;


public class ImmutableTier {

    private final Tier mutableTier;

    public ImmutableTier(Tier mutableTier) {
        if (mutableTier == null) {
            throw new IllegalArgumentException("Tier cannot be null!");
        }
        this.mutableTier = mutableTier;
    }

    public Tier getTier() {
        return new Tier(mutableTier.getName(), mutableTier.getSeason());
    }
}
