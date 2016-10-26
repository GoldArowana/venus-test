package cn.com.mx.simpletest.model;

public class Car {
		private Wheel wheel;
		private Sofa sofa;
		public Wheel getWheel() {
			return wheel;
		}
		public void setWheel(Wheel wheel) {
			this.wheel = wheel;
		}
		public Sofa getSofa() {
			return sofa;
		}
		public void setSofa(Sofa sofa) {
			this.sofa = sofa;
		}
		public Car() {
			super();
			this.wheel = new Wheel();
			this.sofa = new Sofa();
		}
		
		
	}
