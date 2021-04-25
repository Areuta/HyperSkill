package advisor;

import advisor.api.AdvisorAuth;
import advisor.api.RequestUtil;
import advisor.ui.Menu;

public class Main {

    public static void main(String[] args) {
        if (args.length > 1) {
            AdvisorAuth.setDefaultServer(args[1]);
        }
        if (args.length > 3) {
            RequestUtil.setApiPath(args[3]);
        }
         new Menu().run();
    }

}
