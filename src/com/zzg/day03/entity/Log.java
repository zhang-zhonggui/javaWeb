package com.zzg.day03.entity;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
public class Log {
    private int id;
    private String name;
    private String date;
    private String way;
    private String ip;
    private int wayId;

    public Log() {
    }

    public Log(int id, String name, String dare, String way, String ip, int wayId) {
        this.id = id;
        this.name = name;
        this.date = dare;
        this.way = way;
        this.ip = ip;
        this.wayId = wayId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDare() {
        return date;
    }

    public void setDare(String dare) {
        this.date = dare;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getWayId() {
        return wayId;
    }

    public void setWayId(int wayId) {
        this.wayId = wayId;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dare='" + date + '\'' +
                ", way='" + way + '\'' +
                ", ip='" + ip + '\'' +
                ", wayId=" + wayId +
                '}';
    }
}
