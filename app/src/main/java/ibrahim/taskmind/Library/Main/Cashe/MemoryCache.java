package ibrahim.taskmind.Library.Main.Cashe;


import android.graphics.Bitmap;
import android.util.Log;

import org.json.JSONObject;



public class MemoryCache implements ICasheImage , ICasheJson
{
    @Override
    public void saveImageToCashe(Bitmap bitmap, String imageName) {
        Log.e("QP","saveImageToCashe "+bitmap+" : "+imageName);
        Cache.getInstance().getCashe().put(imageName,bitmap);
    }

    @Override
    public Bitmap getImageFromCashe(String imageName) {

        Bitmap bitmap = null;
        bitmap = (Bitmap)Cache.getInstance().getCashe().get(imageName);
        return bitmap;
    }

    @Override
    public void saveJsonToCashe(Object json, String request) {
        Log.e("QP","Memory cashe save : "+request);
        Cache.getInstance().getCashe().put(request,json);
    }

    @Override
    public Object getJsonFromCashe(String request) {
        Log.e("QP","Memory cashe get : "+request);
        Object object = null;
        object = (Object) Cache.getInstance().getCashe().get(request);
        return object;
    }
} // class of MemoryCache
