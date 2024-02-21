package com.esalon.dto;

import com.esalon.models.Salon;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalonResponse {
    @JsonProperty("message")
    private String message;
    private Salon salon;
}
