package com.codestates.homework;

import com.codestates.helper.RandomPasswordGenerator;
import com.codestates.helper.StampCalculator;
import com.codestates.order.entity.Order;
import com.codestates.order.entity.OrderCoffee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StampCalculatorTest {
    @Test
    @DisplayName("실습1-1: 스탬프 카운트 계산 단위 테스트")
    public void calculateStampCountTest() {
        int nowCount = 5;
        int earned = 3;

        int actual = StampCalculator.calculateStampCount(nowCount, earned);
        int expected = 8;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("실습1-2: 주문 후 누적 스탬프 카운트 계산 단위 테스트")
    public void calculateEarnedStampCountTest(){
        Order order = new Order();
        OrderCoffee orderCoffee1 = new OrderCoffee();
        orderCoffee1.setQuantity(3);

        OrderCoffee orderCoffee2 = new OrderCoffee();
        orderCoffee2.setQuantity(5);

        order.setOrderCoffees(List.of(orderCoffee1, orderCoffee2));

        int expected = orderCoffee1.getQuantity() + orderCoffee2.getQuantity();
        int actual = StampCalculator.calculateEarnedStampCount(order);

        assertEquals(expected, actual);
    }
}
