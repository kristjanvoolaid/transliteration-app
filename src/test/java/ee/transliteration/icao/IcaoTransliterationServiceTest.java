package ee.transliteration.icao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class IcaoTransliterationServiceTest {

    @InjectMocks
    private IcaoTransliterationService icaoTransliterationService;

    @Test
    void createTransliterators_successfullyCreated() {
        assertNotNull(icaoTransliterationService);
    }

    @Test
    void createTransliterator_successfullyCreated() {
        assertNotNull(icaoTransliterationService.createTransliterator(IcaoTransliteratorName.ICAO_MULTINATIONAL, IcaoTransliterationRules.getIcaoMultinationalRules()));
        assertNotNull(icaoTransliterationService.createTransliterator(IcaoTransliteratorName.ICAO_CYRILLIC, IcaoTransliterationRules.getIcaoMultinationalRules()));
    }

    @Test
    void transliterateIsFuzzy_isAllowed() {
        String testInput = "name";
        String testInputv2 = "äädikas";
        String testInputv3 = "jüri";
        String testInputv4 = "jäääär";
        String testInputv5 = "järveääres";
        String testInputv6 = "õunaäädikas";

        assertEquals(icaoTransliterationService.transliterateFuzzy(testInput), "name");
        assertEquals(icaoTransliterationService.transliterateFuzzy(testInputv2), "aeaedikas");
        assertEquals(icaoTransliterationService.transliterateFuzzy(testInputv3), "jueri");
        assertEquals(icaoTransliterationService.transliterateFuzzy(testInputv4), "jaeaeaeaer");
        assertEquals(icaoTransliterationService.transliterateFuzzy(testInputv5), "jaerveaeaeres");
        assertEquals(icaoTransliterationService.transliterateFuzzy(testInputv6), "ounaaeaedikas");
    }

    @Test
    void transliterateIsFuzzy_notAllowed() {
        String testInputv2 = "äädikas";
        String testInputv3 = "jüri";
        String testInputv4 = "jäääär";
        String testInputv5 = "järveääres";
        String testInputv6 = "õunaäädikas";

        assertNotEquals(icaoTransliterationService.transliterateFuzzy(testInputv2), "äädikas");
        assertNotEquals(icaoTransliterationService.transliterateFuzzy(testInputv3), "jüri");
        assertNotEquals(icaoTransliterationService.transliterateFuzzy(testInputv4), "jäääär");
        assertNotEquals(icaoTransliterationService.transliterateFuzzy(testInputv5), "järveääres");
        assertNotEquals(icaoTransliterationService.transliterateFuzzy(testInputv6), "õunaäädikas");
    }

    @Test
    void findTransliteratorByName_shouldReturnTransliterator() {
        assertEquals(icaoTransliterationService.findTransliteratorByName(IcaoTransliteratorName.ICAO_MULTINATIONAL), icaoTransliterationService.findTransliteratorByName(IcaoTransliteratorName.ICAO_MULTINATIONAL));
        assertEquals(icaoTransliterationService.findTransliteratorByName(IcaoTransliteratorName.ICAO_CYRILLIC), icaoTransliterationService.findTransliteratorByName(IcaoTransliteratorName.ICAO_CYRILLIC));
    }
}
