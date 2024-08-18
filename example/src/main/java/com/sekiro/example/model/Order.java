package com.sekiro.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Order(
        @JsonProperty(value = "c-name") String customerName,
        @JsonProperty(value = "p-name") String productName,
        @JsonProperty(value = "quantity") int quantity) {
}
