package co.com.sofka.util.enums;

public enum
CreateResponseKeys {

    NAME("name"),
    JOB("job"),
    ID("id"),
    CREATED_AT("createdAt");

    private final String value;

    CreateResponseKeys(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
