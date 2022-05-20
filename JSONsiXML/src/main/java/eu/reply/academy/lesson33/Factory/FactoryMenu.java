package eu.reply.academy.lesson33.Factory;

import eu.reply.academy.lesson33.Model.Menu;
import eu.reply.academy.lesson33.Model.MenuItem;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public abstract class FactoryMenu {

    public String path;
    public String fileName;
    public String fileExtension;

    public FactoryMenu(String path){
        this.setPath(path);
    }

    public void setPath(String path){
        this.path=path;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    protected StringBuilder readFileText(String path, String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path + "\\" + fileName))) {
            String linie;
            while ((linie = bufferedReader.readLine()) != null) {
                stringBuilder.append(linie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder;
    }

    protected abstract Menu createObjectMenu(Object obiect);

    protected abstract void createObjectItem(Object obiect, List<MenuItem> menuItemList);

    public abstract List<MenuItem> createMenuItem(String path, String fileName);
}
