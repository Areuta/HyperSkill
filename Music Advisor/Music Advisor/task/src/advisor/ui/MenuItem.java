package advisor.ui;

public abstract class MenuItem {
    public String getTitle() {
        return title;
    }

    private final String title;

    public MenuItem(String title) {
        this.title = title;
    }

    public abstract void execute(String request) ;
}
