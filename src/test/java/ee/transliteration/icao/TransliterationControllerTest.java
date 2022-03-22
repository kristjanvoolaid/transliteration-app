package ee.transliteration.icao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = IcaoTransliterationController.class)
@ActiveProfiles("transliteration-web")
public class TransliterationControllerTest {

    @MockBean
    private IcaoTransliterationService icaoTransliterationService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void transliterateIcao_shouldReturn200() throws Exception {
        mockMvc.perform(
                get("/api").param("source", "name")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        mockMvc.perform(
                get("/api").param("source", "äädikas")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void transliterateIcao_shouldReturn400() throws Exception {
        mockMvc.perform(
                get("/api").param("source", "")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is4xxClientError());

        mockMvc.perform(
                get("/api")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is4xxClientError());
    }
}
