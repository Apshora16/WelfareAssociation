package com.example.welfareassociation.model;

public class SecurityRecord {

    private String securityStatus, lastScan,totalUsers,
            activeSessions,accessLog;

    public SecurityRecord(String securityStatus, String lastScan, String totalUsers, String activeSessions, String accessLog) {
        this.securityStatus = securityStatus;
        this.lastScan = lastScan;
        this.totalUsers = totalUsers;
        this.activeSessions = activeSessions;
        this.accessLog = accessLog;
    }


    public String getSecurityStatus() {
        return securityStatus;
    }

    public String getLastScan() {
        return lastScan;
    }

    public String getTotalUsers() {
        return totalUsers;
    }

    public String getActiveSessions() {
        return activeSessions;
    }

    public String getAccessLog() {
        return accessLog;
    }


    public void setSecurityStatus(String securityStatus) {
        this.securityStatus = securityStatus;
    }

    public void setLastScan(String lastScan) {
        this.lastScan = lastScan;
    }

    public void setTotalUsers(String totalUsers) {
        this.totalUsers = totalUsers;
    }

    public void setActiveSessions(String activeSessions) {
        this.activeSessions = activeSessions;
    }

    public void setAccessLog(String accessLog) {
        this.accessLog = accessLog;
    }
}
