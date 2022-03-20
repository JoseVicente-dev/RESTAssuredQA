package co.com.sofka.util.enums;

public enum RegisterKeys {
    NAME("[name]"),
    JOB("[job]");

    private final String value;

    RegisterKeys(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
