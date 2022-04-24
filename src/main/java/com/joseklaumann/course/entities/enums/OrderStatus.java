package com.joseklaumann.course.entities.enums;

public enum OrderStatus {
	
	//Para eventuais manutencoes e melhor explicitar o valor
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	// O construtor do tipo enumerado e private
	private OrderStatus (int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	// Metodo estatico para converter valor numerico para tipo enumerado
	// Ele e estatico pq funciona sem precisar instanciar
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");		
	}

}
