package hr.tvz.raic.hardwareapp.enums;

public enum HardwareTypeConst {
    CPU("Central processing unit"),
    GPU("Graphical processing unit"),
    MBO("Motherboard"),
    RAM("Random access memory"),
    STORAGE("Storage"),
    OTHER("Other");

    private final String type;

    HardwareTypeConst(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
