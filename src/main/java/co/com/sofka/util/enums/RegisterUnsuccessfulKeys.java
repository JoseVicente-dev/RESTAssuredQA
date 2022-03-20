package co.com.sofka.util.enums;

public enum RegisterUnsuccessfulKeys {

    EMAIL("[email]");

    private final String value;

    public String getValue() {
        return value;
    }

    RegisterUnsuccessfulKeys(String value) {
        this.value = value;
    }

}
