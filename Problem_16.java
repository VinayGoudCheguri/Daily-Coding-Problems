
public class Problem_16 {

	public class log {
		private int N;
		private int[] orderid;
	    private int currIdx;
		public log(int n) {
			this.N = n;
			this.orderid = new int[n];
			this.currIdx =0;
		}
		//records last N  orders
	    public void record(int orderId) {
	        orderid[currIdx] = orderId;
	        currIdx = (currIdx + 1) % N;
	    }
	    // returns ith  last order id
	    public int getLast(int i) {
	        return orderid[(currIdx - i + N) % N];
	    }
	}
}
