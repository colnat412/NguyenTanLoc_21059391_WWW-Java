package fit.iuh.edu.vn.enums;

public enum Status {
    ACTIVE(1), DEACTIVED(0), DELETED(-1);

    private int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
