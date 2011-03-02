package chapter2;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TrainTest {

  private final Train train = new Train();
  private final ReservationRequest request = new ReservationRequest();
  private Carriage carriage1 = new Carriage(100);
  private Carriage carriage2 = new Carriage(100);

  @Test
  public void should_not_be_able_to_reserve_seats_for_a_train_with_no_carriages() {
    train.reserveSeats(request);    
    assertThat(request.isSuccessful(), is(equalTo(false)));    
  }

  @Test
  public void should_be_able_to_reserve_seats_for_a_train_with_one_carriage_with_available_seats() {
    carriage1.reserveSeats(69);
    train.add(carriage1);    
    train.reserveSeats(request);    
    assertThat(request.isSuccessful(), is(equalTo(true)));    
  }

  @Test
  public void should_not_be_able_to_reserve_seats_for_a_train_with_one_carriage_with_no_available_seats() {
    carriage1.reserveSeats(70);
    train.add(carriage1);    
    train.reserveSeats(request);    
    assertThat(request.isSuccessful(), is(equalTo(false)));    
  }

  @Test
  public void should_be_able_to_reserve_seats_for_a_train_with_a_second_carriage_with_available_seats() {
    carriage1.reserveSeats(70);
    train.add(carriage1);    

    carriage2.reserveSeats(69);
    train.add(carriage2);    

    train.reserveSeats(request);    
    assertThat(request.isSuccessful(), is(equalTo(true)));    
  }

  @Test
  public void should_not_be_able_to_reserve_seats_for_a_train_with_two_carriages_with_no_available_seats() {
    carriage1.reserveSeats(70);
    train.add(carriage1);    

    carriage2.reserveSeats(69);
    train.add(carriage2);    

    train.reserveSeats(request);    
    assertThat(request.isSuccessful(), is(equalTo(true)));    
  }
}