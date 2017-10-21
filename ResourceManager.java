
public abstract class ResourceManager {

	protected int count = 1;
	
	public void addReference() {
		count++;
	}
	
	public boolean removeRefernece() {
		count--;
		return count == 0;
	}
}
