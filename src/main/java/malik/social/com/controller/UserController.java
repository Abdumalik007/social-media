package malik.social.com.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import malik.social.com.dto.UserDto;
import malik.social.com.dto.custom.LoginRequest;
import malik.social.com.repository.UserRepository;
import malik.social.com.service.main.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/register")
    public String showRegister(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") UserDto userDto){
        if(userRepository.findUserByEmail(userDto.getEmail()) != null)
            return "redirect:/user/register?fail=true";
        userService.register(userDto);
        return "redirect:/user/register?success";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }


}