package ee.transliteration.icao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class IcaoTransliteratorNamesTest {

    @InjectMocks
    private IcaoTransliterationService icaoTransliterationService;

    @InjectMocks
    private IcaoNormalizationService icaoNormalizationService;

    private String[][] ICAO_NAMES = {
            {"D'Amato", "D AMATO", "DAMATO"},
    };

    @BeforeEach
    public void setUp() {
        icaoTransliterationService.icaoNormalizationService = icaoNormalizationService;
    }

    @Test
    void testNames() {
        for (String[] name : ICAO_NAMES) {
            assertEquals(name[2], icaoTransliterationService.transliterateFuzzy(name[0].toUpperCase()));
        }
    }
}
