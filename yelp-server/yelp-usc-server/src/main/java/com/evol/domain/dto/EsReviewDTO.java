package com.evol.domain.dto;

import java.util.Date;

public class EsReviewDTO {

    public Integer id;

    public Integer stars;

    public Date date;

    public String text;

    public Integer useful;

    public Integer funny;

    public Integer cool;

    public Integer businessId;

    public Integer userId;

    public EsReviewDTO(){}

    public EsReviewDTO(Integer id, Integer stars, Date date, String text, Integer useful, Integer funny, Integer cool,
                  Integer businessId, Integer userId){
        this.id = id;
        this.stars = stars;
        this.date = date;
        this.text = text;
        this.useful = useful;
        this.funny = funny;
        this.cool = cool;
        this.businessId = businessId;
        this.userId = userId;

    }
}
