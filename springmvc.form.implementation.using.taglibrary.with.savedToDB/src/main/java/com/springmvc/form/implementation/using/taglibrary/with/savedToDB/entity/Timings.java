package com.springmvc.form.implementation.using.taglibrary.with.savedToDB.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIMINGS")
public class Timings {

    @Id
    @Column(name = "timing_id")
    private Integer timingId;

    @Column(name = "timing_name")
    private String timingName;

    public Integer getTimingId() {
        return timingId;
    }

    public void setTimingId(Integer timingId) {
        this.timingId = timingId;
    }

    public String getTimingName() {
        return timingName;
    }

    public void setTimingName(String timingName) {
        this.timingName = timingName;
    }
}
