class Project{
    private String name;
    private String description;
    private double initialCost;

    //Constructors
    public Project(){
        this.name = "unnamed";
        this.description = "no description";
        this.initialCost = 0.0;
    }
    public Project(String name){
        this.name = name;
        this.description = "no description";
        this.initialCost = 0.0;
    }
    public Project(String name, String description){
        this.name = name;
        this.description = description;
        this.initialCost = 0.0;
    }
    public Project(String name, String description, double initialCost){
        this.name = name;
        this.description = description;
        this.initialCost = initialCost;
    }
    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setInitialCost(double initialCost){
        this.initialCost = initialCost;
    }
    //Getters
    public String elevatorPitch(){
        return this.name + " (" + this.initialCost + "): " + this.description;
    }
    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public double getInitialCost(){
        return this.initialCost;
    }
}