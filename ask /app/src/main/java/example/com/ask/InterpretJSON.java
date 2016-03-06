package example.com.ask;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class InterpretJSON {
    JSONArray jsonArray;
    List<Object> data;

    public InterpretJSON(JSONArray jsonArray) {
        this.jsonArray = jsonArray;

        data = new ArrayList<>();

    }

    public List<Object> getList() throws JSONException {


        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject temporaryObject = jsonArray.getJSONObject(i);
            String string = temporaryObject.getString("template");
            switch (string) {
                case "product-template-1":
                    handleTemplate1(temporaryObject);
                    break;
                case "product-template-2":
                    handleTemplate2(temporaryObject);
                    break;
                case "product-template-3":
                    handleTemplate3(temporaryObject);
                    break;
            }
        }


        return data;
    }

    private void handleTemplate2(JSONObject temporaryObject) throws JSONException {
        Template2Data template2Data = new Template2Data(temporaryObject.getString("label"));
        JSONArray type2ItemsArray = temporaryObject.getJSONArray("items");
        for (int i = 0; i < type2ItemsArray.length(); i++) {
            JSONObject temp = type2ItemsArray.getJSONObject(i);
            Iterator<?> keys = temp.keys();
            String image = "";
            String webUrl = "";
            String label = "";
            while (keys.hasNext()) {
                String key = (String) keys.next();
                String value = temp.getString(key);
                if (key.contains("image"))
                    image = value;
                if (key.contains("web"))
                    webUrl = value;
                if (key.contains("label"))
                    label = value;
            }
            Item item = new Item(label, image, webUrl);
            template2Data.addItem(item);
        }
        data.add(template2Data);


    }

    private void handleTemplate1(JSONObject temporaryObject) throws JSONException {

        Template1Data template1Data = new Template1Data();
        JSONArray type1ItemsArray = temporaryObject.getJSONArray("items");


        for (int i = 0; i < type1ItemsArray.length(); i++) {
            JSONObject temp = type1ItemsArray.getJSONObject(i);
            String image = "", webUrl = "", label = "";

            Iterator<?> keys = temp.keys();

            while (keys.hasNext()) {
                String key = (String) keys.next();
                String value = temp.getString(key);
                if (key.contains("image"))
                    image = value;
                if (key.contains("web"))
                    webUrl = value;
                if (key.contains("label"))
                    label = value;
            }

            Item item = new Item(label, image, webUrl);
            template1Data.addItem(item);

        }
        data.add(template1Data);

    }

    private void handleTemplate3(JSONObject temporaryObject) throws JSONException {
        Template3Data template3Data = new Template3Data(temporaryObject.getString("label"));
        JSONArray type3ItemsArray = temporaryObject.getJSONArray("items");

        for (int i = 0; i < type3ItemsArray.length(); i++) {
            JSONObject temp = type3ItemsArray.getJSONObject(i);
            Iterator<?> keys = temp.keys();
            String image = "";
            String webUrl = "";
            String label = "";
            while (keys.hasNext()) {
                String key = (String) keys.next();
                String value = temp.getString(key);
                if (key.contains("image"))
                    image = value;
                if (key.contains("web"))
                    webUrl = value;
                if (key.contains("label"))
                    label = value;
            }
            Item item = new Item(label, image, webUrl);
            template3Data.addItem(item);


        }
        data.add(template3Data);
    }
}
