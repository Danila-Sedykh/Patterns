package org.example.observer;

public class Face implements Subject{
    private Eye leftEye;
    private Eye rightEye;
    private Nose nose;
    private Mouth mouth;


    @Override
    public void registerObserver(Observer observer) {
        if (observer instanceof Eye) {
            if (leftEye == null) {
                leftEye = (Eye) observer;
            } else if (rightEye == null) {
                rightEye = (Eye) observer;
            } else {
                System.out.println("Both eyes are already registered.");
            }
        } else if (observer instanceof Nose) {
            if (nose == null) {
                nose = (Nose) observer;
            } else {
                System.out.println("Nose is already registered.");
            }
        } else if (observer instanceof Mouth) {
            if (mouth == null) {
                mouth = (Mouth) observer;
            } else {
                System.out.println("Mouth is already registered.");
            }
        } else {
            System.out.println("Unknown observer type.");
        }
    }

    @Override
    public void notifyObservers(Observer observer) {
        observer.update();
    }
}
