package homework;


import java.util.*;

public class CustomerService {

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны
    private final NavigableMap<Customer, String> navigableMap = new TreeMap<>(Comparator.comparing(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        Map.Entry<Customer, String> customerStringEntry = navigableMap.firstEntry();
        return Optional.ofNullable(customerStringEntry)
                .map(c -> new AbstractMap.SimpleEntry<>(
                        new Customer(c.getKey()), c.getValue()))
                .orElse(null);
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        return Optional.ofNullable(navigableMap.higherEntry(customer))
                .map(c -> new AbstractMap.SimpleEntry<>(
                        new Customer(c.getKey()), c.getValue()))
                .orElse(null);
    }

    public void add(Customer customer, String data) {
        navigableMap.put(customer, data);
    }
}
