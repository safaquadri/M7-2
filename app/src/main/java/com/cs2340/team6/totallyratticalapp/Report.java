package com.cs2340.team6.totallyratticalapp;

/**
 * Created by Safa
 */

public class Report {
    private String date;
    private String locationType;
    private String time;
    private String zipcode;
    private String address;
    private String longlat;
    private String cityName;
    private String borough;



    /**
     * Creates user with given attributes
     *
     * @param date date of entry
     * @param locationType location type of sighting
     * @param time time of entry
     * @param zipcode sighting location's zipcode
     * @param address address of rat sighting
     * @param longlat longitudinal,latitudinal coordinates of sighting
     * 
     */
    public User (String name, String username, String password, User.Role role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * Returns name attribute for this user
     *
     * @return name
     */
    public String getName() {return name;}

    /**
     * Returns username attribute for this user
     *
     * @return username
     */
    public String getUsername() {return username;}

    /**
     * Returns password attribute for this user
     *
     * @return password
     */
    public String getPassword() {return password;}
}
