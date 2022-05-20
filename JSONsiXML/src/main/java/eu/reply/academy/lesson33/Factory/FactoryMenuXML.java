package eu.reply.academy.lesson33.Factory;

import eu.reply.academy.lesson33.Model.Item;
import eu.reply.academy.lesson33.Model.Menu;
import eu.reply.academy.lesson33.Model.MenuItem;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class FactoryMenuXML extends FactoryMenu {

    public FactoryMenuXML(String path, String fileName, String fileExtension) {
        this(path);
        if (this.getFileExtension().equals(fileExtension.toLowerCase()))
            this.setFileName(fileName);
        else
            System.out.println("Ati gresit formatul.");
    }

    public FactoryMenuXML(String path) {
        super(path);
        this.setFileExtension("xml");
    }

    @Override
    protected Menu createObjectMenu(Object obiect) {
        Node node = castToNode(obiect);
        List<Item> itemList = new ArrayList<>();
        Menu menu = null;
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            // int length=element.getElementsByTagName("Items").getLength();
            NodeList nodeListAfterSerchItems = element.getElementsByTagName("Items");
            Node itemsNode = nodeListAfterSerchItems.item(0);
            NodeList nodeList = itemsNode.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                this.createObjectItem(nodeList.item(i), itemList);
            }
            menu = new Menu(element.getElementsByTagName("idMenu").item(0).getTextContent(), element.getElementsByTagName("valueMenu").item(0).getTextContent(), itemList);
        }
        return menu;
    }

    @Override
    protected void createObjectItem(Object obiect, List<Item> itemList) {
        Node node = castToNode(obiect);
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            Item item = new Item(element.getElementsByTagName("idItem").item(0).getTextContent(), element.getElementsByTagName("labelItem").item(0).getTextContent(), element.getElementsByTagName("valueItem").item(0).getTextContent(), element.getElementsByTagName("onClick").item(0).getTextContent());
            itemList.add(item);
        }
    }

    private Node castToNode(Object obiect) {
        Node node = null;
        if (obiect instanceof Object) {
            node = (Node) obiect;
        } else if (obiect instanceof Node) {
            node = (Node) obiect;
        }
        return node;
    }

    @Override
    public List<MenuItem> createMenuItem() {
        List<MenuItem> menuItemList = new ArrayList<>();
        try {
            StringBuilder stringBuilder = readFileText();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new InputSource(new StringReader(stringBuilder.toString())));
            NodeList nodeList = document.getElementsByTagName("Menu"); //poate intoarce si un singur item, depinde cum il iei
            for (int i = 0; i < nodeList.getLength(); i++) {
                Menu menu = this.createObjectMenu(nodeList.item(i));
                menuItemList.addAll(menu.getMenuItemList());
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return menuItemList;
    }
}
