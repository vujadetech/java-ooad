

class NumAdapter {
  public static double num2Dub(Number n) { return (double) n; }
  public static Number dub2Num(double d) { return (Number) d; }
}

interface Function {
  public  abstract  Number eval(Number x);
}

class Square implements Function {
  public  Number eval(Number n) {
    double x = NumAdapter.num2Dub(n);
    return NumAdapter.dub2Num(x * x);
  }
}

 class Cube implements Function  {
  public Number eval(Number n) {
    return Math.pow( NumAdapter.num2Dub( n ), 3);
  }
}

public  class FunctionsNumber {
  public static void plot(Function f, double a, double b, int n)
  {
    double[] y = new double[n+1];
    double delta = (b - a) / n;
    for (int i = 0; i <= n; i++)
      y[i] =  NumAdapter.num2Dub( f.eval( NumAdapter.dub2Num(a + delta*i) ) );  // (Number) (a + delta*i) );
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
