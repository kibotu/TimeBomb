package net.kibotu.timebomb;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by <a href="https://about.me/janrabe">Jan Rabe</a>.
 */

public class TimeBomb {

    private static final String TAG = TimeBomb.class.getSimpleName();

    private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd.MM.yyyy");

    public static void bombAfterDays(Context context, long buildTime, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(buildTime);
        Date buildDate = calendar.getTime();
        Date today = new Date();
        long difference = daysBetween(buildDate, today);
        Log.v(TAG, "[bombAfterDays] Build Date=" + sdf1.format(buildDate) + " Today=" + sdf1.format(today) + " Passed Days=" + difference);

        if (difference <= days)
            return;

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(R.string.time_bomb_message)
                .setCancelable(false);

        Dialog dialog = builder.create();
        dialog.setOnShowListener(dialog1 -> {
            ((AlertDialog) dialog1).getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
            ((AlertDialog) dialog1).getButton(AlertDialog.BUTTON_NEGATIVE).setEnabled(false);
        });
        dialog.show();
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
}