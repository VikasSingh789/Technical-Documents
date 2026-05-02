package com.programs.java17.sealedClass;

public sealed class PaymentSealedClass permits CreditCardSealedClass, BankTransferSealedClass {

	void handlePayment(PaymentSealedClass paymentSealedClass) {
		System.out.println("PaymentSealedClass");
	}
}
