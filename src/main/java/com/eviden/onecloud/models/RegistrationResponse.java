package com.eviden.onecloud.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@lombok.Value
@Getter
@Setter
@ToString
public class RegistrationResponse {

    private int statusCode;
    private String statusMessage;
}
