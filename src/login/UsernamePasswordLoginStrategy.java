package login;

import user.User;
import user.UserManager;
import user.UserMetaData;

public class UsernamePasswordLoginStrategy implements LoginStrategy {

    private final UserManager userManager;

    public UsernamePasswordLoginStrategy()
    {
        this.userManager = UserManager.getInstance();
    }

    @Override
    public User processLogin(UserMetaData userMetaData) {
        String username = userMetaData.getUsername();
        String password = userMetaData.getPassword();
        User user = userManager.getUserByUsername(username);
        if (user == null) {
            return null;
        }
        // otherwise match password
        return user.getPassword().equals(password) ? user : null;
    }
}
