package chapter2_with_mocks;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class TrainTest {

  private final Train train = new Train();
  private final Mockery context = new JUnit4Mockery();
  private final Carriage carriage1 = context.mock(Carriage.class, "carriage1");
  private final Carriage carriage2 = context.mock(Carriage.class, "carriage2");
  private final ReservationRequest request = context.mock(ReservationRequest.class);
  
  @Test
  public void should_not_be_able_to_reserve_seats_for_a_train_with_no_carriages() {
    context.checking(new Expectations() {{
      oneOf(request).cannotFindSeats();
    }});
    
    train.reserveSeats(request);    
  }

  @Test
  public void should_be_able_to_reserve_seats_for_a_train_with_one_carriage_with_available_seats() {
    train.add(carriage1);
    
    context.checking(new Expectations() {{
      oneOf(carriage1).hasSeatsAvailableWithin(70); will(returnValue(true));
      oneOf(request).reserveSeatsInCarriage(carriage1);
    }});

    train.reserveSeats(request);
  }

  @Test
  public void should_not_be_able_to_reserve_seats_for_a_train_with_one_carriage_with_no_available_seats() {
    train.add(carriage1);
    
    context.checking(new Expectations() {{
      oneOf(carriage1).hasSeatsAvailableWithin(70); will(returnValue(false));
      oneOf(request).cannotFindSeats();
    }});

    train.reserveSeats(request);
  }

  @Test
  public void should_be_able_to_reserve_seats_for_a_train_with_a_second_carriage_with_available_seats() {
    train.add(carriage1);
    train.add(carriage2);
    
    context.checking(new Expectations() {{
      oneOf(carriage1).hasSeatsAvailableWithin(70); will(returnValue(false));
      oneOf(carriage2).hasSeatsAvailableWithin(70); will(returnValue(true));
      oneOf(request).reserveSeatsInCarriage(carriage2);
    }});

    train.reserveSeats(request);
  }

  @Test
  public void should_not_be_able_to_reserve_seats_for_a_train_with_two_carriages_with_no_available_seats() {
    train.add(carriage1);
    train.add(carriage2);
    
    context.checking(new Expectations() {{
      oneOf(carriage1).hasSeatsAvailableWithin(70); will(returnValue(false));
      oneOf(carriage2).hasSeatsAvailableWithin(70); will(returnValue(false));
      oneOf(request).cannotFindSeats();
    }});

    train.reserveSeats(request);
  }
}