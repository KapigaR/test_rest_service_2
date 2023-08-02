package ru.firstrest2.test_rest_service_2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.firstrest2.test_rest_service_2.model.Response;

@Service
@Qualifier("ModifyUid")
public class ModifyUid implements MyModifyService{
    @Override
    public Response modify(Response response) {
        response.setUid("New Uid");

        return response;
    }
}
