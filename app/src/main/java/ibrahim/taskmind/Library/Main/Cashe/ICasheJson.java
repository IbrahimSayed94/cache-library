package ibrahim.taskmind.Library.Main.Cashe;





public interface ICasheJson
{
    void saveJsonToCashe(Object object, String request);

    Object getJsonFromCashe(String request);
}
