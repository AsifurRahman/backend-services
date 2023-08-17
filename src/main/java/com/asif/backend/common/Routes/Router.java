package com.asif.backend.common.Routes;

public class Router {
    public static final String PATH_VARIABLE_BY_ID = "/{id}";

//    public static final String QUESTION = ApiVersion.QUESTION_V1 + "/question";

    private static final String AUTH = "/auth";

    public static final String AUTH_URL_V1 = ApiConstants.BASE_URL_V1 + AUTH;

    public static final String REFRESH_TOKEN = AUTH_URL_V1 + "/refresh-token";

    public static final String LOGIN = AUTH_URL_V1 + "/login";


    //  User
    public static final String USER = "/user";

    public static final String USER_URL_V1 = ApiConstants.BASE_URL_V1 + USER;
    public static final String CREATE_USER = USER_URL_V1;

    public static final String PING = ApiConstants.BASE_URL_V1 + "/ping";

    // Subject
    public static final String SUBJECT = "/subject";

    // Topic
    public static final String TOPIC = "/topic";


    public static final String[] PUBLIC_ENDPOINTS = new String[]{
            "/v3/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/api/v1/auth/**",
            USER_URL_V1
    };

}
