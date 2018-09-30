package algorithm.test;

public class TestConstructor {
	public static class t {
		t(int t) {
		};
	}

	public class h {
		h(int h) {
		};
	}

	public static void main(String[] args) {
		TestConstructor tt = new TestConstructor();
		t g = new TestConstructor.t(1);
		h gg = tt.new h(1);
	}
}
