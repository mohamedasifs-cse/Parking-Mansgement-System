class ParkingLot {
    ParkingSlot[] carSlots, bikeSlots, truckSlots;

    ParkingLot(int slotsPerType) {
        carSlots = new ParkingSlot[slotsPerType];
        bikeSlots = new ParkingSlot[slotsPerType];
        truckSlots = new ParkingSlot[slotsPerType];
        for (int i = 0; i < slotsPerType; i++) {
            carSlots[i] = new ParkingSlot(i + 1);
            bikeSlots[i] = new ParkingSlot(i + 1);
            truckSlots[i] = new ParkingSlot(i + 1);
        }
    }

    private ParkingSlot[] getSlots(String type) {
        switch (type.toLowerCase()) {
            case "car": return carSlots;
            case "bike": return bikeSlots;
            case "truck": return truckSlots;
            default: System.out.println("Invalid vehicle type!"); return null;
        }
    }

    boolean isDuplicate(String num) {
        num = num.trim().toLowerCase();
        return checkSlots(num, carSlots) || checkSlots(num, bikeSlots) || checkSlots(num, truckSlots);
    }

    private boolean checkSlots(String num, ParkingSlot[] slots) {
        for (ParkingSlot s : slots)
            if (!s.isEmpty() && s.parkedVehicle.vehicleNumber.trim().equalsIgnoreCase(num))
                return true;
        return false;
    }

    void parkVehicle(Vehicle v) {
        v.vehicleNumber = v.vehicleNumber.trim();
        v.vehicleType = v.vehicleType.trim();
        if (isDuplicate(v.vehicleNumber)) {
            System.out.println(" " + v.vehicleNumber + " already parked!");
            return;
        }
        ParkingSlot[] slots = getSlots(v.vehicleType);
        if (slots == null) return;
        for (ParkingSlot s : slots) {
            if (s.isEmpty()) { s.park(v); System.out.println(" Parked " + v + " in Slot " + s.slotId); return; }
        }
        System.out.println("❌ No free slots for " + v.vehicleType + "s!");
    }

    void removeVehicle(String num) {
        num = num.trim();
        if (removeFromSlots(num, carSlots) || removeFromSlots(num, bikeSlots) || removeFromSlots(num, truckSlots))
            return;
        System.out.println(" Vehicle not found!");
    }

    private boolean removeFromSlots(String num, ParkingSlot[] slots) {
        for (ParkingSlot s : slots)
            if (!s.isEmpty() && s.parkedVehicle.vehicleNumber.trim().equalsIgnoreCase(num)) {
                System.out.println(" Removed " + s.parkedVehicle + " from Slot " + s.slotId);
                s.remove(); return true;
            }
        return false;
    }

    void showAvailableSlots(String type) {
        ParkingSlot[] slots = getSlots(type);
        if (slots == null) return;
        System.out.print("Available " + type + " slots: ");
        boolean free = false;
        for (ParkingSlot s : slots) if (s.isEmpty()) { System.out.print(s.slotId + " "); free = true; }
        if (!free) System.out.print("None");
        System.out.println();
    }

    void showStatus() {
        System.out.println("\n--- Car Slots ---"); printSlots(carSlots);
        System.out.println("\n--- Bike Slots ---"); printSlots(bikeSlots);
        System.out.println("\n--- Truck Slots ---"); printSlots(truckSlots);
    }

    private void printSlots(ParkingSlot[] slots) {
        for (ParkingSlot s : slots) System.out.println("Slot " + s.slotId + ": " + (s.isEmpty() ? "EMPTY" : s.parkedVehicle));
    }
}
