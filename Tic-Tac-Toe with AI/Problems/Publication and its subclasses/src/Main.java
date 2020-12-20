class Publication {

    private String title;

    public Publication(String title) {
        this.title = title;
    }

    public final String getInfo() {
        if (this.getType().equals("Publication")) {
            return this.getType() + ": " + this.title;
        }
        return this.getType() + " (" + this.getDetails() + "): " + this.title;
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

    public String getDetails() {
        return "";
    }

 /*   public static void main(String[] args) {
        System.out.println(new Publication("The new era").getInfo());
        System.out.println(new Newspaper("Football results", "Sport news").getInfo());
        System.out.println(new Article("Why the Sun is hot", "Dr James Smith").getInfo());
        System.out.println(new Announcement("Will sell a house", 30).getInfo());
    }*/

}

class Newspaper extends Publication {

    private String source;

    public Newspaper(String title, String source) {
        super(title);
        this.source = source;
    }

    @Override
    public String getDetails() {
        return "source - " + this.source;
    }

}

class Article extends Publication {

    private String author;

    public Article(String title, String author) {
        super(title);
        this.author = author;
    }

    @Override
    public String getDetails() {
        return "author - " + this.author;
    }

}

class Announcement extends Publication {

    private int daysToExpire;

    public Announcement(String title, int daysToExpire) {
        super(title);
        this.daysToExpire = daysToExpire;
    }

    @Override
    public String getDetails() {
        return "days to expire - " + this.daysToExpire;
    }
}