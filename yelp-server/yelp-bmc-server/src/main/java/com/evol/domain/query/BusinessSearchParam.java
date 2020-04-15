package com.evol.domain.query;

import lombok.Data;

@Data
public class BusinessSearchParam extends BaseSearchParam {

    private String name;

    private String city;

    private String state;

    private String postCode;

    private Boolean isOpen;
}
