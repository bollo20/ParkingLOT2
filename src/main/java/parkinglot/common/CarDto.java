package parkinglot.common;

public class CarDto {

    private Long id;
    private String licensePlate;
    private String parkingSpot;
    private String ownerName;

    // Constructor cu toate câmpurile
    public CarDto(Long id, String licensePlate, String parkingSpot, String ownerName) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.parkingSpot = parkingSpot;
        this.ownerName = ownerName;
    }

    // Doar GETTERS (nu setters!)
    public Long getId() {
        return id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getParkingSpot() {
        return parkingSpot;
    }

    public String getOwnerName() {
        return ownerName;
    }
}
