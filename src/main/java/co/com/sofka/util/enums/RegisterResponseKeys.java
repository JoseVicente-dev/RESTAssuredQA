package co.com.sofka.util.enums;

public enum RegisterResponseKeys {

    ID("id"),
    TOKEN("token");

    RegisterResponseKeys(String value) {
        this.value = value;
    }

    private final String value;

    public String getValue() {
        return value;
    }
}
