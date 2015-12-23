package org.j2eetest.bean;

public enum AppServer {
    Geronimo(100, "Geronimo", ""), GlassFish(105, "GlassFish", ""), JBoss(110, "JBoss", ""), Tomcat(115, "Tomcat", ""),
    WebLogic(140, "WebLogic", "");
    private int id;
    private String name;
    private String description;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    private AppServer(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;

    }
}