package dataStructure.enumerate;

public enum Enum {
    RED(1, "红色"),
    GREEN(2, "绿色"),
    BLUE(3, "蓝色");
    private int code;
    private String color;

    Enum(int code, String color) {
        this.code = code;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
