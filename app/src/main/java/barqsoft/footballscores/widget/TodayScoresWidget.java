package barqsoft.footballscores.widget;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.RemoteViews;

import barqsoft.footballscores.MainActivity;
import barqsoft.footballscores.R;
import barqsoft.footballscores.api.ApiFetchService;

/**
 * Implementation of App Widget functionality.
 */
public class TodayScoresWidget extends AppWidgetProvider
{
    static final String LOG_TAG = TodayScoresWidget.class.getSimpleName();
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onReceive(Context context, Intent intent)
    {
        super.onReceive(context, intent);
        if (ApiFetchService.ACTION_DATA_UPDATED.equals(intent.getAction()))
        {
            Log.d(LOG_TAG,"received intent with action ACTION_DATA_UPDATED");
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(  new ComponentName(context, getClass()));
            appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.widget_scores_list);
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
    {
        // There may be multiple widgets active, so update all of them
        final int N = appWidgetIds.length;
        for (int i = 0; i < N; i++)
        {
            updateAppWidget(context, appWidgetManager, appWidgetIds[i]);
        }


    }


    @Override
    public void onEnabled(Context context)
    {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context)
    {
        // Enter relevant functionality for when the last widget is disabled
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId)
    {
        Log.d(LOG_TAG,"updateAppWidget");
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.today_scores_widget);

        // Create an Intent to launch MainActivity
        Intent mainActivityIntent = new Intent(context, MainActivity.class);

        Intent updateIntent = new Intent(context, ApiFetchService.class);
        updateIntent.setAction(ApiFetchService.ACTION_UPDATE_SCORES);

        PendingIntent mainActivityPendingIntent = PendingIntent.getActivity(context, 0, mainActivityIntent, 0);
        views.setOnClickPendingIntent(R.id.widget, mainActivityPendingIntent);

        PendingIntent updatePendingIntent = PendingIntent.getService(context, 0, updateIntent, 0);
        views.setOnClickPendingIntent(R.id.update_button, updatePendingIntent);

        views.setEmptyView(R.id.widget_scores_list, R.id.widget_empty_view);

        // Set up the collection
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH)
        {
            setRemoteAdapter(context, views);
        }
        else
        {
            setRemoteAdapterV11(context, views);
        }


        // Tell the AppWidgetManager to perform an update on the current app widget
        appWidgetManager.updateAppWidget(appWidgetId, views);

    }

    /**
     * Sets the remote adapter used to fill in the list items
     *
     * @param views RemoteViews to set the RemoteAdapter
     */
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    private void setRemoteAdapter(Context context, @NonNull final RemoteViews views) {
        views.setRemoteAdapter(R.id.widget_scores_list,
                new Intent(context, TodayScoresRemoteViewsService.class));
    }

    /**
     * Sets the remote adapter used to fill in the list items
     *
     * @param views RemoteViews to set the RemoteAdapter
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @SuppressWarnings("deprecation")
    private void setRemoteAdapterV11(Context context, @NonNull final RemoteViews views) {
        views.setRemoteAdapter(0, R.id.widget_scores_list,
                new Intent(context, TodayScoresRemoteViewsService.class));
    }
}

