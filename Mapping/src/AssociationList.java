import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class AssociationList<K,V> implements Map<K,V>{
		private LinkedList <Pair> pairsList;
		
	public class Pair<K,V>{
		private K key;
		private V value;
		public Pair(K key, V value){
			this.key = key;
			this.value = value;
		}
		public K getFst(){
			return this.key;
		}
		public V getSnd(){
			return this.value;
		}
	}
	
	public AssociationList(){
		pairsList = new LinkedList();
	}
	
	@Override
	public void put(K k, V v) {
		if(pairsList.isEmpty()){
			pairsList.add(new Pair(k,v));
		}
		else{
			Iterator <Pair> pairIt = pairsList.iterator();
			while(pairIt.hasNext()){
				if(pairIt.next().getFst() == k){
					pairIt.next().value = v;
				}
			}
		}
	}

	@Override
	public V remove(Object k) {
		Iterator <Pair> pairIt = pairsList.iterator();
		while(pairIt.hasNext()){
			Pair curr = pairIt.next();
			if(curr.getFst() == k){
				Object returned = curr.getSnd();
				pairsList.remove(curr);
				return (V) returned;
			}
		}
		throw new IllegalArgumentException();
	}


	@Override
	public int size() {
		return pairsList.size();
	}

	@Override
	public boolean containsKey(Object k) {
		Iterator <Pair> pairIt = pairsList.iterator();
		while(pairIt.hasNext()){
			Pair curr = pairIt.next();
			if(curr.getSnd() == k){
				return true;
			}
		}
		return false;
	}

	@Override
	public Object get(Object k) {
		Iterator <Pair> pairIt = pairsList.iterator();
		while(pairIt.hasNext()){
			Pair curr = pairIt.next();
			if(curr.getSnd() == k){
				return curr;
			}
		}
		throw new IllegalArgumentException();
	}

	@Override
	public LinkedList <K> keys() {
		LinkedList ret = new LinkedList();
		Iterator <Pair> pairIt = pairsList.iterator();
		Pair curr = pairIt.next();
		while(pairIt.hasNext()){
			ret.add(curr.getFst());
			}
			return ret;
		}

	@Override
	public LinkedList values() {
		LinkedList ret = new LinkedList();
		Iterator <Pair> pairIt = pairsList.iterator();
		Pair curr = pairIt.next();
		while(pairIt.hasNext()){
			ret.add(curr.getSnd());
			}
			return ret;
	}

}
