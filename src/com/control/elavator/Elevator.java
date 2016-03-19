package com.control.elavator;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator implements IElevatorFactory {
	private Integer currentFloor;
	private Queue<Integer> destinationFloors;

	public Elevator(Integer currentFloor) {
		this.currentFloor = currentFloor;
		this.destinationFloors = new LinkedList<Integer>();
	}

	public int nextDestionation() {
		return this.destinationFloors.peek();
	}

	public int currentFloor() {
		return this.currentFloor;
	}

	public void popDestination() {
		this.destinationFloors.poll();
	}

	@Override
	public void addNewDestinatoin(Integer destination) {
		this.destinationFloors.offer(destination);
	}

	@Override
	public void moveUp() {
		currentFloor++;
	}

	@Override
	public void moveDown() {
		currentFloor--;
	}

	@Override
	public ElevatorDirection direction() {
		if (destinationFloors.size() > 0) {
			if (currentFloor < destinationFloors.peek()) {
				return ElevatorDirection.ELEVATOR_UP;
			} else if (currentFloor > destinationFloors.peek()) {
				return ElevatorDirection.ELEVATOR_DOWN;
			}
		}
		return ElevatorDirection.ELEVATOR_HOLD;
	}

	@Override
	public ElevatorStatus status() {
		return (destinationFloors.size() > 0) ? ElevatorStatus.ELEVATOR_OCCUPIED : ElevatorStatus.ELEVATOR_EMPTY;
	}
}