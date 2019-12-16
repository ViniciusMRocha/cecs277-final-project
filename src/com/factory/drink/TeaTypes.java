package com.factory.drink;

/**
 * Describes the different types of tea available for purchase at "Cha-cha-cha Time!"
 */
public enum TeaTypes {
    JASMINE_GREEN_TEA("Jasmine Green Tea"),
    SUMMER_MINT_TEA("Summer Mint Tea"),
    TARO_TEA("Taro Tea"),
    GREEN_TEA("Green Tea"),
    ROSE_GREEN_TEA("Rose Green Tea");

    private String teaName;

    /**
     * Defines a new enum by passing a tea name
     * @param teaName String
     */
    TeaTypes(String teaName) {
        this.teaName = teaName;
    }

    /**
     * Prints out the value of the enum to a String
     * @return String
     */
    @Override
    public String toString() {
        return teaName;
    }
}
