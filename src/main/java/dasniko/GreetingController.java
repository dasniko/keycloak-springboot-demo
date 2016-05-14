package dasniko;

import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@RestController
@RequestMapping(value = "greeter")
public class GreetingController {

    private AccessToken accessToken;

    @Autowired
    public GreetingController(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    @RequestMapping("greet")
    public String getGreeting() {
        return "Hello " + accessToken.getPreferredUsername();
    }
}
