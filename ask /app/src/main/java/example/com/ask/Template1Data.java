package example.com.ask;

import java.util.ArrayList;
import java.util.List;


public class Template1Data {

    String label,imageUrl,webUrl ;
    private List<Item> template1Items ;


    public Template1Data() {
        template1Items = new ArrayList<>();
        this.label = label;
        this.imageUrl = imageUrl;
        this.webUrl = webUrl;
    }

    public List<Item> getTemplate1Items() {
        return template1Items;
    }

    public void addItem(Item item){
        template1Items.add(item);

    }

    public String getLabel() {
        return label;
    }


    public String getImageUrl() {
        return imageUrl;
    }


    public String getWebUrl() {
        return webUrl;
    }


}
