package com.epam.gym.web.controller;

import com.epam.gym.web.dto.SimpleDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class ReportsController {
    @GetMapping(value = "/send/{txt}")
    public String send(@PathVariable String txt) {
        return txt;
    }

    @GetMapping(value = "/send/dto")
    public ResponseEntity<SimpleDto> sendDto(@RequestBody SimpleDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}