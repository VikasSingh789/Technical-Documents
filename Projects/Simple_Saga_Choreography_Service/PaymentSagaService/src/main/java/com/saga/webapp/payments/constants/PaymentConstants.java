package com.saga.webapp.payments.constants;

public class PaymentConstants {

	public static final String STATUS = "Created";
	public static final String FAILED = "Failed";
	public static final String PAYMENT_CREATED = "PAYMENT_CREATED";
	public static final String KAFKA_STATUS_ORDER_CREATED = "ORDER_CREATED";
	public static final String KAFKA_STATUS_ORDER_REVERSED = "ORDER_REVERSED";
	public static final String KAFKA_TOPIC_NEW_ORDER = "new-orders";
	public static final String KAFKA_TOPIC_NEW_PAYMENT = "new-payments";

	public static final String KAFKA_ORDER_GROUP_ID = "orders-group";
	public static final String KAFKA_PAYMENT_GROUP_ID = "payments-group";

	public static final String KAFKA_TOPIC_REVERSED_ORDER = "reversed-orders";
	public static final String KAFKA_TOPIC_REVERSED_PAYMENTS = "reversed-payments";

	public static final String PAYMENT_SUCCESS = "success";

}
