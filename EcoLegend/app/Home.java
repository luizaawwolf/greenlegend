public class Home {
    private boolean renewable;
    private double electricity;
    private double nGas;
    private double water;
    private boolean recycle;
    private double waste;
    private int household;
    private boolean isElectric;
    private double miles;
    private String diet;

    public Home (boolean renew, double elect, double ng, double wat, boolean rec, double was, int people, boolean e,
                 double dis, String diet) {  // elect, ng, wat are bills/month
        this.renewable = renew;
        this.electricity = elect;
        this.nGas = ng;
        this.water = wat;
        this.recycle = rec;
        this.waste = was;
        this.household = people;
        this.isElectric = e;
        if (e) {
            this.miles = dis;
        }
        this.diet = diet;
    }

    public double getElectricity() {
        return (1.2385 * 0.453592) * ((electricity / household) / 30.41667) / 0.1289;   // electricity = monthly bill
    }

    public double getnGas() {
        return (11.7 * 0.453592) * ((nGas / household) / 30.41667) / 1.034; // natural gas in therms/day. nGas = natural gas bill
    }

    public double getWater() {
        return (((water / household) / 30.41667) / 0.00150) / 244956;     //water = water bill. returning  gal/day
    }

    public double getWaste() {
        if (recycle) {                                               // household waste should be given in kg/week
            return 0.1819 * (1000 / 365) * ((waste / household) / 7);
        } else {
            return 0.3139 * (1000 / 365) * ((waste / household) / 7);

        }
    }

    public double getElectric() {
        if (!isElectric) {
            return miles * (38.5 / 135);
        } else {
            return 0;
        }
    }

    public double getHomeEnergy() {
        if (!renewable) {
            return getElectric() + getnGas() + getWater() + getWaste() + getElectricity();
        } else {
            return getWaste() + getWater();
        }
    }

    public double getDietary() {
        switch(diet) {
            case "Vegan":
                return 1.5;
            case "Vegetarian":
                return 1.7;
            case "No beef":
                return 1.9;
            case "Average":
                return 2.5;
            default:
                return 3.3;
        }
    }
}
