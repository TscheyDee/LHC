package APPLICATION;

import INFRASTRUCTURE.Building;
import INFRASTRUCTURE.ENERGY.USP;
import LHC.LargeHadronCollider;
import LHC.Ring;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestApplication {

    private Application application;
    private LargeHadronCollider lhc;
    private Building building;
    private USP[] usps;

    @BeforeEach
    public void setup() {
        application = new Application();
        application.init();

        Ring ring = new Ring();
        building = new Building();
        usps = new USP[2];
        usps[0] = new USP();
        usps[1] = new USP();
        lhc = new LargeHadronCollider(building, usps, ring);
    }

    @Test
    @Order(1)
    public void lhcContainsRingAndUSPTest() {
        //assertEquals(10, application.getValueList().size());
        assertNotNull(lhc);
        assertNotNull(lhc.getRing());
        assertNotNull(lhc.getUsp());
        assertEquals(lhc.getUsp().length, 2);
    }

    @Test
    @Order(2)
    public void containsAllElementsBeforeSorting() {
        ArrayList<Integer> expectedValueList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        assertTrue(expectedValueList.containsAll(application.getValueList()) && application.getValueList().containsAll(expectedValueList));
    }

    @Test
    @Order(3)
    public void sort() {
        ArrayList<Integer> expectedValueList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        application.sort();

        assertEquals(10, application.getValueList().size());
        assertTrue(expectedValueList.containsAll(application.getValueList()) && application.getValueList().containsAll(expectedValueList));

        for (int i = 0; i < application.getValueList().size() - 1; i++) {
            assertTrue(application.getValueList().get(i + 1) > application.getValueList().get(i));
        }
    }
}