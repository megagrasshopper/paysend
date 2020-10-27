package ru.paysend.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.paysend.app.domain.WrongPasswordException;
import ru.paysend.app.domain.dto.ApiRequest;
import ru.paysend.app.domain.dto.ApiResponse;

@Service
@RequiredArgsConstructor
public class RequestHandlerImpl implements RequestHandler {

    private final UserService service;

    @Override
    public ApiResponse handle(ApiRequest request) throws WrongPasswordException {

        switch (request.getRequestType()) {
            case CREATE:
                service.saveUser(request.getLogin(), request.getPassword());
                return ApiResponse.ok();
            case BALANCE:
                return ApiResponse.balance(service.getBalance(request.getLogin(), request.getPassword()));
            default:
                throw new RuntimeException("Unsupported request type " + request.getRequestType());
        }

    }
}
