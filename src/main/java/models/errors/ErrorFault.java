package models.errors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorFault {
    @JsonProperty("faultId")
    public String faultId;
    @JsonProperty("traceId")
    public String traceId;
    @JsonProperty("errors")
    public ArrayList<ErrorLogs> errors;
}
