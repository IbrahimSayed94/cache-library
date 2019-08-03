package ibrahim.taskmind.Library.Main.Downloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

import ibrahim.taskmind.Library.Main.Cashe.MemoryCache;
import ibrahim.taskmind.Library.Main.helper.HelperMethods;

public class ImageLoader extends AsyncTask<String, Void, Bitmap> {

    ImageView bmImage;
    MemoryCache memoryCache;
    String imageUrl="";

    public ImageLoader(ImageView bmImage) {
        this.bmImage = bmImage;
        memoryCache = new MemoryCache();
    }

    protected Bitmap doInBackground(String... urls) {
         imageUrl = urls[0];
        Bitmap bmp = null;
        try {
            InputStream in = new java.net.URL(imageUrl).openStream();
            bmp = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("QP", e.getMessage());
            e.printStackTrace();
        }
        return bmp;
    }
    protected void onPostExecute(Bitmap result) {
        if(result != null)
        memoryCache.saveImageToCashe(result, HelperMethods.getFileNameFromURL(imageUrl));
        bmImage.setImageBitmap(result);
    }
}