package com.example.spring.oct.controller;

import com.example.spring.oct.dto.*;
import com.example.spring.oct.exception.DMakerException;
import com.example.spring.oct.service.DMakerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class DMakerController {
    private final DMakerService dMakerService;

    //@RequiredConstructor(Core(Dependency Injection, Inversion of Control))
    public DMakerController(DMakerService dMakerService) {
        this.dMakerService = dMakerService;
    }

    @GetMapping("/developers")
    public List<DeveloperDto> getAllDevelopers() {
        log.info("GET /developers HTTP/1.1");

        return dMakerService.getAllEmployedDevelopers();
    }

    @GetMapping("/developer/{memberId}")
    public DeveloperDetailDto getDeveloperDetail(
            @PathVariable final String memberId
    ) {
        log.info("GET /developers HTTP/1.1");

        return dMakerService.getDeveloperDetail(memberId);
    }
    @PostMapping("/create-developer")
    public CreateDeveloper.Response createDevelopers(
          @Valid @RequestBody final CreateDeveloper.Request request
    ) {
        //GET /developers HTTP/1.1
        log.info("request: {}", request);
        //old-style
//
//        DeveloperValidationDto developerValidationDto =
//                dMakerService.validateCreateDeveloperRequest(request);

        //old-style
//        if(developerValidationDto !=null){
//            return CreateDeveloper.Response.builder()
//                    .errorCode(developerValidationDto.getErrorCode())
//                    .errorMessage(developerValidationDto.getErrorMessage())
//                    .build();
//        }
        return dMakerService.createDeveloper(request);

    }
    @PutMapping("/developer/{memberId}")
    public DeveloperDetailDto editDeveloper(
            @PathVariable final String memberId,
            @Valid @RequestBody final EditDeveloper.Request request
    ) {
        log.info("GET /developers HTTP/1.1");

        return dMakerService.editDeveloper(memberId, request);
    }

    @DeleteMapping("/developer/{memberId}")
    public DeveloperDetailDto deleteDeveloper(
            @PathVariable final String memberId
    ) {
        return dMakerService.deleteDeveloper(memberId);
    }

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(DMakerException.class)
    public DMakerErrorResponse handleException(
            DMakerException e,
            HttpServletRequest request
    ){
        log.error("errorCode: {}, url: {}, message: {}",
                e.getDMakerErrorCode(), request.getRequestURI(), e.getDetailMessage());

        return DMakerErrorResponse.builder()
                .errorCode(e.getDMakerErrorCode())
                .errorMessage(e.getDetailMessage())
                .build();
    }


}
