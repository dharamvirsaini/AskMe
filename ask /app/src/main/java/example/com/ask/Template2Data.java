package example.com.ask;

import java.util.ArrayList;
import java.util.List;

public class Template2Data {
   private List<Item> template2Items ;
   String label ;

    public Template2Data(String label) {
        this.label =label;
        template2Items = new ArrayList<>();
    }

    public String getLabel() {
        return label;
    }

    public List<Item> getTemplate2Items() {
        return template2Items;
    }

   public void addItem(Item item){
       template2Items.add(item);
   }
}
