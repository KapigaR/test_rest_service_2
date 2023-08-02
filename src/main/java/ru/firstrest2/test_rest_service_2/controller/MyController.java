package ru.firstrest2.test_rest_service_2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.firstrest2.test_rest_service_2.model.Request;
import ru.firstrest2.test_rest_service_2.model.Response;
import ru.firstrest2.test_rest_service_2.service.MyModifyService;

@Slf4j
@RestController
public class MyController {

    private final MyModifyService myModifyService;

    @Autowired
    public MyController(@Qualifier("ModifyErrorMessage") MyModifyService myModifyService) {
        this.myModifyService = myModifyService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@RequestBody Request request) {

        log.info("Входящий request : " + String.valueOf(request));

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("ratata")
                .errorCode("code1")
                .errorMessage("message")
                .build();

        Response responseAfterModify = myModifyService.modify (response);
        log.info("Исходящий response : " + String.valueOf(response));
        return new ResponseEntity<>(responseAfterModify, HttpStatus.OK);
    }
}
