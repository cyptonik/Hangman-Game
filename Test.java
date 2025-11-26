import java.util.*;

// интерфейс Collection - .addAll(Collection<? extends T> c) 
// класс Collections - .addAll(Collection<? super T> c, T... elements) - принимает не только обьект Collection

// Для быстрого и удобного добавления нескольких элементов в коллекцию, методы Collections.addAll() (с его поддержкой varargs) или создание списка через Arrays.asList() (также с varargs) являются более удобными и "гибкими", чем метод экземпляра collectionInstance.addAll(), который строго требует, чтобы все добавляемые элементы уже были частью другой коллекции.

public class Test {
	public static void main(String[] args) {
		Collection<Integer> collection =
			new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		Integer[] moreInts = {6, 7, 8, 9, 10};
		collection.addAll(Arrays.asList(moreInts));

		Collections.addAll(collection, 11, 12, 13, 14, 15);
		Collections.addAll(collection, moreInts);

		List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
		list.set(1, 99);
	}
}
