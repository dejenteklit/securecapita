package com.dejen.securecapita.enumeration;

public enum VerificationType {
    ACCOUNT("ACCOUNT"),
    PASSWORD("PASSWORD");

    private final  String type;
    VerificationType(final String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
}
