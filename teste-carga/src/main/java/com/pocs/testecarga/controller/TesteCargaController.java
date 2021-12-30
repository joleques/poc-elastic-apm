    package com.pocs.testecarga.controller;


import com.pocs.testecarga.repositorio.GeradorService;
import net.logstash.logback.argument.StructuredArguments;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping("/test")
public class TesteCargaController {


    Logger LOGGER = getLogger(TesteCargaController.class);

    @Autowired
    private GeradorService service;

    @PostMapping("/carga/async")
    public ResponseEntity<ApiResult> getNomeTime() {
        Header header = new Header(1L, "test-service");

        try {
            service.executeTest();

            LOGGER.info(String.format("Teste sendo executado."), StructuredArguments.keyValue("header", header));

            return new ResponseEntity<ApiResult>(ApiResult.sucesso("Teste sendo executado."), HttpStatus.OK);
        }catch (Exception e) {
            LOGGER.error(String.format("Problemas a buscar a nome : %s", e.getMessage()), StructuredArguments.keyValue("header", header));
            return new ResponseEntity<ApiResult>(ApiResult.erro(), HttpStatus.BAD_REQUEST);
        }
    }
}
