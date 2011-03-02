package chapter2_with_mocks;

public interface Carriage {

  public void reserveSeats(int numberOfSeats);

  public boolean hasSeatsAvailableWithin(int reservedBarrier);
}