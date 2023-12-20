package Proyecto;

public class Item_pago { // esta clase sirve para construir los items del combobox
    private int id;
    private String type;
    private String account_number;
    private String clabe;

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getAccount_number() {
        return account_number;
    }

    public String getClabe() {
        return clabe;
    }

    public Item_pago(int id, String type, String account_number, String clabe) {
        this.id = id;
        this.type = type;
        this.account_number = account_number;
        this.clabe = clabe;

    }

    @Override
    public String toString() {
        if (type.equals("Efective")) {
            return type;
        } else if (type.equals("debit_card") || type.equals("credit_card")) {
            return type + " " + account_number;
        } else if (type.equals("transfer")) {
            return type + " " + clabe;
        } else {
            return "Desconocido";
        }
    }
}
