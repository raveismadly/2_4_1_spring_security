package web.config.handler;


import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import web.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        HttpSession session =  request.getSession();
        User user = (User) authentication.getPrincipal();
        session.setAttribute("user",user);
        session.setAttribute("authorities",authentication.getAuthorities());
        if(user.getRoles().iterator().next().getRole().equals("ADMIN")){
            response.sendRedirect("admin");
        } else {
            response.sendRedirect("user");
        }
    }
    //тут надо дописать куда отправить админа и юзера
    // 7. Настройте LoginSuccessHandler так, чтобы админа после логина направляло на страницу /admin,
    // а юзера на его страницу.
}