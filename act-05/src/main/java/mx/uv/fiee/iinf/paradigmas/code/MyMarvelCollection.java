package mx.uv.fiee.iinf.paradigmas.code;

// definir comportamiento de colección
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyMarvelCollection implements Iterable<Film> {

  private Film[] films;
  private int count;

  public MyMarvelCollection(Film[] vector) {
    this.films = vector;
  }

  @Override
  public Iterator<Film> iterator() {
    return new MarvelIterator();
  }
  
  public void add(Film object) {
    if(count < films.length) {
      this.films[count++] = object;
    }
  }

  class MarvelIterator implements Iterator<Film> {
    int index = 0;

    @Override
    public boolean hasNext() {
      return this.index < count;
    }

    @Override
    public Film next() {
      if(!this.hasNext()) {
        throw new NoSuchElementException();
      }
      return films[index++];
    }
  }
}
