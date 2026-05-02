package com.programs.java17.sealedClass;

public non-sealed class CreditCardSealedClass extends PaymentSealedClass {
	
	@Override
	void handlePayment(PaymentSealedClass paymentSealedClass) {
		System.out.println("CreditCardSealedClass");
	}

}
