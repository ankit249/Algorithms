package com.control.elavator;

public interface IElevator {

	public void moveUp();

	public void moveDown();

	public void addNewDestinatoin(Integer destination);

	public ElevatorDirection direction();

	public ElevatorStatus status();

}
