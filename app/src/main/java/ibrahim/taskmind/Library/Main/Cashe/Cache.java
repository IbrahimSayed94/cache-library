package ibrahim.taskmind.Library.Main.Cashe;

import android.util.Log;
import android.util.LruCache;

public class Cache
{
    private static Cache instance;
    private LruCache<Object, Object> cashe;

    private Cache() {

        cashe = new LruCache<Object, Object>(4096);

    }

    public static Cache getInstance() {

        if (instance == null) {

            instance = new Cache();
        }

        return instance;

    }

    public LruCache<Object, Object> getCashe() {
        return cashe;
    }

    public void clear()
    {
    }
} // class of Cashe
