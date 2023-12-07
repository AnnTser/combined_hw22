package models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RemoveBookModel {
    public RemoveBookModel(String isbn, String userID) {
        this.isbn = isbn;
        this.userID = userID;
    }

    @JsonProperty
    String isbn;
    @JsonProperty
    String userID;

}
