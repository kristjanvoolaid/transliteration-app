package ee.transliteration.icao;

import ee.transliteration.ErrorMessage;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@RestController
@Tag(name = "Transliteration service")
@Profile("transliteration-web")
public class IcaoTransliterationController implements IcaoTransliterationApi {

    private final IcaoTransliterationService icaoTransliterationService;

    public IcaoTransliterationController() {
        this.icaoTransliterationService = new IcaoTransliterationService();
    }

    @Override
    public String transliterateIcao(String input) {
        return icaoTransliterationService.transliterateIcao(input);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ErrorMessage constraintViolationExeption(HttpServletRequest request, ConstraintViolationException exception) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST, exception, request);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ErrorMessage internalServerErrorExeption(HttpServletRequest request, Exception exception) {
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception, request);
    }
}