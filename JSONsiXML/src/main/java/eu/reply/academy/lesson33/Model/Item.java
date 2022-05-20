package eu.reply.academy.lesson33.Model;

public class Item extends MenuItem{

    private String idItem;
    private String labelItem;
    private String valueItem;
    private String onClick;

    public String getIdItem() {
        return this.idItem;
    }

    public String getLabelItem() {
        return this.labelItem;
    }

    public String getValueItem() {
        return this.valueItem;
    }

    public String getOnClick() {
        return this.onClick;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public void setLabelItem(String labelItem) {
        this.labelItem = labelItem;
    }

    public void setValueItem(String valueItem) {
        this.valueItem = valueItem;
    }

    public void setOnClick(String onClick) {
        this.onClick = onClick;
    }

    public Item(String idItem, String labelItem, String valueItem, String onClick) {
        this.setIdItem(idItem);
        this.setLabelItem(labelItem);
        this.setValueItem(valueItem);
        this.setOnClick(onClick);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Item: ID=" + this.getIdItem() + " VALUE=" + this.getValueItem() + " LABEL=" + this.getLabelItem() + " ONCLICK=" + this.getOnClick() + "\n");
        return stringBuilder.toString();
    }
}
