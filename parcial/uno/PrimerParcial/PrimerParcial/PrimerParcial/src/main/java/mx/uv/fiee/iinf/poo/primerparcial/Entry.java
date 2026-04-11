package mx.uv.fiee.iinf.poo.primerparcial;

public class Entry<K extends Comparable<K>, V> implements Comparable<Entry<K, V>> {
  private K key;
  private V value;

  public Entry(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return this.key;
  }

  public V getValue() {
    return this.value;
  }

  @Override
  public String toString() {
    return this.key + ": " + this.value;
  }
 
  @Override
  public int compareTo(Entry<K, V> other) {
    if (other == null) {
      throw new NullPointerException("El parámetro no puede ser nulo.");
    }

     return other.getKey().compareTo(this.getKey());  
  }
}
