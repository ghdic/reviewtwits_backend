package com.reviewtwits.util;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
    public static String getAuthorizationToken(String header) {
        header.replace("Bearer ", ""); // Auth : Bearer <access_token>
        if(header == null || !header.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Invalid authorization header");
        }

        String[] parts = header.split(" ");
        if(parts.length != 2) {
            throw new IllegalArgumentException("Invalid authorization header");
        }

        return parts[1];
    }

    public static String getAuthorizationToken(HttpServletRequest request) {
        return getAuthorizationToken(request.getHeader("Authorization"));
    }
}
