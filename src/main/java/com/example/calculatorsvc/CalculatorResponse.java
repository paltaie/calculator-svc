package com.example.calculatorsvc;

public class CalculatorResponse {
    private final int result;

    public CalculatorResponse(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }
}
