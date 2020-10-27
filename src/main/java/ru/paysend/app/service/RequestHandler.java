package ru.paysend.app.service;

import ru.paysend.app.domain.WrongPasswordException;
import ru.paysend.app.domain.dto.ApiRequest;
import ru.paysend.app.domain.dto.ApiResponse;

public interface RequestHandler {

    ApiResponse handle(ApiRequest request) throws WrongPasswordException;
}
