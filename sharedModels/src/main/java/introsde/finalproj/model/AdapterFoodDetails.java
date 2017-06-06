package introsde.finalproj.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AdapterFoodDetails
{
    private String amount;

    private String id;

    private String unit;

    private Nutrition nutrition;

    private String aisle;

    private String name;

    private String image;

    public String getAmount ()
    {
        return amount;
    }

    public void setAmount (String amount)
    {
        this.amount = amount;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getUnit ()
    {
        return unit;
    }

    public void setUnit (String unit)
    {
        this.unit = unit;
    }

    public Nutrition getNutrition ()
    {
        return nutrition;
    }

    public void setNutrition (Nutrition nutrition)
    {
        this.nutrition = nutrition;
    }

    public String getAisle ()
    {
        return aisle;
    }

    public void setAisle (String aisle)
    {
        this.aisle = aisle;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [amount = "+amount+", id = "+id+", unit = "+unit+", nutrition = "+nutrition+", aisle = "+aisle+", name = "+name+", image = "+image+"]";
    }
}