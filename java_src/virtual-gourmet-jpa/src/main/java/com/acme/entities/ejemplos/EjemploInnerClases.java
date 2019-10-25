package com.acme.entities.ejemplos;

public class EjemploInnerClases {

	class Outer {

		private String name = "Outer";
		public String s = "cad";

		public class Inner {
			private String name = "Inner"; // shadowing
			protected String sInner = "sInner";

			protected void metodo() {
				//System.out.println("name - " + super.name); // cannot find symbol variable name
			}
		}

		public class Inner2 extends Inner {
			private String name = "Inner2"; // shadowing

			protected void metodo2() {
				System.out.println("name - " + super.name); // Imprime: name - Inner
				System.out.println("name - " + name); // Imprime: name - Inner2
				System.out.println("name - " + this.name); // Imprime: name - Inner2
				System.out.println("name - " + Outer.this.name); // Imprime: name – Outer
				// error: not an enclosing class: src.Outer.Inner:
				//System.out.println("name - " + Inner.this.name);
				// error: non-static variable name cannot be referenced from a static context:
				//System.out.println("name - " + Inner.name);

				System.out.println("name - " + this.sInner); // variable heredada.
				//System.out.println("name - " + this.s); // error: cannot find symbol variable s

			}
		}
	}

	public static void main(String... arg) {
		new EjemploInnerClases().new Outer().new Inner().metodo();
		new EjemploInnerClases().new Outer().new Inner2().metodo2();
	}
}
