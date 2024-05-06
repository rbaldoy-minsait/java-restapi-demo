package org.minsait.service.utils;

import org.minsait.model.Price;

import java.util.List;

public class PriceUtils {

    private static final int INIT_PRIORITY = -1;

    public static Price getMostPriorityPrice(List<Price> priceList) {
        Price highestPriorityPrice = null;
        int highestPriority = INIT_PRIORITY;
        int currentPriority;
        for(Price price: priceList) {
            currentPriority = price.getPriority();
            if (currentPriority > highestPriority) {
                highestPriority = currentPriority;
                highestPriorityPrice = price;
            }
        }
        return highestPriorityPrice;
    }
}
