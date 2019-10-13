public class TotalEmission {
    Transportation trans = new Transportation();
    Home home = new Home();

    double dietary = home.getDietary();
    double homeEmission = home.getHomeEnergy();
    double transEmission = trans.getTotallpg();

    double totalEmission = dietary + homeEmission + transEmission;
}
