package org.altruistas.backend_biblioteca.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class GetLibrosResponse {
    @JsonProperty("libros")
    private List<LibroDTO> libroDTOList;
}
