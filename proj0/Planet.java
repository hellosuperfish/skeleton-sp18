public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static double GravCons = 6.67E-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet b){
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    //method that calculates distance between this Planet and the given Planet
    public double calcDistance(Planet otherPlanet){
        double rx = otherPlanet.xxPos - this.xxPos;
        double ry = otherPlanet.yyPos - this.yyPos;
        double distance = Math.sqrt(rx * rx + ry * ry);
        return distance;
    }

    //method calculating the force exerted on this Planet by the given Planet
    public double calcForceExertedBy(Planet otherPlanet){
        double dist = this.calcDistance(otherPlanet);
        double force = (GravCons * this.mass * otherPlanet.mass) / (dist * dist);
        return force;
    }

    public double calcForceExertedByX(Planet otherPlanet){
        double dx = otherPlanet.xxPos - this.xxPos;
        double r = this.calcDistance(otherPlanet);
        double force = this.calcForceExertedBy(otherPlanet);
        double forceX = (force * dx) / r;
        return forceX;
    }

    public double calcForceExertedByY(Planet otherPlanet){
        double dy = otherPlanet.yyPos - this.yyPos;
        double r = this.calcDistance(otherPlanet);
        double force = this.calcForceExertedBy(otherPlanet);
        double forceY = (force * dy) / r;
        return forceY;
    }

    public double calcNetForceExertedByX(Planet[] allBodies){
        double netForceX = 0;
        for (int i = 0; i < allBodies.length; i++){
            if(allBodies[i] != this) {
                double fx = this.calcForceExertedByX(allBodies[i]);
                netForceX = netForceX + fx;
            }
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(Planet[] allBodies){
        double netForceY = 0;
        for (int i = 0; i < allBodies.length; i++){
            if(allBodies[i] != this) {
                double fy = this.calcForceExertedByY(allBodies[i]);
                netForceY = netForceY + fy;
            }
        }
        return netForceY;
    }

    public void update(double dt, double fX, double fY){
        double ax = fX / this.mass;
        double ay = fY / this.mass;
        this.xxVel = this.xxVel + dt * ax;
        this.yyVel = this.yyVel + dt * ay;
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw(){
        String imageToDraw = "images/"+this.imgFileName;
        StdDraw.enableDoubleBuffering();
        //StdDraw.clear();
        StdDraw.picture(this.xxPos, this.yyPos, imageToDraw);
        StdDraw.show();
        //StdDraw.pause(2000);
    }

}
