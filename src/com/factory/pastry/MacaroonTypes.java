package com.factory.pastry;

public enum MacaroonTypes {
    VARIETY("Variety macaroon");

    private String macaroonName;

    MacaroonTypes(String macaroonName) {
        this.macaroonName = macaroonName;
    }

    @Override
    public String toString() {
        return macaroonName;
    }
}
