package eu.reply.academy.lesson33.Model;

import eu.reply.academy.lesson33.Factory.FactoryMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu extends MenuItem {

    private static final String HEADER = "Application Menu Bar";
    private String idMenu;
    private String valueMenu;
    private List<MenuItem> menuItemList;
    private List<Item> itemList;

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

    public List<MenuItem> getMenuItemList() {
        return this.menuItemList;
    }

    public void setPopupList(Menu menu, List<Item> itemList) {
        if (this.getMenuItemList() == null) {
            this.menuItemList = new ArrayList<>();
        }
        this.menuItemList.add(menu);
        this.menuItemList.addAll(itemList);
    }

    private List<Item> getItemList() {
        return this.itemList;
    }

    public void setItemList(List<Item> itemList) {
        if (this.getItemList() == null) {
            this.itemList = new ArrayList<>();
        }
        this.itemList = itemList;
    }

    public String getHeader() {
        return Menu.HEADER;
    }

    public Menu(String idMenu, String valueMenu, List<Item> itemList) {
        this.setIdMenu(idMenu);
        this.setValueMenu(valueMenu);
        this.setItemList(itemList);
        this.setPopupList(this, itemList);
    }

    public Menu() {
        this.menuItemList = new ArrayList<>();
        this.itemList = new ArrayList<>();
    }

    public Menu(FactoryMenu factoryMenu) {
        this.menuItemList = factoryMenu.createMenuItem();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nMenu: ID=" + this.getIdMenu() + " VALUE=" + this.getValueMenu() + " Popup=");
        return stringBuilder.toString();
    }

    public void printMenu() {
        System.out.println("-------------------------------" + this.getHeader() + "-------------------------------");
        for (MenuItem menuItem : menuItemList) {
            System.out.println(menuItem);
        }
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
    }
}
