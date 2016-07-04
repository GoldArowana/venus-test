package cn.com.mx.model;

public class Sofa {
		String color;
		int count;
		String texture;
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public String getTexture() {
			return texture;
		}
		public void setTexture(String texture) {
			this.texture = texture;
		}
		public Sofa() {
			super();
			this.color = "white";
			this.count = 4;
			this.texture = "fur";
		}
		
		
	}
