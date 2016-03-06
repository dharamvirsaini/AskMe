package example.com.ask;


public class Item {
    private String label;
    private String imageUrl;
    private String webUrl;

    public Item(String label, String imageUrl, String webUrl) {
        this.label = label;
        this.imageUrl = imageUrl;
        this.webUrl = webUrl;
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
