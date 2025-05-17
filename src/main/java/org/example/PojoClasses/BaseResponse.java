package org.example.PojoClasses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
    private int statusCode;
    private long responseTime;

}
