package ee.transliteration.icao;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotEmpty;

@RequestMapping("api")
@Validated
public interface IcaoTransliterationApi {

    @GetMapping(value = "/v1/icao", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponse(responseCode = "200", content = @Content(array = @ArraySchema(schema = @Schema(example = "Müller"))))
    String transliterateIcao(@RequestParam(value = "source", required = false) @NotEmpty @Schema(example = "Müller") String input);
}
