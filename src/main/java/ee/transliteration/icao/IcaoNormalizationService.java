package ee.transliteration.icao;

import org.springframework.stereotype.Service;

@Service
public class IcaoNormalizationService {

    public IcaoNormalizationService() {}

    public String filterNameCharacters(String input) {
        StringBuilder result = new StringBuilder(input.length());
        for (char character : input.toCharArray()) {
            if (isAlphaNumeric(character)) {
                result.append(character);
                continue;
            }

            char filterCharacter = filterSpecialCharacters(character);
            result.append(filterCharacter);
        }

        return trimWhitespaces(result.toString());
    }

    protected char filterSpecialCharacters(char character) {
        return switch (character) {
            case '.', '-', '/', '\\', '(', ')', '?', ':', ',', '+', ' ' -> character;
            default ->
                    // not valid char replaced with space
                    ' ';
        };
    }

    protected String trimWhitespaces(String result) {
        return result.trim().replaceAll("\\s{2,}", " ");
    }

    protected boolean isAlphaNumeric(char character) {
        return (character >= 'A' && character <= 'z') || (character >= '0' && character <= '9');
    }
}
