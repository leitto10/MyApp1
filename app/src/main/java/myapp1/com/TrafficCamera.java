package myapp1.com;

class TrafficCamera {

    String label;
    String imageUrl;
    String owner;
    double[] coordinates;

    public TrafficCamera(String label, String imageUrl, String owner, double[] coordinates){

        this.label = label;
        this.imageUrl = imageUrl;
        this.owner = owner;
        this.coordinates = coordinates;

    }

    public String imageUrl() {
        return this.imageUrl;
    }

    public String getLabel(){
        return this.label;
    }

    public double[] getCoords(){
        return this.coordinates;
    }
}
