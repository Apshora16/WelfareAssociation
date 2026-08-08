package com.example.welfareassociation.GeneralSecretary;

import java.io.Serializable;
import java.time.LocalDate;

public class DepartmentCoordination implements Serializable {

    private String department;
    private String departmentStatus;
    private String assignedTask;
    private LocalDate deadline;
    private String taskProgress;

    public DepartmentCoordination() {
    }

    public DepartmentCoordination(String department,
                                  String departmentStatus,
                                  String assignedTask,
                                  LocalDate deadline,
                                  String taskProgress) {
        this.department = department;
        this.departmentStatus = departmentStatus;
        this.assignedTask = assignedTask;
        this.deadline = deadline;
        this.taskProgress = taskProgress;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartmentStatus() {
        return departmentStatus;
    }

    public void setDepartmentStatus(String departmentStatus) {
        this.departmentStatus = departmentStatus;
    }

    public String getAssignedTask() {
        return assignedTask;
    }

    public void setAssignedTask(String assignedTask) {
        this.assignedTask = assignedTask;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getTaskProgress() {
        return taskProgress;
    }

    public void setTaskProgress(String taskProgress) {
        this.taskProgress = taskProgress;
    }

    @Override
    public String toString() {
        return department + " - " + assignedTask;
    }
}