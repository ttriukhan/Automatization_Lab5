import java.util.List;

public class Schedule {

    private String group;
    private List<String> scheduleList;

    public Schedule(String group, List<String> scheduleList) {
        this.group = group;
        this.scheduleList = scheduleList;
    }

    public String getGroup() {
        if(group.equals(""))
            return  "Інформації про групу не знайдено";
        return group;
    }

    public List<String> getScheduleList() {
        return scheduleList;
    }

    public String getScheduleString() {
        StringBuilder sb = new StringBuilder();
        if (scheduleList.isEmpty())
            sb.append("Немає даних про відключення");
        for (String s: scheduleList) {
            sb.append(s).append("\n");
        }
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(group.equals(""))
            group = "Інформації про групу не знайдено";
        sb.append(group);
        if (scheduleList.isEmpty())
            sb.append("Немає даних про відключення");
        for (String s: scheduleList) {
            sb.append("\n").append(s);
        }
        return sb.toString();
    }

}
