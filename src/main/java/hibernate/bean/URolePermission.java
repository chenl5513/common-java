package hibernate.bean;

public class URolePermission {
    private Long id;

    //private Long rid;

    //private Long pid;

    private URole role;

    private UPermission permission;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public URole getRole() {
        return role;
    }

    public void setRole(URole role) {
        this.role = role;
    }

    public UPermission getPermission() {
        return permission;
    }

    public void setPermission(UPermission permission) {
        this.permission = permission;
    }
}