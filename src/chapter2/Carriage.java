package chapter2;

public class Carriage {

  private SeatList seatList;
  
  public Carriage(int seats) {
    seatList = new SeatList(seats);
  }

  public SeatList getSeats() {
    return seatList;
  }

  public void reserveSeats(int numberOfSeats) {
    seatList.reserve(numberOfSeats);
  }
}
