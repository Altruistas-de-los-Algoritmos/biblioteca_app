package org.altruistas.backend_biblioteca.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetLibroResponse {
    @JsonProperty("libro")
    private LibroDTO libroDTO;
}
