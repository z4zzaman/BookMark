package bookmarkcom.com.bookmarkhistory;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static ArrayList<BookmarkModel> arrayList;
    public final Uri BOOKMARKS_URI = Uri.parse("content://browser/bookmarks");
    public final String[] HISTORY_PROJECTION = new String[]{
            "_id", // 0
            "url", // 1
            "visits", // 2
            "date", // 3
            "bookmark", // 4
            "title", // 5
            "favicon", // 6
            "thumbnail", // 7
            "touch_icon", // 8
            "user_entered", // 9
    };

    public final int HISTORY_PROJECTION_TITLE_INDEX = 5;
    public final int HISTORY_PROJECTION_URL_INDEX = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        init();
    }

    private void init() {
        arrayList = new ArrayList<BookmarkModel>();

        // Cursor to get Bookmar information
        Cursor cursor = getContentResolver().query(
                BOOKMARKS_URI, HISTORY_PROJECTION, null, null, null);

        // Note : " Browser.BookmarkColumns.BOOKMARK " - this will return 0 or
        // 1. '1' indicates a bookmark and '0' indicates history item.

        try {
            // Now loop to all items using cursor
            if (cursor != null && cursor.moveToFirst()) {
                do {

                    // Add Bookmark title and Bookmark Url
                    arrayList.add(new BookmarkModel(cursor.getString(HISTORY_PROJECTION_TITLE_INDEX), cursor
                            .getString(HISTORY_PROJECTION_URL_INDEX)));

                } while (cursor.moveToNext()); // Move to next
            }
        } finally {

            // Close the cursor after use
            cursor.close();
        }

  /*      for (int i=0; i<5; i++){
            BookmarkModel bookmarkModel = new BookmarkModel("Title" + i , "Url" + i);
            arrayList.add(bookmarkModel);
        }*/


        // specify an adapter (see also next example)
        mAdapter = new BookMarkAdapter(arrayList);
        mRecyclerView.setAdapter(mAdapter);

 /*       Bookmark_Adapter adapter = new Bookmark_Adapter(MainActivity.this,
                arrayList);*/
       // listView.setAdapter(adapter);// Set adapter
    }

}
