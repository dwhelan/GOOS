package chapter2;

import java.util.ArrayList;
import java.util.List;

public class Train {

  private final List<Carriage> carriages = new ArrayList<Carriage>();
  private int percentReservedBarrier = 70;
  
  public void reserveSeats(ReservationRequest request) {
    for (Carriage carriage : carriages) {
      if (carriage.getSeats().getPercentReserved() < percentReservedBarrier) {
        request.reserveSeatsInCarriage(carriage);
        return;
      }
    }
    request.cannotFindSeats();
  }

  public void add(Carriage carriage) {
    carriages.add(carriage);
  }
}
