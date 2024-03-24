package com.pragma.assets.common;

import com.pragma.assets.common.util.Constants;

public record ErrorMessage(String message, String path, String type) {

    public ErrorMessage(String message, String path, String type) {
        this.message = message;
        this.path = path;
        String firstPart = type.substring(type.lastIndexOf(Constants.PERIOD) + Constants.ONE);
        this.type = firstPart.substring(Constants.ZERO, firstPart.indexOf(Constants.COLON));
    }

}