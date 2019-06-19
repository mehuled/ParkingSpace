package com.company;

import java.util.Comparator;

public class SlotComparator implements Comparator<Slot>{

    public int compare(Slot slot1, Slot slot2) {
        if (slot1.getDistance() < slot2.getDistance())
            return -1;
        else if (slot1.getDistance() > slot2.getDistance())
            return 1;
        return 0;
    }

}
