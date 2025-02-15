class lc1352{
  int n;
  int[] mem;
  int z;
  int[] prefix;

  public lc1352() {
    this.n = 0;
    this.mem = new int[40000];
    this.z = -1;
    this.prefix = new int[40000];
  }

  public void add(int num) {
    if (num==0){
      this.z = this.n;
      this.n++;
      return;
    }
    if (this.n == 0)
      this.prefix[n] = num;
    else{
      this.prefix[n] = this.prefix[n-1] == 0 ? num : this.prefix[n-1]*num;
    }
    this.mem[this.n++] = num;
  }

  public int getProduct(int k) {
    if (this.n - k <= this.z)
      return 0;
    if (n-k-1 < 0 || this.prefix[n-k-1] == 0)
      return this.prefix[n-1];
    return this.prefix[n-1] / this.prefix[n-k-1];
  }

  public static void main(String[] args){
    lc1352 a = new lc1352();
    a.add(3);
    a.add(0);
    a.add(2);
    a.add(5);
    a.add(4);
    System.out.println(a.getProduct(2));
    System.out.println(a.getProduct(3));
    System.out.println(a.getProduct(4));
    a.add(8);
    System.out.println(a.getProduct(2));
  }
}
