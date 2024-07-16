package com.example.CodingShuttle.HomeWork2.RestApi.RestApi.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
@Builder
public class ApiError {
    private HttpStatus status;
    private String message;
}
/* Structure of this class
{
    "timestamp": "2024-07-13T06:23:25.866+00:00",
    "status": 400,                                    //Status
    "error": "Bad Request",                           //message
    "path": "/departments"
}
 */
