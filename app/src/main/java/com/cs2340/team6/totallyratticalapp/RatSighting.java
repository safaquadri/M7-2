package com.cs2340.team6.totallyratticalapp;

/**
 * Created by dylan on 10/14/2017.
 */

public class RatSighting {
    private String key;
    private String createdDate;
    private String locationType;
    private String incidentZip;
    private String incidentAddress;
    private String city;
    private String borough;
    private String latitude;
    private String longitude;

    /**
     * Creates a new Rat Sighting object, taking the relevant information
     * from given array
     *
     * @param split array of Strings holding information
     */
    public RatSighting(String[] split) {
        key = split[0];
        createdDate = split[1];
        locationType = split[7];
        incidentZip = split[8];
        incidentAddress = split[9];
        city = split[16];
        borough = split[23];
        latitude = split[split.length-3];
        longitude = split[split.length-2];
    }

    /**
     * Creates new RatSighting object with given info, and key 1
     *
     * @param date the date of sighting
     * @param locType the type of location
     * @param zip The zip code of sighting
     * @param address The address of sighting
     * @param city the city of sighting
     * @param borough the borough of sighting
     * @param lat the latitude of sighting
     * @param lon the longitude of sighting
     */
    public RatSighting(String date, String locType, String zip, String address, String city, String borough, String lat, String lon) {
        key = "1";
        createdDate = date;
        locationType = locType;
        incidentZip = zip;
        incidentAddress = address;
        this.city = city;
        this.borough = borough;
        latitude = lat;
        longitude = lon;

    }

    /**
     * Returns formatted list of information to display on Information screen
     *
     * @return String holding given information.
     */
    public String getInfo() {
        return "Unique Key ; " + key + "\r\n" +
                "Date Created ; " + createdDate + "\r\n" +
                "Location Type ; " + locationType + "\r\n" +
                "Incident Zip ; " + incidentZip + "\r\n" +
                "Incident Address ; " + incidentAddress + "\r\n" +
                "City ; " + city + "\r\n" +
                "Borough : " + borough + "\r\n" +
                "Latitude : " + latitude + "\r\n" +
                "Longitude : " + longitude;
    }

    /**
     * Get relevant information for quick display in ListView item
     *
     * @return String containing information
     */
    public String toString() {
        return locationType + "  " + createdDate + "  " + incidentAddress;
    }
}
