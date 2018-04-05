package service;

import repository.ActivityRepository;
import model.Activity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class ActivityService {

    static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public static void addActivity(String operation, String username) {

        Activity activity = new Activity();
        activity.setActivityId(UUID.randomUUID().hashCode());
        activity.setOperation(operation);
        activity.setUsername(username);
        activity.setDate(dateFormat.format(new Date()));

        ActivityRepository.addActivity(activity);
    }

    public static void deleteActivity(int activityId) {
        ActivityRepository.deleteActivity(activityId);
    }
}
