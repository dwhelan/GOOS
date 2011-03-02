package chapter2;

public class ReservationRequest {

  private Carriage carriage;
  
  public void reserveSeatsInCarriage(Carriage carriage) {
    this.carriage = carriage;
  }

  public void cannotFindSeats() {
  }

  public boolean isSuccessful() {
    return carriage != null;
  }
}
