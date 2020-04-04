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

import javax.servlet.http.HttpServletRequest;
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
                           HttpServletRequest request) {
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
            user.setToken(UUID.randomUUID().toString());
            if(githubUser.getName() == null){
                user.setName("sjx");
            } else {
                user.setName(githubUser.getName());
            }
            user.setAccount_id(String.valueOf(githubUser.getId()));
            user.setGmtcreate(System.currentTimeMillis());
            user.setGmtModefied(user.getGmtModefied());
            request.getSession().setAttribute("user", user);
            userMapper.insert(user);
            return "redirect:/";
            //登录成功，写cookie 和session
        } else {
            //登录失败，重新登录
            return "redirect:/";
        }
    }
}
