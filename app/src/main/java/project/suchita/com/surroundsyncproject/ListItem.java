package project.suchita.com.surroundsyncproject;

/**
 * Created by SuchitaTewari on 5/17/16.
 */
public class ListItem {

    private String no_of_tasks;

    //ArrayLists
    private String  taskName = new String();
    private String  taskDuration = new String();
    private String  taskTime = new String();

    public String getTaskDuration() {
        return taskDuration;
    }

    public void setTaskDuration(String taskDuration) {
        this.taskDuration = taskDuration;
    }

    public String getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(String taskTime) {
        this.taskTime = taskTime;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }


}
