package mcmillan.jeff.networker.math;

public class Vec2Int {
	public int x,y;
	public Vec2Int() {
		x = 0;
		y = 0;
	}
	
	public Vec2Int(int _x, int _y) {
		x = _x;
		y = _y;
	}
	
	public Vec2Int add(int _x, int _y) {
		x += _x;
		y += _y;
		return this;
	}
	
	public Vec2Int add(Vec2Int addend) {
		x += addend.x;
		y += addend.y;
		return this;
	}
	
	public Vec2Int sub(int _x, int _y) {
		x -= _x;
		y -= _y;
		return this;
	}
	
	public Vec2Int sub(Vec2Int subtrahend) {
		x -= subtrahend.x;
		y -= subtrahend.y;
		return this;
	}

	public Vec2Int mult(int _x, int _y) {
		x *= _x;
		y *= _y;
		return this;
	}
	
	public Vec2Int mult(Vec2Int factor) {
		x *= factor.x;
		y *= factor.y;
		return this;
	}

	public Vec2Int div(int _x, int _y) {
		x /= _x;
		y /= _y;
		return this;
	}
	
	public Vec2Int div(Vec2Int divisor) {
		x /= divisor.x;
		y /= divisor.y;
		return this;
	}

	// Find manhatten distance
	public int manDist() {
		return Math.abs(x) + Math.abs(y);
	}
}
