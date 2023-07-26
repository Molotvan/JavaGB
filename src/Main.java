import java.util.*;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static Map<Integer, String> propertyList = new HashMap<>();
    public static void main(String[] args) {
        propertyList.put(1,"Название");
        propertyList.put(2,"Модель");
        propertyList.put(3,"Диагональ");
        propertyList.put(4,"Объём HDD");
        propertyList.put(5,"Оперативная память");
        propertyList.put(6,"Процессор");
        propertyList.put(7,"Цена, мин");
        propertyList.put(8,"Цена, макс");
        System.out.println(propertyList);
        allNotebooks.add(new Notebook(1, "ASUS", "123", 17, 1500, 32, "Intel" , 35000));
        allNotebooks.add(    new Notebook(2, "ASUS", "124", 17, 1000, 16, "Intel" , 30000));
        allNotebooks.add(    new Notebook(3, "Acer", "asd", 15, 1200, 32, "Radeon" , 39000));
        allNotebooks.add(    new Notebook(5, "Apple", "ipad6", 15, 3000, 64, "Apple" , 110000));
        allNotebooks.add(    new Notebook(4, "Apple", "ipad4", 17, 2000, 64, "Apple" , 90000));
        System.out.println(userResponse(allNotebooks, userRequest()));

    }
    public static Map<String, String> userRequest(){
        Map<String, String> request = new HashMap<>();
        System.out.println("Привет. Давай подберём ноутбук по параметрам. " +
                "Введи интересующие тебя значемия по очереди или вводи ноль, если параметр не важен. После ввода нажимай enter");
        Scanner scanner = new Scanner(System.in);
        for (String property : propertyList.values()){
            System.out.println(property +":" );
            String userProperty = scanner.nextLine();
            request.put(property, userProperty);
        }
        return request;
    }

//    public boolean isSuit(Notebook notebook, Map<String, String> request){
//        if (notebook.getName().equals(request.get("Название"))||(request.get("Название")).equals(" ")){
//            if(notebook.getModel().equals(request.get("Модель"))||(request.get("Модель")).equals(" ")){
//                if(notebook.getDiagonal()==Float.parseFloat(request.get("Диагональ"))||(request.get("Диагональ")).equals(" ")){
//                    if(notebook.getHddValue()>=Integer.parseInt(request.get("Объём HDD"))||(request.get("Объём HDD")).equals(" ")){
//                        if(notebook.getRamValue()>=Integer.parseInt(request.get("Оперативная память"))||(request.get("Оперативная память")).equals(" ")){
//                            if (notebook.getProcessor().equals(request.get("Процессор"))||(request.get("Процессор")).equals(" ")){
//                                if (((Integer.parseInt(request.get("Цена, мин")))<=notebook.getCost() && notebook.getCost()<=(Integer.parseInt(request.get("Цена, макс"))))||(request.get("Цена, мин").equals(" "))||(request.get("Цена, макс").equals(" "))){
//                                    return true;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return false;
//    }

    public static Set<Notebook> allNotebooks = new HashSet<>();
    public static Set<Notebook> userResponse(Set<Notebook> allNotebooks, Map<String, String> request){
        Set<Notebook> response = allNotebooks.stream()
                .filter(p -> p.isSuit(request) )
                .collect(Collectors.toSet());
        return response;
    }


}