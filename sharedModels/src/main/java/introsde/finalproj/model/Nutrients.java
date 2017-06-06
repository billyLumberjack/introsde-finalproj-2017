package introsde.finalproj.model;
                 
public class Nutrients
{
    private String amount;

    private String unit;

    private String title;

    private String percentOfDailyNeeds;

    public String getAmount ()
    {
        return amount;
    }

    public void setAmount (String amount)
    {
        this.amount = amount;
    }

    public String getUnit ()
    {
        return unit;
    }

    public void setUnit (String unit)
    {
        this.unit = unit;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getPercentOfDailyNeeds ()
    {
        return percentOfDailyNeeds;
    }

    public void setPercentOfDailyNeeds (String percentOfDailyNeeds)
    {
        this.percentOfDailyNeeds = percentOfDailyNeeds;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [amount = "+amount+", unit = "+unit+", title = "+title+", percentOfDailyNeeds = "+percentOfDailyNeeds+"]";
    }
}
	