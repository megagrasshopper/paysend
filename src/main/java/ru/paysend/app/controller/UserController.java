package ru.paysend.app.controller;

import io.swagger.annotations.Api;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.paysend.app.domain.WrongPasswordException;
import ru.paysend.app.domain.dto.ApiRequest;
import ru.paysend.app.domain.dto.ApiResponse;
import ru.paysend.app.service.RequestHandler;

@RestController
@RequiredArgsConstructor
@Api("User operations")
@RequestMapping("/api/user")
public class UserController {

    private final RequestHandler handler;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ApiResponse doIt(@Valid @RequestBody ApiRequest request) throws WrongPasswordException {
        return handler.handle(request);
    }

}