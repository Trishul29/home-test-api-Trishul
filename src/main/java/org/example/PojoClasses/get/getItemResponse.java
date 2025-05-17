package org.example.PojoClasses.get;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import org.example.PojoClasses.BaseResponse;
import java.util.List;
@Getter
public class getItemResponse extends BaseResponse {

    @JsonProperty("data")
    private List<MenuItem> data;

    @Data
    @Getter
    public static class MenuItem {
        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

        @JsonProperty("image")
        private String image;

        @JsonProperty("price")
        private String price;
    }

}

