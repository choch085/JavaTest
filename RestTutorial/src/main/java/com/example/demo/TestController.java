package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/testMatrixVariables")
public class TestController {

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<String> getByPathVariable(@PathVariable("id") long v1) {
        return ResponseEntity.ok("ok" + v1);
    }

    @RequestMapping(value = "/get/anotherPathVariable/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<String> getAnotherPathVariableByPathVariable(@PathVariable("id") long v1) {
        return ResponseEntity.ok("ok" + v1);
    }
    
   
    @RequestMapping(value = "/getMatrix/{vars}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> getMatrix(
            @MatrixVariable(pathVar = "vars", required = true) String v1,
            @MatrixVariable(pathVar = "vars", required = true) String v2,
            @MatrixVariable(pathVar = "vars", required = true) String v3) {
        return ResponseEntity.ok("ok" + v1 + v2 + v3);
    }

    @RequestMapping(value = "/get/matrix/{vars}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> getGetMatrix(
            @MatrixVariable(pathVar = "vars", required = true) String v1,
            @MatrixVariable(pathVar = "vars", required = true) String v2,
            @MatrixVariable(pathVar = "vars", required = true) String v3) {
        return ResponseEntity.ok("ok" + v1 + v2 + v3);
    }

}