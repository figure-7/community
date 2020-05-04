package life.majiang.community.cache;

import life.majiang.community.dto.TagDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TagCache {
    public static List<TagDTO> get() {
        List<TagDTO> tagDTOS = new ArrayList<>();
        TagDTO program = new TagDTO();
        program.setCategoryName("开发语言");
        program.setTags(Arrays.asList("js","php","html","java","nodejs","python","javascript","css","html5","python","c++","c","golang","objective-c","typescript","shell","swift","c#","sass","ruby","bash","less","perl","lua","scala","coffeescript","rust","erlang"));
        tagDTOS.add(program);
        TagDTO framework = new TagDTO();
        framework.setCategoryName("平台框架");
        framework.setTags(Arrays.asList("laravel","spring","express","django","flask","yii","ruby-on-rails","tornado","koa","struts"));
        tagDTOS.add(framework);
        TagDTO server = new TagDTO();
        server.setCategoryName("服务器");
        server.setTags(Arrays.asList("linux","nginx","docker","centos","缓存tomcat","unix","hadoop","windows-server","负载均衡"));
        tagDTOS.add(server);
        TagDTO db = new TagDTO();
        db.setCategoryName("数据库");
        db.setTags(Arrays.asList("mysql","redis","sql","oracle","nosql memcached","sqlserver","postqresql","sqlite"));
        tagDTOS.add(db);
        TagDTO tool = new TagDTO();
        tool.setCategoryName("开发软件");
        tool.setTags(Arrays.asList("git","github","visual-studio-code","vim","sublime-text","xcode intellij-idea","eclipse","maven","ide","svn","visual-studio","atom emacs","textmate"));
        tagDTOS.add(tool);
        return tagDTOS;
    }

    public static String filterInvalid(String tags) {
        String[] split = StringUtils.split(tags,",");
        List<TagDTO> tagDTOS = get();
        List<String> tagList = tagDTOS.stream().flatMap(tag->tag.getTags().stream()).collect(Collectors.toList());
        String invalid = Arrays.stream(split).filter(t->!tagList.contains(t)).collect(Collectors.joining(","));
        return invalid;
    }
}