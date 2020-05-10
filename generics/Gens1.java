
import java.util.Iterator;
import java.util.Random;
import java.util.ArrayList;

/** java generics oreilly book, 1.3 foreach */

/*
interface Iterable<E> {
  public Iterator<E> iterator();
}

interface Iterator<E> {
  public boolean hasNext();
  public E next();
  public void remove();
}
*/

/* The code below is a tweaked version of code on SO.com: https://stackoverflow.com/questions/5849154/can-we-write-our-own-iterator-in-java */

class SOList<Type> implements Iterable<Type> {

    private Type[] arrayList;
    private int currentSize;
    private ArrayList<Type> Xs = new ArrayList<Type>();

    public SOList(Type[] newArray) {
        this.arrayList = newArray;
        this.currentSize = arrayList.length;
        this.copyVals();
    }

    private void copyVals() {
      for (int i = 0; i < currentSize; i++) {
        Type v = arrayList[i];
        Xs.add( v );
      }
    }

    @Override
    public Iterator<Type> iterator() {
        Iterator<Type> it = new Iterator<Type>() {

            private int currentIndex = 0;
            private int[] ys = new int[ currentSize ];
            private Random r = new Random();
            private int randomLoc;

            @Override
            public boolean hasNext() {
                //return currentIndex < currentSize && arrayList[currentIndex] != null;
                return Xs.size() > 0;
            }

            @Override
            public Type next() {
                //randomLoc = Math.floorMod( r.nextInt(), currentSize);
            //    ++currentIndex;
                //return arrayList[ randomLoc ] ; // arrayList[currentIndex++];
                int sz = Xs.size();
                randomLoc = Math.floorMod( r.nextInt(), sz );
                Type val = Xs.remove(randomLoc);
                return val;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }



        };
        return it;
    }
}

class RandomInts { // implements Iterable<Integer> {
  private int size;

  public RandomInts(int n) { size = n; }


}


//class RandomlyIterableList implements Iterable<Integer> {
//  List<Integer>  }

public  class Gens1 {
  public static void main(String[] args) {
    // create an array of type Integer
    Integer[] numbers = new Integer[]{1,2,3,4,5,6,7,8,9};

    // create your list and hold the values.
    SOList<Integer> stackOverflowList = new SOList<Integer>(numbers);

    // Since our class SOList is an instance of Iterable, then we can use it on a foreach loop
    for(Integer num : stackOverflowList) {
        System.out.println(num);
    }

    // creating an array of Strings
    String[] languages = new String[]{"first", "C", "C++", "Java", "Python", "Scala", "last"};

    // create your list and hold the values using the same list implementation.
    SOList<String> languagesList = new SOList<String>(languages);

    System.out.println("");
    // Since our class SOList is an instance of Iterable, then we can use it on a foreach loop
    for(String lang : languagesList) {
        System.out.println(lang);
    }
}
/*
  public static void main(String[] args) {
    RandomInts rs = new RandomInts(3);

    Integer[] nums = new Integer[]{1,2,3,4,5};
    SOList<Integer> = ;

  }
  */


}
