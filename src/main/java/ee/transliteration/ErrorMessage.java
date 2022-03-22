package ee.transliteration;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class ErrorMessage {

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private final Date timestamp = new Date();

    @Schema(example = "418")
    private final Integer status;

    @Schema(example = "I'm a teapot")
    private final String error;

    @Schema(example = "Detailed error message")
    private final String detail;

    @Schema(example = "/api/v1")
    private final String path;

    public ErrorMessage(HttpStatus status, Exception exception, HttpServletRequest request) {
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.detail = exception.getMessage();
        this.path = request.getServletPath();
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getDetail() {
        return detail;
    }

    public String getPath() {
        return path;
    }
}
