public class Door
{
    private String name;
    private boolean isOpened;
    
    public Door()
    {
        this.name = "";
        this.isOpened = true;
    }
    
    public Door(String newName, boolean startsOpen)
    {
        this.name = newName;
        this.isOpened = startsOpen;
    }
    
    public void Open()
    {
        this.isOpened = true;
    }
    
    public void Close()
    {
        this.isOpened = false;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String getOpen()
    {
        if (this.isOpened == true)
        {
            return "open";
            
        }
        else
        {
            return "closed";
        }
    }
    
    public void setName(String newName)
    {
        this.name = newName;
    }
    
}