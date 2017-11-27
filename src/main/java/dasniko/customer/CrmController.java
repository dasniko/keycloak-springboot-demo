package dasniko.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class CrmController {

    private final CustomerRepository customerRepository;
    private final KeycloakSecurityContext securityContext;
    private final AccessToken accessToken;

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {
        request.logout();
        return "redirect:/";
    }

    @GetMapping("/customers")
    public String customers(Model model, Principal principal) {
        log.info("AccessToken: " + securityContext.getTokenString());
        log.info("User: {} / {}", accessToken.getPreferredUsername(), accessToken.getName());
        log.info("Principal: {}", principal.getName());
        model.addAttribute(customerRepository.findAll());
        return "customers";
    }

    @GetMapping("/customers/{id}")
    public String customer(@PathVariable("id") Long id, Model model) {
        model.addAttribute(customerRepository.findOne(id));
        return "customer";
    }

}
