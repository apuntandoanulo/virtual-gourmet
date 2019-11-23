package com.acme.entities.ejemplos.apache;

import org.apache.commons.lang3.RandomStringUtils;

public class MuestraApacheLang {

	public static void main(String[] args) {
		System.out.println(RandomStringUtils.random(8, true, true));
		System.out.println(RandomStringUtils.random(14, true, false));
	}
}
