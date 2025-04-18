package com.crusloadoutrandomizer;

public enum ImageGroup {
    ARMS, BORDERS, CHEST, HEAD, LEGS, WEAPONS, MISSIONS, PUNISHMENT, CHAOS;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
