package com.java.algorithm.mythreadtest;

public class NoRaceCondition {

    public int nextSequence(int sequence) {
        if (sequence >= 999) {
            sequence = 0;
        } else {
            sequence++;
        }
        return sequence;
    }
}
