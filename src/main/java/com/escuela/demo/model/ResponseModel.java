package com.escuela.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class ResponseModel {

    @Setter
    @Getter
    private int code;

    @Setter @Getter
    private String mesagge;

    @Setter @Getter
    private String description;

}

