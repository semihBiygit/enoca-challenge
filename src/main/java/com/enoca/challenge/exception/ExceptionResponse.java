package com.enoca.challenge.exception;

import lombok.*;
import org.springframework.stereotype.Component;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class ExceptionResponse {
    private int exceptionCode;
    private String exceptionMessage;
    private String httpStatus;
}
