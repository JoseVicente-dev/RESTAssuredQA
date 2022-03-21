package co.com.sofka.util.enums;

public enum UpdateResponseKeys {
    NAME("name"),
    JOB("job"),
    UPDATED_AT("updatedAt");

    private final String value;

    UpdateResponseKeys(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
