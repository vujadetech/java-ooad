/** from beginnersbook.com, java-interface */

interface Inf1 {
  public void  method1();
}


interface Inf2 extends Inf1 {
  public void  method2();
}

public  class Demo2 implements Inf2  {
  public  void method1() {
    System.out.println("method1");
  }

  public  void method2() {
    System.out.println("method2");
  }

  public static void main(String[] args) {
    Inf2 obj = new Demo2();
    obj.method2();
    obj.method1();

    Inf1 o1 = new Demo2();
    o1.method1();
  //  o1.method2();

    Demo2 d = new Demo2();
    d.method1();
    d.method2();

  }
}
