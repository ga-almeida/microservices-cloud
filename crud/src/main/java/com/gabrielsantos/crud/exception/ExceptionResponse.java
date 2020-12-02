package com.gabrielsantos.crud.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {

    private ZonedDateTime timestamp;
    private String message;
    private String details;

}
