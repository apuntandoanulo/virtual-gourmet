package com.acme.entities.ejemplos.inner;

public class Outer {
		
	private class Inner {
		public Inner() {
			System.out.println("Inner");
		}
		
		public void metodoInner() {
			System.out.println("NOTHING");
		}
	}

	public static void main(String... arg) {

		Outer.Inner o = new Outer().new Inner() { // Imprime Inner
			public void metodoInner() {
				System.out.println("metodoInner-Sub");
			}
		};
		o.metodoInner(); // Imprime metodoInner-Sub

		// Al declarar el objeto imprime Super
		Super obj = new Super() {}; // El ';' es obligatorio
		
		obj.metodo(); // Imprime metodoSuper

		Super obj2 = new Super() {
			public void metodo() {
				System.out.println("metodoSub");
			}
		};
		obj2.metodo(); // Imprime metodoSub
		
		Super obj3 = new Super() {
			public void metodo() {
				super.metodo();
			}

			public void metodo2() {
				System.out.println("metodo2");
			}
		};
		
		System.out.println(obj3.var); // Imprime var
		System.out.println(obj3.varStatic); // Imprime varStatic
		obj3.metodo(); // Imprime metodoSuper
		//obj3.metodo2(); // error - cannot find symbol method metodo2()

	}

}
