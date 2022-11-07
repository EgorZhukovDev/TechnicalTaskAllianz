package models.errors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorLogs {
    @JsonProperty("errorCode")
    public String errorCode;
    @JsonProperty("description")
    public String description;
    @JsonProperty("invalidParameter")
    public String invalidParameter;
    @JsonProperty("validationRule")
    public String validationRule;
}
