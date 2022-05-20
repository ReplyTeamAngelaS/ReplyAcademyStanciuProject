package eu.reply.academy.lesson33.Factory;

import eu.reply.academy.lesson33.Model.Menu;
import eu.reply.academy.lesson33.Model.MenuItem;

import java.util.List;

public class FactoryMethod {

    public static final String PATH = "C:\\Users\\Angela Stanciu\\IdeaProjects\\Lesson1\\src\\main\\java\\eu\\reply\\academy\\lesson33\\FilePackage";

    public static Menu createMenu(String path, String fileName, String fileExtension) {
        Menu menu = new Menu();
        if ("json".equals(fileExtension.toLowerCase()))
            menu = new Menu(new FactoryMenuJSON(path, fileName, fileExtension));
        else if ("xml".equals(fileExtension.toLowerCase()))
            menu = new Menu(new FactoryMenuXML(path, fileName, fileExtension));
        return menu;
    }
}
