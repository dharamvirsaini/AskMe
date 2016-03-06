package example.com.ask;

import java.util.ArrayList;
import java.util.List;


public class Template3Data {
    private List<Item> template3Items ;
    private String label;

    public Template3Data(String label) {
        template3Items = new ArrayList<>();
        this.label = label ;
    }

    public List<Item> getTemplate3Items() {
        return template3Items;
    }

    public void addItem(Item item){
        template3Items.add(item);

    }

    public String getLabel() {
        return label;
    }
}
