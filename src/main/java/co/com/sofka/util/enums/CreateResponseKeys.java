package co.com.sofka.util.enums;

public enum
CreateResponseKeys {

    NAME("name"),
    JOB("job"),
    ID("id"),
    CREATED_AT("createdAt");

    CreateResponseKeys(String value) {
        this.value = value;
    }

    private final String value;

    public String getValue() {
        return value;
    }
}
