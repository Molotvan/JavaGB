import java.util.Map;

public class Notebook {
    private int id;
    private String name;
    private String model;
    private int diagonal;
    private int hddValue;
    private int ramValue;
    private String processor;
    private int cost;

    public Notebook(int id, String name, String model, int diagonal, int hddValue, int ramValue, String processor, int cost) {
        this.name = name;
        this.model = model;
        this.diagonal = diagonal;
        this.hddValue = hddValue;
        this.ramValue = ramValue;
        this.processor = processor;
        this.cost = cost;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public int getHddValue() {
        return hddValue;
    }

    public int getRamValue() {
        return ramValue;
    }

    public String getProcessor() {
        return processor;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return ("Название:  " + this.getName()+ "\n"+ "Модель "+ this.getModel() + "\n" + "Диагональ: " + this.getDiagonal()+ "\n" + "Память " + this.getHddValue() +
                 "\n" + "Оперативная память " + this.getRamValue() + "\n" + "Процессор " + this.getProcessor() + "\n" + "Цена " + this.getCost());
    }

    protected boolean isSuit(Map<String, String> request){
        if (this.getName().equals(request.get("Название"))||(request.get("Название")).equals("0")){
            if(this.getModel().equals(request.get("Модель"))||(request.get("Модель")).equals("0")){
                if(((request.get("Диагональ")).equals("0"))||(this.getDiagonal()==Integer.parseInt(request.get("Диагональ")))){
                    if((this.getHddValue()>=Integer.parseInt(request.get("Объём HDD")))||((request.get("Объём HDD")).equals("0"))){
                        if((this.getRamValue()>=Integer.parseInt(request.get("Оперативная память")))||((request.get("Оперативная память")).equals("0"))){
                            if (this.getProcessor().equals(request.get("Процессор"))||(request.get("Процессор")).equals("0")){
                                if (((Integer.parseInt(request.get("Цена, мин")))<=this.getCost() && this.getCost()<=(Integer.parseInt(request.get("Цена, макс"))))||((request.get("Цена, мин").equals("0"))||(request.get("Цена, макс").equals("0")))){
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
