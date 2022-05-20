package eu.reply.academy.lesson33.MainPackage;

import eu.reply.academy.lesson33.Model.Menu;

import static eu.reply.academy.lesson33.Factory.FactoryMethod.*;

public class RunMe {

    public static void main(String[] args) {

        //CREARE OBIECT DE TIP MENU SI AFISARE - UN FISIER DE TIP JSON
        System.out.println("-CITIRE DIN FISIER JSON-");
        Menu menu = createMenu(PATH, "fisier2JSON", "JSON");
        menu.printMenu();
        //CREARE OBIECT DE TIP MENU SI AFISARE - UN FISIER DE TIP XML
        System.out.println("-CITIRE DIN FISIER XML-");
        Menu menu2 = createMenu(PATH, "fisier2XML", "XML");
        menu2.printMenu();
    }
}
