package cn.com.mx.simpletest.hashmap;

public class Key implements Comparable<Key>{
	
	private int value;
	Key(int value) {
		this.value = value;
	}

	@Override
	public int compareTo(Key o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.value, o.value);
	}
	@Override
	public int hashCode() {
		/*final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;*/
		return value;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Key other = (Key) obj;
		if (value != other.value)
			return false;
		return true;
	}

	
	
}
