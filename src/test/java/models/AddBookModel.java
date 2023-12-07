package models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

    @Data
    public class AddBookModel {
        @JsonProperty
    String userID;
        @JsonProperty
        IsbnModel  collectionOfIsbns [] = new IsbnModel[10];

}
