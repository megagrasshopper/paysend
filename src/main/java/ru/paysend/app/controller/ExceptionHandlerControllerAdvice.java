package ru.paysend.app.controller;

import static org.springframework.http.HttpStatus.OK;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.paysend.app.domain.WrongPasswordException;
import ru.paysend.app.domain.dto.ApiResponse;
import ru.paysend.app.domain.dto.ResponseCode;

@ControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(OK)
    public ResponseEntity runtimeEx(final Exception ex) {
        log.error(ex.toString(), ex);
        return new ResponseEntity<>(ApiResponse.code(ResponseCode.TECH_ERROR), OK);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(OK)
    public ResponseEntity doesNotExists(final Exception ex) {
        log.error(ex.toString(), ex);
        return new ResponseEntity<>(ApiResponse.code(ResponseCode.USER_DOES_NOT_EXISTS), OK);
    }

    @ExceptionHandler(WrongPasswordException.class)
    @ResponseStatus(OK)
    public ResponseEntity wrongPassword(final Exception ex) {
        log.error(ex.toString(), ex);
        return new ResponseEntity<>(ApiResponse.code(ResponseCode.WRONG_PASSWORD), OK);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseStatus(OK)
    public ResponseEntity userAlreadyExists(final Exception ex) {
        log.error(ex.toString(), ex);
        return new ResponseEntity<>(ApiResponse.code(ResponseCode.USER_EXISTS), OK);
    }
}