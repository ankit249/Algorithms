package com.control.elavator;

public interface IElevatorControlSystem {
	public void pickUp(Integer pickUpFloor);

	public void destination(Integer elevatorId, Integer destinationFloor);

	public void step();
}

