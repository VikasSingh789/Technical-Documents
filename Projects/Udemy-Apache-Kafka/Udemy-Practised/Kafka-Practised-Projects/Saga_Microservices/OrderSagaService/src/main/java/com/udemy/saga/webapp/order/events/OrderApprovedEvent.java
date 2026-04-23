package com.udemy.saga.webapp.order.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderApprovedEvent {
    private Long orderId;
}
