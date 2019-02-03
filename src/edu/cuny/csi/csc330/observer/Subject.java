package edu.cuny.csi.csc330.observer;

public interface Subject {
	
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyAllObservers();
	
}
