package barqsoft.footballscores;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import barqsoft.footballscores.adapter.ScoresAdapter;
import barqsoft.footballscores.adapter.ViewHolder;
import barqsoft.footballscores.provider.fixture.FixtureColumns;
import barqsoft.footballscores.provider.fixture.FixtureSelection;
import barqsoft.footballscores.provider.soccerseason.SoccerseasonColumns;

/**
 * A placeholder fragment containing a simple view.
 */
public class ScoreListFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>
{
    static final String LOG_TAG=ScoreListFragment.class.getSimpleName();
    private static final java.lang.String ARG_DATE = "ARG_DATE";
    public ScoresAdapter mAdapter;
    public static final int SCORES_LOADER = 0;
    private String mFragmentDate;
    private final String[] PROJECTION = {
            FixtureColumns._ID,
            FixtureColumns.SEASON_ID,
            FixtureColumns.DATE,
            FixtureColumns.TIME,
            FixtureColumns.STATUS,
            FixtureColumns.MATCHDAY,
            FixtureColumns.GOALSHOMETEAM,
            FixtureColumns.GOALSAWAYTEAM,
            FixtureColumns.HOMETEAMNAME,
            FixtureColumns.AWAYTEAMNAME,
            FixtureColumns.HOMETEAMCRESTURL,
            FixtureColumns.AWAYTEAMCRESTURL,
            SoccerseasonColumns.CAPTION
        };
    private int last_selected_item = -1;
    private View mEmptyView;

    public static ScoreListFragment newInstance(String date)
    {
        Bundle args = new Bundle();
        args.putString(ARG_DATE,date);

        ScoreListFragment fragment = new ScoreListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public ScoreListFragment()
    {
    }

    private void update_scores()
    {
        // TODO: we should not update every time...
        // Maybe use a timer to update regularly, and only if a match is currently playing...

        //ApiFetchService.updateScores(getActivity());
    }


    public void setFragmentDate(String date)
    {
        mFragmentDate = date;
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putAll(getArguments());
        outState.putString(ARG_DATE, mFragmentDate);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {

        Bundle bundle = savedInstanceState == null ? getArguments() : savedInstanceState;

        mFragmentDate = bundle.getString(ARG_DATE);

        update_scores();
        View rootView = inflater.inflate(R.layout.fragment_score_list, container, false);
        final ListView score_list = (ListView) rootView.findViewById(R.id.scores_list);
        mAdapter = new ScoresAdapter(getActivity(),null,0);
        score_list.setAdapter(mAdapter);
        getLoaderManager().initLoader(SCORES_LOADER,null,this);
        //mAdapter.detail_match_id = MainActivity.selected_match_id;
        mAdapter.setDetailMatchId(MainActivity.selected_match_id);
        score_list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                ViewHolder selected = (ViewHolder) view.getTag();

                //mAdapter.detail_match_id = selected.match_id;
                mAdapter.setDetailMatchId(selected.match_id);
                MainActivity.selected_match_id = (int) selected.match_id;
                //mAdapter.notifyDataSetChanged();
            }
        });

        mEmptyView = rootView.findViewById(R.id.widget_empty_view);
        score_list.setEmptyView(mEmptyView);
        return rootView;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle)
    {
        /*return new CursorLoader(getActivity(), DatabaseContract.scores_table.buildScoreWithDate(),
                null,null,mFragmentDate,null);*/

        FixtureSelection sel = new FixtureSelection();
        sel.date(mFragmentDate);

        return new CursorLoader(getActivity(),sel.uri(), PROJECTION,sel.sel(),sel.args(),null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor)
    {
        Log.d(LOG_TAG, "onLoadFinished");

        mAdapter.swapCursor(cursor);

        if(cursor.getCount()==0)
        {
           // mEmptyView.setVisibility(View.VISIBLE);

        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader)
    {
        mAdapter.swapCursor(null);
    }


}
