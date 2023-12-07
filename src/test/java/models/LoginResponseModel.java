package models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponseModel {
    @JsonProperty
    String userID;
    @JsonProperty
    String      username;
    @JsonProperty
    String      password;
    @JsonProperty
    String      token;
    @JsonProperty
    String      expires;

    @JsonProperty("created_date")
    String createdDate;
    @JsonProperty()
    String isActive;

}
