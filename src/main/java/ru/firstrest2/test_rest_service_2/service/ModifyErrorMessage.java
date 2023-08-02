package ru.firstrest2.test_rest_service_2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.firstrest2.test_rest_service_2.model.Response;

@Service
@RequiredArgsConstructor
@Qualifier("ModifyErrorMessage")
public class ModifyErrorMessage implements MyModifyService{
    @Override
    public Response modify(Response response) {

        response.setErrorMessage("Всё сломалось");

        return response;
    }
}
