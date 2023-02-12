package com.msn.miscellaneous;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionDetails {
    private String message;
    private String errorCode;
}
