package Util;

public class Cookie {
    private  int user_id;
    private int doc_id;
    private static Cookie instance;



   public  static Cookie getinstance()
   {
       if(instance==null)
       {
           instance=new Cookie();
       }
       return instance;
   }
    public  int getter_docid()
    {
        return doc_id;
    }
    public  void setter_docid(int id)
    {
        this.doc_id=id;
    }

    public  int getter_userid()
    {
        return user_id;
    }
    public  void setter_userid(int id)
    {
        this.user_id=id;
    }
    public  void clear_session()
    {

        this.user_id=0;
    }
    public void clear_docsession()
    {
        this.doc_id=0;
    }

}
