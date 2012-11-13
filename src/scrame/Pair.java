package scrame;

import java.io.Serializable;

public class Pair<L, R> implements Serializable {
	public final L left; 
	public final R right; 
	public Pair(L left, R right) { 
		this.left = left; 
		this.right = right; 
	} 
}
