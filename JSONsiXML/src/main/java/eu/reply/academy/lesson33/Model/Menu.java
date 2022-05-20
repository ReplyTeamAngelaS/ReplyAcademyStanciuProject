package eu.reply.academy.lesson33.Model;

import eu.reply.academy.lesson33.Factory.FactoryMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu extends MenuItem{

    private static final String HEADER = "Application Menu Bar";
    private String idMenu;
    private String valueMenu;
    private List<MenuItem> popupList;

    public String getIdMenu() {
        return this.idMenu;
    }

    public String getValueMenu() {
        return this.valueMenu;
    }

    public void setIdMenu(String idMenu) {
        this.idMenu = idMenu;
    }

    public void setValueMenu(String valueMenu) {
        this.valueMenu = valueMenu;
    }

    public List<MenuItem> getPopupList() {
        return this.popupList;
    }

    public void setPopupList(List<MenuItem> popupList) {
        if (this.popupList == null) {
            this.popupList = new ArrayList<>();
        }
        this.popupList = popupList;
    }

    public String getHeader() {
        return Menu.HEADER;
    }

    public Menu(String idMenu, String valueMenu, List<MenuItem> menuItemList) {
        this.setIdMenu(idMenu);
        this.setValueMenu(valueMenu);
        this.setPopupList(menuItemList);
    }

    public Menu() {

    }

    public Menu(FactoryMenu factoryMenu)
    {
       // popupList = factoryMenu.createMenuItem();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Menu: ID=" + this.getIdMenu() + " VALUE=" + this.getValueMenu() + " Popup=\n" + "  " + Arrays.toString(this.getPopupList().toArray()).replace('[', ' ')
                .replace(']', ' ').replace(',', ' ').trim());
        return stringBuilder.toString();
    }

    public void printMenu(List<MenuItem> menuItemList) {
        System.out.println(this.getHeader());
        for (MenuItem menuItem : menuItemList) {
            System.out.println(menuItem);
        }
    }
}
