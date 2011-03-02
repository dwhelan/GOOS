package chapter2;

public class SeatList {

  private int totalSeats;
  private int reservedSeats;
  
  public SeatList(int seats) {
    totalSeats = seats;
  }

  public int getPercentReserved() {
    return 100 * reservedSeats / totalSeats;
  }

  public void reserve(int numberOfSeats) {
    reservedSeats += numberOfSeats;
  }
}
