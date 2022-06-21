package com.electronicticket.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Niubaiquan
 * @desc 违法停车告知单
 * @date 2022年02月23日 2022/2/23
 */
@Entity
@Table(name = "ticket")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "carid")
    private String carId;
    @Column(name = "carcolor")
    private String carColor;
    @Column(name = "cartype")
    private String carType;
    @Column(name = "color")
    private String color;
    @Column(name = "parkingdate")
    private Timestamp parkingDate;
    @Column(name = "parkinglocation")
    private String parkingLocation;
    @Column(name = "dress")
    private String dress;
    @Column(name = "telephone")
    private String telphone;
    @Column(name = "recordperson")
    private String recordPerson;
    @Column(name = "imgpath")
    private String imgPath;
}
