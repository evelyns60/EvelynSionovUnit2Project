public class LinearEquation {
    private int  x1;
    private int y1;
    private int x2;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {

        this.x1 = x1;
        this. y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double distance() {
        double distance = 	Math.sqrt(Math.pow((double)x2 - x1, 2) + Math.pow((double)y2 - y1, 2));
        return roundedToHundredth(distance);
    }

    public double slope() {
        double slope = ((double)(y2) - y1)/(x2-x1);
        return roundedToHundredth(slope);
    }

    public double yIntercept() {
        double yIntercept = y2 - (slope() * x2);
        return roundedToHundredth(yIntercept);
    }

    public String slopeDisplay() {
        int rise = y2 - y1;
        int run = x2 - x1;
        String slopeDisplay;
        String riseString;
        String runString;

        if ( rise % run == 0) {                                    //is it a whole number/can it be reduced
            if (rise == 0) {
                slopeDisplay = "0";
            } else {
                slopeDisplay = Integer.toString(rise / run);
            }
        } else if (run < 0 && rise > 0) {                          //is negative sign on denominator
            runString = Integer.toString(run);
            slopeDisplay = "-" + rise + "/" + runString.substring(1);
        } else if (run < 0 && rise < 0) {                          //is both numerator and denominator negative
            runString = Integer.toString(run).substring(1);
            riseString = Integer.toString(rise).substring(1);
            slopeDisplay = riseString + "/" + runString;
        } else if (run > 0 && rise > 0) {
            riseString = Integer.toString(rise);
            runString = Integer.toString(run);
            slopeDisplay = riseString + "/" + runString;
        } else {
            slopeDisplay = "";
        }

        if ((double)rise / run == 1) {                             //is slope 1
            slopeDisplay = "";
        }

        if ((double)rise / run == -1) {                            //is slope -1
            slopeDisplay = "-";
        }
        return slopeDisplay;
    }

    public String equation() {

        String equation = "y = " + slopeDisplay() + "x";
        if (yIntercept() == 0) {                                   //is y intercept zero
            equation += "";
        } else if (yIntercept() < 0) {                             //is y intercept negative
            String yInterceptString = Double.toString(yIntercept()).substring(0);
            equation += " - " + yInterceptString;
        } else {                                                   //is y intercept positive
            equation += " + " + yIntercept();
        }

        if (slopeDisplay() == "0") {                               //is slope zero
            equation = "y = " +equation.substring(equation.indexOf("x") + 4);
        }
        return equation;
    }

    public String coordinateForX(double xValue) {
        double yValue = slope() * xValue + yIntercept();
        return "(" + xValue + ", " + yValue + ")";
    }

    public String lineInfo() {
        String str = "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of this line is: " + yIntercept();
        str += "\nThe distance between the two points is: " + distance();
        return str;
    }

    public double roundedToHundredth(double toRound) {
        return Math.round(toRound*100) / 100.0;
    }
}
