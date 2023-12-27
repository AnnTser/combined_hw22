package models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class IsbnModel {

    public IsbnModel(String isbn) {
        this.isbn = isbn;
    }
    String isbn;
}