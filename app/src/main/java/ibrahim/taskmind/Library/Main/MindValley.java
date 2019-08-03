package ibrahim.taskmind.Library.Main;

import android.app.ProgressDialog;
import android.content.Context;

import android.util.Log;
import android.widget.ImageView;


import ibrahim.taskmind.Library.Main.Cashe.MemoryCache;
import ibrahim.taskmind.Library.Main.Downloader.DownloadData;
import ibrahim.taskmind.Library.Main.Downloader.ImageLoader;
import ibrahim.taskmind.Library.Main.helper.HelperMethods;
import ibrahim.taskmind.R;

public class MindValley
{

    private String TAG = "MindValley-Library";

   private ProgressDialog mProgressDialog;
   private ImageView imageView;
   private Context context;
   private String url;
   private String requestName;
   private Object object;


    private MemoryCache memoryCache ;
    private DownloadData downloadData;

    public MindValley() {
    }

    private MindValley(final DownLoad downLoad, String type)
   {
      url = downLoad.url;
      mProgressDialog = downLoad.mProgressDialog;
      context = downLoad.context;

      if(type.equals("start"))
       {
           downloadData = new DownloadData(context, mProgressDialog);
           downloadData.execute(url);
       }
       else if(type.equals("cancel"))
      {
       if(downloadData != null)
           downloadData.cancel(true);
      }
   }

   private MindValley(final LoadImage loadImage) {
       url = loadImage.url;
       imageView = loadImage.imageView;
       context = loadImage.context;

       memoryCache = new MemoryCache();

       if (memoryCache.getImageFromCashe(HelperMethods.getFileNameFromURL(url)) == null) {
           if (url.equals(""))
               imageView.setImageDrawable(context.getDrawable(R.drawable.placeholder));
           else
               new ImageLoader(imageView).execute(url);

           Log.e(TAG,"Save Image");
       }
       else {
           Log.e(TAG,"Get Cashed Image");
           imageView.setImageBitmap(memoryCache.getImageFromCashe(HelperMethods.getFileNameFromURL(url)));
       }
   }

   private MindValley(final CasheJson casheJson)
   {
       requestName = casheJson.requestName;
       object = casheJson.object;

       memoryCache = new MemoryCache();

       if(memoryCache.getJsonFromCashe(requestName) == null)
           memoryCache.saveJsonToCashe(object,requestName);

   }


   public  Object getCashe(String requestName)
   {
       Object object = null;

       memoryCache = new MemoryCache();

       object = memoryCache.getJsonFromCashe(requestName);

       return object;
   }


   /*
   Builder Classes
   */
  public static class DownLoad
   {

       private ProgressDialog mProgressDialog;
       private String url;
       private  Context context;

       public DownLoad with(final Context context)
       {
           this.context = context;
           return this;
       }


       public DownLoad from(final String url)
       {
           this.url = url;
           return this;
       }
       public DownLoad dialog(final ProgressDialog mProgressDialog)
       {
           this.mProgressDialog = mProgressDialog;
           return this;
       }

       public MindValley downLoad()
       {
           return new MindValley(this,"start");
       }

       public MindValley cancel()
       {
           return new MindValley(this,"cancel");
       }


   } // class of DownLoad Builder

   public   static class LoadImage
    {
        private ImageView imageView;
        private String url;
        private  Context context;

        public LoadImage with(final Context context)
        {
            this.context = context;
            return this;
        }


        public LoadImage from(final String url)
        {
            this.url = url;
            return this;
        }
        public LoadImage into(final ImageView imageView)
        {
            this.imageView = imageView;
            return this;
        }
        public MindValley create()
        {
            return new MindValley(this);
        }
    } // class of LoadImage Builder

   public static class CasheJson
   {
       private String requestName;
       private Object object;


       public CasheJson request(final String requestName)
       {
           this.requestName = requestName;
           return this;
       }
       public CasheJson json(final Object object)
       {
           this.object = object;
           return this;
       }

       public MindValley cahse()
       {
           return new MindValley(this);
       }

   } // class of CashJson Builder


    
} // class of MindValley ----> MainLibrary
