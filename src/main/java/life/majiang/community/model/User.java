package life.majiang.community.model;

public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount_id() {
        return accountId;
    }

    public void setAccount_id(String accountId) {
        this.accountId = accountId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getGmtcreate() {
        return gmtCreate;
    }

    public void setGmtcreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModefied() {
        return gmtModified;
    }

    public void setGmtModefied(Long gmtModified) {
        this.gmtModified = gmtModified;
    }
}
