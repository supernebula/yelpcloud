package com.evol.domain.model;

public class Hours {
    private String id;

    private String hours;

    private String businessId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours == null ? null : hours.trim();
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId == null ? null : businessId.trim();
    }
}