import java.util.ArrayList;

public class Portfolio {
    private String name;
    private ArrayList<Project> projects = new ArrayList<Project>();

    //Constructors
    public Portfolio(){
        name = "unnamed";
    }
    public Portfolio(String name){
        this.name = name;
    }
    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void addProject(Project project){
        this.projects.add(project);
    }
    //Getters
    public String getName(){
        return this.name;
    }
    public double getPortfolioCost(){
        double total = 0.0;
        //if projects is not empty
        if(!this.projects.isEmpty()){
            for(int i = 0; i < this.projects.size(); i++){
                total += this.projects.get(i).getInitialCost();
            }
        }

        return total;
    }
    public void showPortfolio(){
        System.out.println("\n" + this.name + ":");
        if(!this.projects.isEmpty()){
            for(int i = 0; i < this.projects.size(); i++){
                System.out.println(this.projects.get(i).elevatorPitch());
            }
            System.out.println("Total Cost: " + this.getPortfolioCost());
        }
        else{
            System.out.println("Portfolio is empty");
        }
    }
}