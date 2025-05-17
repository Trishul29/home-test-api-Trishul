package org.example.PojoClasses.create;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.PojoClasses.BaseResponse;

@Getter
@Setter
@Builder
@Data
public class CreateItemResponse extends BaseResponse {

    private String id;
    private String name;
    private String author;
    private String published_year;
    private String book_summary;
    private String created_at; // Optional: if your API returns timestamps
    private String updated_at;
}
