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

    public FactoryMenuJSON(String path, String fileName){

    }

    @Override
    protected Menu createObjectMenu(Object obiect) {
        JSONObject jsonObject = castToJsonObject(obiect);
        List<MenuItem> menuItemList = new ArrayList<>();
        JSONArray jsonArray = (JSONArray) jsonObject.get("popupList");
        for (int i = 0; i < jsonArray.size(); i++) {
            this.createObjectItem((JSONObject) jsonArray.get(i), menuItemList);
        }
        Menu menu = new Menu((String) jsonObject.get("idMenu"), (String) jsonObject.get("valueMenu"), menuItemList);
        return menu;
    }

    @Override
    protected void createObjectItem(Object obiect, List<MenuItem> menuItemList) {
        JSONObject jsonObject = castToJsonObject(obiect);
        Item item = new Item((String) jsonObject.get("idItem"), (String) jsonObject.get("labelItem"), (String) jsonObject.get("valueItem"), (String) jsonObject.get("onClick"));
        menuItemList.add(item);
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
    public List<MenuItem> createMenuItem(String path, String fileName) {
        List<MenuItem> menuItemList = new ArrayList<>();
        try {
            StringBuilder stringBuilder = readFileText(path, fileName + ".json");
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(stringBuilder.toString());
            JSONArray jsonArray = (JSONArray) jsonObject.get("Menu");
            for (int i = 0; i < jsonArray.size(); i++) {
                Menu menu = createObjectMenu((JSONObject) jsonArray.get(i));
                menuItemList.add(menu);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return menuItemList;
    }
}
