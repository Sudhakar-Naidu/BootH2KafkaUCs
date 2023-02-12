package com.msn.miscellaneous;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND)
@AllArgsConstructor
public class NoResourceException extends RuntimeException {
    private String message;
}
