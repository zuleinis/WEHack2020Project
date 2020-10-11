package com.toyotaservice.toyotaapplication;

import java.util.Date;

import org.apache.tomcat.jni.Time;
//Domain Class
public class User {

private String city = "";
private String name = "";
private String address = "";
private double distance = 0;
private Date date = null;
private Time time = null; 



    public User(String city)
    {
        this.city = city;
    }
    
    public void setDistance(double distance)
    {
            this.distance = distance;
    }

    public double getDistance()
    {
        return this.distance;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {return this.name;}

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {return this.address;}

    public void setDate(java.util.Date date2)
    {
        this.date = date2;
    }

    public Date getDate()
    {return this.date;}
    
    public void setTime(Time time)
    {
        this.time = time;
    }

    public Time getTime()
    {return this.time;}


    public String toString()
    {
        return "Results: " + getName() + "," + "Address: " + getAddress() + "," + "Distance: " + getDistance() + "," + "Date: " + getDate() + 
        "," + "Time: " + getTime();
    }

}

