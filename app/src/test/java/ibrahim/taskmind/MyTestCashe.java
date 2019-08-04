package ibrahim.taskmind;

import android.graphics.Bitmap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import ibrahim.taskmind.Library.Main.Cashe.MemoryCache;
import ibrahim.taskmind.application.Model.DataResponse;

import static org.junit.Assert.assertEquals;

public class MyTestCashe
{
    @Mock
    DataResponse json1,json2;
    MemoryCache memoryCache;

    String requestName = "data";

    @Mock
    Bitmap bitmap;

    @Before
    public void initObjects()
    {
        memoryCache = new MemoryCache();

        json1 = new DataResponse();



    }

    @Test
    public  void checkCashedData() throws Exception
    {
        memoryCache.saveJsonToCashe(json1,requestName);

        json2 = (DataResponse) memoryCache.getJsonFromCashe(requestName);

        assertEquals("Data saved Successfully" , json2,json1);

    }

    @Test
    public void checkImageIfCashed() throws Exception
    {
        memoryCache.saveImageToCashe(bitmap,"image");

        Bitmap testBitmp = memoryCache.getImageFromCashe("image");

        assertEquals("Image saved Successfully",bitmap,testBitmp);
    }
}
