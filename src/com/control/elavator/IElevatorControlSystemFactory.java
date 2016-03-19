package com.control.elavator;

public interface IElevatorControlSystemFactory {
	public void pickUp(Integer pickUpFloor);

	public void destination(Integer elevatorId, Integer destinationFloor);

	public void step();
}

