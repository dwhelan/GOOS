package chapter2_with_mocks;

public interface ReservationRequest {

  public void reserveSeatsInCarriage(Carriage carriage);

  public void cannotFindSeats();
}