package com.example.calculatorsvc;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CalculatorController {
    @PostMapping("/add")
    public @ResponseBody CalculatorResponse add(@RequestBody CalculatorRequest calculatorRequest) {
        return new CalculatorResponse(calculatorRequest.getFirstNumber() + calculatorRequest.getSecondNumber());
    }

    @PostMapping("/batchAdd")
    public @ResponseBody
    List<CalculatorResponse> add(@RequestBody List<CalculatorRequest> calculatorRequests) {
        return calculatorRequests.stream().map(a -> new CalculatorResponse(Math.addExact(a.getFirstNumber(), a.getSecondNumber()))).collect(Collectors.toList());
    }

    @PostMapping("/subtract")
    public @ResponseBody CalculatorResponse subtract(@RequestBody CalculatorRequest calculatorRequest) {
        return new CalculatorResponse(calculatorRequest.getFirstNumber() - calculatorRequest.getSecondNumber());
    }

    @PostMapping("/divide")
    public @ResponseBody CalculatorResponse divide(@RequestBody CalculatorRequest calculatorRequest) {
        return new CalculatorResponse(calculatorRequest.getFirstNumber() / calculatorRequest.getSecondNumber());
    }

    @PostMapping("/multiply")
    public @ResponseBody CalculatorResponse multiply(@RequestBody CalculatorRequest calculatorRequest) {
        return new CalculatorResponse(calculatorRequest.getFirstNumber() * calculatorRequest.getSecondNumber());
    }
}
