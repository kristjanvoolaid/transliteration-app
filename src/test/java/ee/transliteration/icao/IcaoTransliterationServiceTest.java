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
    void transliterateIcao_isAllowed() {
        String testInput = "name";
        String testInputv2 = "äädikas";
        String testInputv3 = "jüri";
        String testInputv4 = "jäääär";
        String testInputv5 = "järveääres";
        String testInputv6 = "õunaäädikas";

        assertEquals(icaoTransliterationService.transliterateIcao(testInput), "name");
        assertEquals(icaoTransliterationService.transliterateIcao(testInputv2), "aeaedikas");
        assertEquals(icaoTransliterationService.transliterateIcao(testInputv3), "jueri");
        assertEquals(icaoTransliterationService.transliterateIcao(testInputv4), "jaeaeaeaer");
        assertEquals(icaoTransliterationService.transliterateIcao(testInputv5), "jaerveaeaeres");
        assertEquals(icaoTransliterationService.transliterateIcao(testInputv6), "ounaaeaedikas");
    }

    @Test
    void transliterateIcao_notAllowed() {
        String testInputv2 = "äädikas";
        String testInputv3 = "jüri";
        String testInputv4 = "jäääär";
        String testInputv5 = "järveääres";
        String testInputv6 = "õunaäädikas";

        assertNotEquals(icaoTransliterationService.transliterateIcao(testInputv2), "äädikas");
        assertNotEquals(icaoTransliterationService.transliterateIcao(testInputv3), "jüri");
        assertNotEquals(icaoTransliterationService.transliterateIcao(testInputv4), "jäääär");
        assertNotEquals(icaoTransliterationService.transliterateIcao(testInputv5), "järveääres");
        assertNotEquals(icaoTransliterationService.transliterateIcao(testInputv6), "õunaäädikas");
    }

    @Test
    void findTransliteratorByName_shouldReturnTransliterator() {
        assertEquals(icaoTransliterationService.findTransliteratorByName(IcaoTransliteratorName.ICAO_MULTINATIONAL), icaoTransliterationService.findTransliteratorByName(IcaoTransliteratorName.ICAO_MULTINATIONAL));
        assertEquals(icaoTransliterationService.findTransliteratorByName(IcaoTransliteratorName.ICAO_CYRILLIC), icaoTransliterationService.findTransliteratorByName(IcaoTransliteratorName.ICAO_CYRILLIC));
    }
}
