class Vehicle {
    String vehicleNumber;
    String ownerName;
    String vehicleType;

    Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
        this.vehicleNumber = vehicleNumber.trim();
        this.ownerName = ownerName.trim();
        this.vehicleType = vehicleType.trim();
    }

    @Override
    public String toString() {
        return vehicleType + " " + vehicleNumber + " (" + ownerName + ")";
    }
}
