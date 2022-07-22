package com.diamam.statsApp.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "statistics")
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime requestTime;

    private String url;
    private String requestDescription;



    public Integer getId() {
        return id;
    }

    public LocalDateTime getRequestTime() {
        return requestTime;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public Statistics() {
    }

    public Statistics(LocalDateTime requestTime, String url, String requestDescription) {
        this.requestTime = requestTime;
        this.url = url;
        this.requestDescription = requestDescription;
    }
}
