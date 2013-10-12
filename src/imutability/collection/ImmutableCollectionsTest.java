package imutability.collection;

import com.google.common.collect.ImmutableList;
import imutability.Tier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.out;

/**
 * Tests immutability for
 * <ul>
 *     <li>JDK's java.util.Collections.unmodifiableList(...)</li>
 *     <li>Guava's ImmutableList</li>
 * </ul>
 */
public class ImmutableCollectionsTest {

    public static void main(String [] args) {
        ImmutableCollectionsTest main = new ImmutableCollectionsTest();
        List<Tier> tiers = main.buildTiersList();

        main.runUnmodifiableListTest(main);

        main.runImmutableListTest(main);

    }

    private void runImmutableListTest(ImmutableCollectionsTest main) {
        List<Tier> tiers;
        out.println("Test guava's ImmutableList");
        printSeparator();
        tiers = main.buildTiersList();
        out.println("Original tiers:");
        printTiersList(tiers);

//        ImmutableList<Tier> immutableList = ImmutableList.copyOf(tiers);
        ImmutableList immutableList = ImmutableList.builder().addAll(tiers).build();
        main.testListImmutability(immutableList, tiers);
        printSeparator();
    }

    private void runUnmodifiableListTest(ImmutableCollectionsTest main) {
        List<Tier> tiers;
        out.println("Test Collections.unmodifiableList");
        printSeparator();
        tiers = main.buildTiersList();
        out.println("Original tiers:");
        List<Tier> unmodifiableTiers = Collections.unmodifiableList(tiers);
        main.testListImmutability(unmodifiableTiers, tiers);
        printSeparator();
    }

    /**
     * This is the test method used by both List types:
     * @param unmodifiableTiers List that is supposed to be immutable
     * @param backedList Original List that is the base for the immutable list.
     */
    public void testListImmutability(List<Tier> unmodifiableTiers, List<Tier> backedList) {
        assert unmodifiableTiers.get(0).equals(backedList.get(0));
        out.println("*** Trying to change a tier's name:");
        Tier tier = backedList.get(0);
        try {
            tier.setName("ChangedTierName");
        } catch (Exception e) {
            e.printStackTrace();
        }
        printTiersList(unmodifiableTiers);

        out.println("*** Trying to add a tier:");
        try {
            backedList.add(new Tier("NewTier", 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        printTiersList(unmodifiableTiers);


//        out.println("Trying to change a tier's reference");
//        tier = new Tier("NewReference", 1);
//        unmodifiableTiers.add(tier);
//        printTiersList(unmodifiableTiers);
    }

    // ----------------------------------------------

    private List<Tier> buildTiersList() {
        List<Tier> tiers = new ArrayList<Tier>();
        tiers.add(new Tier("Goodyear", 1));
        tiers.add(new Tier("Continental", 2));
        tiers.add(new Tier("Dunlop", 1));
        return tiers;
    }

    private static void printTiersList(List<Tier> unmodifiableTiers) {
        for (Tier tier : unmodifiableTiers) {
            out.print(tier);
        }
        out.println();
    }

    private static void printSeparator() {
        out.println("===============================");
    }
}
