package co.com.sofka.util.enums;

public enum RegisterUnsuccessfulResponseKeys {

    ERROR("error");

    RegisterUnsuccessfulResponseKeys(String value) {
        this.value = value;
    }

    private final String value;

    public String getValue() {
        return value;
    }
}
