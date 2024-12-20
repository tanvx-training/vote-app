package dev.tanvx.auth_service.application.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

@Getter
public class BusinessException extends RuntimeException {

  private final HttpStatus httpStatus;
  private final List<String> messages;

  public BusinessException(HttpStatus httpStatus) {
    this.httpStatus = httpStatus;
    this.messages = Collections.emptyList();
  }

  public BusinessException(HttpStatus httpStatus, String message) {
    super(message);
    this.httpStatus = httpStatus;
    this.messages = Collections.singletonList(message);
  }

  public BusinessException(HttpStatus httpStatus, List<String> messages) {
    this.httpStatus = httpStatus;
    this.messages = messages != null ? messages : Collections.emptyList();
  }
}

