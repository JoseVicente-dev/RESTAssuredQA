package co.com.sofka.util.enums;

public enum UpdateKeys {

    NAME("[name]"),
    JOB("[job]");

    private final String value;

    UpdateKeys(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
