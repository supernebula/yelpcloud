package com.evol.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Review {

    @Id
    public String _id;

    public Integer id;

    public Integer stars;

    public Date date;

    public String text;

    public Integer useful;

    public Integer funny;

    public Integer cool;

    public Integer businessId;

    public Integer userId;

    public Review(){}

    public Review(Integer id, Integer stars, Date date, String text, Integer useful, Integer funny, Integer cool,
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

    @Override
    public String toString() {
        return String.format(
                "Review[id=%s, stars='%s', date='%s', text='%s', useful='%s', funny='%s', cool='%s', businessId='%s',funny='%s']",
                id, stars, date, text, useful, funny, cool, businessId, userId);
    }

}
