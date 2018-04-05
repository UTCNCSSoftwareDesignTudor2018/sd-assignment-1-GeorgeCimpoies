package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Activity;

public class ActivityRepository {


    public static void addActivity(Activity activity) {

        try {

            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("INSERT INTO activities (idactivities,username,`date`,operation) VALUES(?,?,?,?)");
            posted.setInt(1, activity.getActivityId());
            posted.setString(2, activity.getUsername());
            posted.setString(3, activity.getDate());
            posted.setString(4, activity.getOperation());

            posted.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Activity Insert Complete");
        }

    }

    public static void deleteActivity(int activityId) {

        try {
            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("DELETE FROM activities where idactivities=?");
            posted.setInt(1, activityId);

            posted.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Activity Delete Complete");
        }

    }

    static void updateActivity(Activity activity) {

        try {
            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("Update activities set idactivities=?,username=?,`date`=?,operation=? where idactivities=?");
            posted.setInt(1, activity.getActivityId());
            posted.setString(2, activity.getUsername());
            posted.setString(3, activity.getDate());
            posted.setString(3, activity.getOperation());
            posted.setInt(3, activity.getActivityId());

            posted.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Update Complete");
        }

    }

    static Activity readActivity(int activityId) {

        Activity activity = new Activity();

        try {
            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("Select idactivities,username,`date`,operation from activities where idactivities=?");
            posted.setInt(1, activityId);

            ResultSet m = posted.executeQuery();

            while (m.next()) {

                activity.setActivityId(m.getInt(1));
                activity.setUsername(m.getString(2));
                activity.setDate(m.getString(3));
                activity.setOperation(m.getString(4));
                activity.setActivityId(activityId);

            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Read Complete");
        }
        return activity;
    }
}
