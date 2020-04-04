package life.majiang.community.controller;

import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.dto.GithubUser;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.User;
import life.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {
    
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String ClientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response) {
        AccessTokenDTO AccessTokenDTO = new AccessTokenDTO();
        AccessTokenDTO.setClient_id(ClientId);
        AccessTokenDTO.setClient_secret(clientSecret);
        AccessTokenDTO.setCode(code);
        AccessTokenDTO.setRedirect_uri(redirectUri);
        AccessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(AccessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if(githubUser != null){
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            if(githubUser.getName() == null){
                user.setName("宋佳兴");
            } else {
                user.setName(githubUser.getName());
            }
            user.setAccount_id(String.valueOf(githubUser.getId()));
            user.setGmtcreate(System.currentTimeMillis());
            user.setGmtModefied(user.getGmtcreate());
            request.getSession().setAttribute("user", user);
            userMapper.insert(user);
            response.addCookie(new Cookie("token", token));
            return "redirect:/";
            //登录成功，写cookie 和session
        } else {
            //登录失败，重新登录
            return "redirect:/";
        }
    }
}
