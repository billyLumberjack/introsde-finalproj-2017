package introsde.finalproj.model;
                 
public class Nutrition
{
    private Nutrients[] nutrients;

    private CaloricBreakdown caloricBreakdown;

    public Nutrients[] getNutrients ()
    {
        return nutrients;
    }

    public void setNutrients (Nutrients[] nutrients)
    {
        this.nutrients = nutrients;
    }

    public CaloricBreakdown getCaloricBreakdown ()
    {
        return caloricBreakdown;
    }

    public void setCaloricBreakdown (CaloricBreakdown caloricBreakdown)
    {
        this.caloricBreakdown = caloricBreakdown;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [nutrients = "+nutrients+", caloricBreakdown = "+caloricBreakdown+"]";
    }
}
	