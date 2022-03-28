package ee.transliteration.icao;

import com.ibm.icu.text.Transliterator;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class IcaoTransliterationService {

    private final List<Transliterator> transliterators = new ArrayList<>();

    protected IcaoNormalizationService icaoNormalizationService;

    public IcaoTransliterationService() {
        this.icaoNormalizationService = new IcaoNormalizationService();
        createTransliterators();
    }

    private void createTransliterators() {
        transliterators.addAll(
                Arrays.asList(
                        createTransliterator(IcaoTransliteratorName.ICAO_MULTINATIONAL, IcaoTransliterationRules.getIcaoMultinationalRules()),
                        createTransliterator(IcaoTransliteratorName.ICAO_CYRILLIC, IcaoTransliterationRules.getIcaoCyrillicRules())
                )
        );
    }

    protected static Transliterator createTransliterator(IcaoTransliteratorName name, String[] rules) {
        return Transliterator.createFromRules(name.toString(), String.join("", rules), Transliterator.FORWARD);
    }

    public String transliterateIcao(String input) {
        String transformed = transliterateMultinationalAndGyrllic(input);
        return applyNormalizationRules(transformed);
    }

    protected String transliterateMultinationalAndGyrllic(String input) {
        String result = findTransliteratorByName(IcaoTransliteratorName.ICAO_MULTINATIONAL).transliterate(input);
        return findTransliteratorByName(IcaoTransliteratorName.ICAO_CYRILLIC).transliterate(result);
    }

    protected Transliterator findTransliteratorByName(IcaoTransliteratorName name) {
        for (Transliterator transliterator : transliterators) {
            if (transliterator.getID().equals(name.toString())) {
                return transliterator;
            }
        }

        return null;
    }

    protected String applyNormalizationRules(String name) {
        String[][] rules = IcaoTransliterationRules.getIcaoPunctuationRules();
        String result = name;

        for (String[] rule : rules) {
            result = result.replace(rule[0], rule[1]);
        }

        return icaoNormalizationService.filterNameCharacters(result);
    }
}
