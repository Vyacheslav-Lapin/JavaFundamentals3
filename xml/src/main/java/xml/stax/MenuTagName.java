package xml.stax;

public enum MenuTagName {
    NAME, PRICE, DESCRIPTION, CALORIES, FOOD, BREAKFAST_MENU;

    public static MenuTagName getElementTagName(String element) {
        switch (element) {
            case "food":
                return FOOD;
            case "price":
                return PRICE;
            case "description":
                return DESCRIPTION;
            case "calories":
                return CALORIES;
            case "breakfast-menu":
                return BREAKFAST_MENU;
            case "name":
                return NAME;
            default:
                throw new EnumConstantNotPresentException(MenuTagName.class, element);
        }
    }

}
