

interface Function {
  public  abstract  double eval(double x);
}


class Square implements Function {
  public  double eval(double x) {
    return x*x;
  }
}

 class Cube implements Function  {
  public double eval(double x) {
    return Math.pow(x, 3);
  }
}


public  class Functions {

  public static void plot(Function f, double a, double b, int n)
  {
    double[] y = new double[n+1];
    double delta = (b - a) / n;
    for (int i = 0; i <= n; i++)
      y[i] = f.eval(a + delta*i);
    StdStats.plotPoints(y);
    StdStats.plotLines(y);
  }

  public static void main(String[] args) {
    Function sq = new Square();
    Function cube = new Cube();

    Cube c = new Cube();
  //  Cube x = new Square(); // wont compile

    //plot(fSq, 0, 1.0, 10);
    //plot( X -> cube.eval(X) , -1, 1.0, 10);
    plot(c::eval, -1.0, 1.0, 10); // still works, but Function is better as the type
    plot(sq, -1.0, 1.0, 10); // surprisingly, works without sq::eval
    System.out.println("sq class = " + sq.getClass());
    System.out.println("cube class = " + cube.getClass());
  }
}
