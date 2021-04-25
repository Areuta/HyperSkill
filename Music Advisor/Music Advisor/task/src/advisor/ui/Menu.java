package advisor.ui;

import advisor.api.AdvisorAuth;
import advisor.api.RequestUtil;

import java.util.EnumMap;
import java.util.Scanner;

public class Menu {
    public enum Options {
        NEW("new"), AUTH("auth"), FEATURED("featured"), CATEGORIES("categories"), PLAYLISTS("playlists"), EXIT("exit"), SEARCH("search");

        private final String title;

        Options(String title) {
            this.title = title;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);
    public static final String BADINPUT = "Incorrect option!";
    private boolean isExit = false;
    private boolean authenticated = false;
    private final EnumMap<Options, MenuItem> options = new EnumMap<>(Options.class);
    private final CommandManager commandManager = new CommandManager();

    public Menu() {
        registerExitCommand();
        registerAuthCommand();
        registerNewCommand();
        registerFeaturedCommand();
        registerCategoriesCommand();
        registerPlaylistsCommand();
        registerSearchCommand();
    }

    public void run() {

        while (!isExit) {
            String choice = scanner.nextLine();
            String[] choiceStrings = choice.split("\\s");
            String request = "";
            if (choiceStrings[0].equalsIgnoreCase("playlists") && choiceStrings.length > 1) {
                request = choice.substring(9).trim();
            }
            if (choiceStrings[0].equalsIgnoreCase("search") && choiceStrings.length > 1) {
                request = choice.substring(6).trim();
            }

            try {
                Options option = Options.valueOf(choiceStrings[0].toUpperCase());
                if (authenticated || option.equals(Options.AUTH) || option.equals(Options.EXIT)) {
                    MenuItem item = options.get(option);
                    item.execute(request);
                } else {
                    System.out.println("Please, provide access for application.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(BADINPUT);
            }

        }
        scanner.close();
    }

    private void registerNewCommand() {
        options.put(Options.NEW, new MenuItem("new") {
            @Override
            public void execute(String request) {
                commandManager.newCommand();
            }
        });
    }

    private void registerFeaturedCommand() {
        options.put(Options.FEATURED, new MenuItem("featured") {
            @Override
            public void execute(String request) {
                commandManager.featuredCommand();
            }
        });
    }

    private void registerPlaylistsCommand() {
        options.put(Options.PLAYLISTS, new MenuItem("playlists") {
            @Override
            public void execute(String categoryName) {
                if ("".equals(categoryName)) {
                    commandManager.featuredCommand();
                } else {
                    commandManager.playlistsCommand(categoryName);
                }
            }
        });
    }

    private void registerCategoriesCommand() {
        options.put(Options.CATEGORIES, new MenuItem("categories") {
            @Override
            public void execute(String request) {
                commandManager.categoriesCommand();
            }
        });
    }

    private void registerSearchCommand() {
        options.put(Options.SEARCH, new MenuItem("search") {
            @Override
            public void execute(String query) {
                commandManager.searchCommand(query);
                if ("".equals(query)) {
                    System.out.println("BADINPUT");
                } else {
                    RequestUtil.getSearch(query);
                }
            }
        });
    }

    private void registerAuthCommand() {
        options.put(Options.AUTH, new MenuItem("auth") {
            @Override
            public void execute(String request) {
                if (AdvisorAuth.getAuth()) {
                    authenticated = true;
                    System.out.println("---SUCCESS---");
                }
            }
        });
    }

    private void registerExitCommand() {
        options.put(Options.EXIT, new MenuItem("exit") {
            @Override
            public void execute(String request) {
                isExit = true;
                System.out.println("---GOODBYE!---");
            }
        });
    }

}
