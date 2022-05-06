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

    public static HardwareTypeConst getTypeFromString(String typeString) {
        switch (typeString.toUpperCase()) {
            case "CPU" -> {
                return HardwareTypeConst.CPU;
            }
            case "GPU" -> {
                return HardwareTypeConst.GPU;
            }
            case "MBO" -> {
                return HardwareTypeConst.MBO;
            }
            case "RAM" -> {
                return HardwareTypeConst.RAM;
            }
            case "STORAGE" -> {
                return HardwareTypeConst.STORAGE;
            }
            case "OTHER" -> {
                return HardwareTypeConst.OTHER;
            }
            default -> {
                return null;
            }
        }
    }

    public boolean isIn(HardwareTypeConst... types) {
        for(HardwareTypeConst type : types) {
            if (this.equals(type)) {
                return true;
            }
        }
        return false;
    }
}
