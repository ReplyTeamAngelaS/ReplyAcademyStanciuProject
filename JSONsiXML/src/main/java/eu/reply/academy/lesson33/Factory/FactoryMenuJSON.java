package eu.reply.academy.lesson33.Factory;

import eu.reply.academy.lesson33.Model.Item;
import eu.reply.academy.lesson33.Model.Menu;
import eu.reply.academy.lesson33.Model.MenuItem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

public class FactoryMenuJSON extends FactoryMenu {

    public FactoryMenuJSON(String path, String fileName, String fileExtension) {
        this(path);
        if (this.getFileExtension().equals(fileExtension.toLowerCase()))
            this.setFileName(fileName);
        else
            System.out.println("Ati gresit formatul.");

    }

    private FactoryMenuJSON(String path) {
        super(path);
        this.setFileExtension("json");
    }

    @Override
    protected Menu createObjectMenu(Object obiect) {
        JSONObject jsonObject = castToJsonObject(obiect);
        List<Item> itemList = new ArrayList<>();
        JSONArray jsonArray = (JSONArray) jsonObject.get("popupList");
        for (int i = 0; i < jsonArray.size(); i++) {
            this.createObjectItem((JSONObject) jsonArray.get(i), itemList);
        }
        Menu menu = new Menu((String) jsonObject.get("idMenu"), (String) jsonObject.get("valueMenu"), itemList);
        return menu;
    }

    @Override
    protected void createObjectItem(Object obiect, List<Item> itemList) {
        JSONObject jsonObject = castToJsonObject(obiect);
        Item item = new Item((String) jsonObject.get("idItem"), (String) jsonObject.get("labelItem"), (String) jsonObject.get("valueItem"), (String) jsonObject.get("onClick"));
        itemList.add(item);
    }

    private JSONObject castToJsonObject(Object obiect) {
        JSONObject jsonObject = null;
        if (obiect instanceof Object) {
            jsonObject = (JSONObject) obiect;
        } else if (obiect instanceof JSONObject) {
            jsonObject = (JSONObject) obiect;
        }
        return jsonObject;
    }

    @Override
    public List<MenuItem> createMenuItem() {
        List<MenuItem> menuItemList = new ArrayList<>();
        try {
            StringBuilder stringBuilder = readFileText();
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(stringBuilder.toString());
            JSONArray jsonArray = (JSONArray) jsonObject.get("Menu");
            for (int i = 0; i < jsonArray.size(); i++) {
                Menu menu = createObjectMenu((JSONObject) jsonArray.get(i));
                menuItemList.addAll(menu.getMenuItemList());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return menuItemList;
    }
}
