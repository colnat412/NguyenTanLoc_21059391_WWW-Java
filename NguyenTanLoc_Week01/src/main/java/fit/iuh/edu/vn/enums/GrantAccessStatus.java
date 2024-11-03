package fit.iuh.edu.vn.enums;

public enum GrantAccessStatus {
    ENABLE(1), DISABLE(0);

    private int value;

    GrantAccessStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
