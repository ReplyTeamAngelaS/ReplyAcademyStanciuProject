package eu.reply.academy.lesson33.Factory;

import eu.reply.academy.lesson33.Model.Item;
import eu.reply.academy.lesson33.Model.Menu;
import eu.reply.academy.lesson33.Model.MenuItem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public abstract class FactoryMenu {

    public String path;
    public String fileName;
    public String fileExtension;

    public FactoryMenu(String path) {
        this.setPath(path);
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getFileExtension() {
        return this.fileExtension;
    }

    public String getPath() {
        return this.path;
    }

    public String getFileName() {
        return this.fileName;
    }

    protected StringBuilder readFileText() {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.getPath() + "\\" + this.getFileName()))) {
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

    protected abstract void createObjectItem(Object obiect, List<Item> itemList);

    public abstract List<MenuItem> createMenuItem();
}
