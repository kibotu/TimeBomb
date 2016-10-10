package net.kibotu.timebomb;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by <a href="https://about.me/janrabe">Jan Rabe</a>.
 */

public class TimeBomb {

    private static final String TAG = TimeBomb.class.getSimpleName();

    private static boolean enableLogging = false;

    private TimeBomb() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    /**
     * Blocks User from keep using the app.
     *
     * @param context   Context
     * @param buildTime Unix Timestamp.
     * @param unit      Amount of days after build time when the blocking should be triggered.
     * @param timeUnit  {@link TimeUnit}
     * @return Returns left time until the app will be blocked.
     */
    public static long bombAfterDays(Context context, String buildTime, long unit, TimeUnit timeUnit) {
        return bombAfterDays(context, Long.parseLong(buildTime), (int) timeUnit.toDays(unit));
    }

    /**
     * Blocks User from keep using the app.
     *
     * @param context   Context
     * @param buildTime Unix Timestamp.
     * @param days      Amount of days after build time when the blocking should be triggered.
     * @return Returns left time until the app will be blocked.
     */
    public static long bombAfterDays(Context context, String buildTime, int days) {
        return bombAfterDays(context, Long.parseLong(buildTime), days);
    }

    /**
     * Blocks User from keep using the app.
     *
     * @param context   Context
     * @param buildTime Unix Timestamp.
     * @param days      Amount of days after build time when the blocking should be triggered.
     * @return Returns left time until the app will be blocked.
     */
    public static long bombAfterDays(Context context, long buildTime, int days) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(buildTime);
        Date buildDate = calendar.getTime();
        Date today = new Date();
        long difference = daysBetween(buildDate, today);

        long timeLeft = days - difference;
        Log.v(TAG, "[bombAfterDays] Bomb in " + timeLeft + "d Build Date=" + sdf1.format(buildDate) + " Today=" + sdf1.format(today) + " Passed Days=" + difference);

        if (difference <= days)
            return timeLeft;

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(R.string.time_bomb_message)
                .setCancelable(false);

        Dialog dialog = builder.create();
        dialog.setOnShowListener(dialog1 -> {
            ((AlertDialog) dialog1).getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
            ((AlertDialog) dialog1).getButton(AlertDialog.BUTTON_NEGATIVE).setEnabled(false);
        });
        dialog.show();

        return timeLeft;
    }

    private static Calendar getDatePart(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }

    /**
     * This method also assumes endDate >= startDate
     **/
    private static long daysBetween(Date startDate, Date endDate) {
        Calendar sDate = getDatePart(startDate);
        Calendar eDate = getDatePart(endDate);

        long daysBetween = 0;
        while (sDate.before(eDate)) {
            sDate.add(Calendar.DAY_OF_MONTH, 1);
            daysBetween++;
        }
        return daysBetween;
    }

    public static boolean enableLogging() {
        return enableLogging;
    }

    public static void enableLogging(boolean enableLogging) {
        TimeBomb.enableLogging = enableLogging;
    }
}