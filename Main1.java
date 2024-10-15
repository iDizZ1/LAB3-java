public class Main1 {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();

        hashTable.put("apple", 1);
        hashTable.put("banana", 2);
        hashTable.put("orange", 3);



        System.out.println("Размер: " + hashTable.size());
        System.out.println(hashTable.get("banana"));

        hashTable.remove("banana");
        System.out.println(hashTable.get("banana"));

        System.out.println("Пусто: " + hashTable.isEmpty());


    }
}