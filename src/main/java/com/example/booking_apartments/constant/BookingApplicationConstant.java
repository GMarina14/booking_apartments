package com.example.booking_apartments.constant;

public class BookingApplicationConstant {

    /**
     * Path constants
     */
    public final static String BASE_URL = "/api/v1";
    public final static String REGISTRATION = BASE_URL + "/registration";
    public final static String AUTHORISATION = BASE_URL + "/auth";
    public final static String APARTMENT = BASE_URL + "/property";
    public final static String APARTMENT_REGISTRATION = APARTMENT + "/register";
    public final static String GET_APARTMENT_BY_ID = APARTMENT + "/by-id/{id}";
    public final static String GET_APARTMENTS_BY_LOCATION = APARTMENT+"/by-location";
    public final static String ADD_IMAGE_OF_APARTMENT = APARTMENT+"/add-photo";
    public final static String GET_BOOKING = BASE_URL+"/get-booking";



    /**
     * Message constants
     */
    public final static String NON_UNIQUE_NICKNAME = "User with the same nickname already exists";
    public final static String NON_UNIQUE_USERNAME = "User with the same username already exists";
    public final static String USER_REGISTRATION_SUCCESSFUL = "User registration is successful";
    public final static String USER_DOESNT_EXIST = "User doesn't exist, registration is needed";

    public final static String USER_AUTHORISATION_SUCCESSFUL = "User authorisation is successful";
    public final static String PASSWORD_INCORRECT = "Password is incorrect";

    public final static String PROPERTY_ALREADY_REGISTERED = "Property is already registered";
    public final static String APARTMENT_REGISTRATION_SUCCESSFUL = "Apartment registration is successful";
    public final static String NON_VALID_TOKEN = "Non valid token";
    public final static String APARTMENT_PHOTOS_UPLOAD_SUCCESSFUL ="Apartment's photos are saved successfully";

    /**
     * Consts
     */

    public final static String ID_GEO_CONSTANT="GEO";




}
