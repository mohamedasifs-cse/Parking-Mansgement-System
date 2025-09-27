class ParkingSlot {
    int slotId;
    Vehicle parkedVehicle;

    ParkingSlot(int slotId) {
        this.slotId = slotId;
        this.parkedVehicle = null;
    }

    boolean isEmpty() {
        return parkedVehicle == null;
    }

    void park(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
    }

    void remove() {
        this.parkedVehicle = null;
    }
}
