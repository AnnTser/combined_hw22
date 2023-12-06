package models;

import lombok.Data;

@Data
public class RemoveBookModel {
        public RemoveBookResponseModel(String isbn, String userId) {
            this.isbn = isbn;
            this.userId = userId;
        }
        String isbn, userId;

}
