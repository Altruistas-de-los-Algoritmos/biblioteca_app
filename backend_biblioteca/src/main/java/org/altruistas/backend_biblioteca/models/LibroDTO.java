package org.altruistas.backend_biblioteca.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LibroDTO {
    private String isbn13;
    private String isbn10;
    private String title;
    private String subtitle;
    private String authors;
    private String categories;
    private String thumbnail;
    private String description;
    private Integer publishedYear;
    private Double averageRating;
    private Integer numPages;
    private Integer ratingsCount;
}
