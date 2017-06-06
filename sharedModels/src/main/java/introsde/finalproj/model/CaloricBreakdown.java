package introsde.finalproj.model;
                 
public class CaloricBreakdown
{
    private String percentFat;

    private String percentCarbs;

    private String percentProtein;

    public String getPercentFat ()
    {
        return percentFat;
    }

    public void setPercentFat (String percentFat)
    {
        this.percentFat = percentFat;
    }

    public String getPercentCarbs ()
    {
        return percentCarbs;
    }

    public void setPercentCarbs (String percentCarbs)
    {
        this.percentCarbs = percentCarbs;
    }

    public String getPercentProtein ()
    {
        return percentProtein;
    }

    public void setPercentProtein (String percentProtein)
    {
        this.percentProtein = percentProtein;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [percentFat = "+percentFat+", percentCarbs = "+percentCarbs+", percentProtein = "+percentProtein+"]";
    }
}