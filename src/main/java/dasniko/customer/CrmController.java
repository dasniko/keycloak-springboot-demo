package dasniko.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class CrmController {

    private final CustomerRepository customerRepository;

    @RequestMapping
    public String home() {
        return "home";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {
        request.logout();
        return "redirect:/";
    }

    @RequestMapping("/customers")
    public String customers(Model model) {
        model.addAttribute(customerRepository.findAll());
        return "customers";
    }

    @RequestMapping("/customers/{id}")
    public String customer(@PathVariable("id") Long id, Model model) {
        model.addAttribute(customerRepository.findOne(id));
        return "customer";
    }

}
