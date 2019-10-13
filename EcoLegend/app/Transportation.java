public class Transportation {
    private double miles;
    private int mpg;
    private int vehicle;
    private boolean passVehicle;
    private boolean intercity;
    private boolean commuter;
    private boolean transit;
    private boolean bus;
    private double intDis;
    private double comDis;
    private double tranDis;
    private double busDis;
    private boolean electric;
    private boolean hybrid;
    private boolean flight;
    private double flightDis;
    private boolean hotel;
    private int nights;
    private int rooms;

    public Transportation(double mil, int mpg, int vehicle, boolean passVehicle, boolean ir, double ird, boolean cr,
                          double crd, boolean tr, double trd, boolean bus, double busd, boolean e, boolean hy,
                          boolean ld, double dis, boolean hot, int nts, int rms) {
        this.miles = mil;
        this.mpg = mpg;
        this.vehicle = vehicle;
        this.passVehicle = passVehicle;
        if (passVehicle) {
            this.intercity = ir;
            this.intDis = ird;
            this.commuter = cr;
            this.comDis = crd;
            this.transit = tr;
            this.tranDis = trd;
            this.bus = bus;
            this.busDis = busd;
        }
        this.electric = e;
        this.hybrid = hy;
        this.flight = ld;
        if (ld) {
            this.flightDis = dis;
        }
        if (hot) {
            this.hotel = true;
            this.nights = nts;
            this.rooms = rms;
        }
    }

    public double getPerVehicle(int x) {
        return x * ((miles / mpg) * 19.6 * 0.453592);  // mile driven per day
    }

    public double getPassVehicle(boolean x) {
        if (x) {
            if (intercity) {
                return 0.14 * intDis;
            }
            if (commuter) {
                return 0.17 * comDis;
            }
            if (transit) {
                return 0.12 * tranDis;
            }
            if (bus) {
                return 0.06 * busDis;
            }
        }
        return 0;
    }

    public double getIsElectric(int x) {
        return x * ((miles / mpg) * 0);
    }

    public double getIsHybrid(int x) {
        return x * (0.516 * miles * 0.453592);  // 0.516 lbs of CO2 emitted per mile. Now in kg
    }

    public double getIsFlight() {
        if (flight) {
            if (flightDis > 2300) {
                return 0.17 * flightDis;
            } else if (300 <= flightDis && flightDis <= 2300) {
                return 0.14 * flightDis;
            } else {
                return 0.25 * flightDis;
            }
        }
        return 0;
    }

    public double getHotel() {
        if (hotel) {
            return 38.27 * rooms * nights;
        }
        return 0;
    }

    public double getTotallpg() {
        if (electric) {
            return getIsElectric(vehicle) + getPassVehicle(passVehicle) + getIsFlight() + getHotel();
        } else if (hybrid) {
            return getIsHybrid(vehicle) + getPassVehicle(passVehicle) + getIsFlight() + getHotel();
        } else {
            return getPerVehicle(vehicle) + getPassVehicle(passVehicle) + getIsFlight() + getHotel();
        }
    }

}
