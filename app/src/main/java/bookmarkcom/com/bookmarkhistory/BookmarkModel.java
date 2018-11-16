package bookmarkcom.com.bookmarkhistory;

/*
 *  ****************************************************************************
 *  * Created by : Md. Moniruzzaman Monir on 11/16/2018 at 12:14 PM.
 *  * Email : moniruzzaman@w3engineers.com
 *  *
 *  * Purpose:
 *  *
 *  * Last edited by : Md. Moniruzzaman Monir on 11/16/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */


public class BookmarkModel {

    // Bookmark getter and setter
    private String bookmark_title, bookmark_url;

    public BookmarkModel(String bookmark_title, String bookmark_url) {
        this.bookmark_title = bookmark_title;
        this.bookmark_url = bookmark_url;

    }

    public String getBookmarkTitle() {
        return bookmark_title;
    }

    public String getBookmarkUrl() {
        return bookmark_url;
    }

}