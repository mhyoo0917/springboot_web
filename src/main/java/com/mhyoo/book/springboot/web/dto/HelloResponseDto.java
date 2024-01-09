package com.mhyoo.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    private String name = "";
    private int amount = 0;

    public String getName(){
        return name;
    }
    public int getAmount(){
        return amount;
    }
    public HelloResponseDto(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
}