package co.com.sofka.util.enums;

public enum RegisterKeys {

    EMAIL("[email]"),
    PASSWORD("[password]");

    private final String value;

    public String getValue() {
        return value;
    }

    RegisterKeys(String value) {
        this.value = value;
    }

}
