public class ProjectTest {
    public static void main(String[] args){
        Project firstProject = new Project();
        Project secondProject = new Project("Is Named");
        Project thirdProject = new Project("Also Named", "and described");

        System.out.println(firstProject.elevatorPitch());
        System.out.println(secondProject.elevatorPitch());
        System.out.println(thirdProject.elevatorPitch());

        firstProject.setName("Now named");
        System.out.println(firstProject.getName());

        secondProject.setDescription("Now described");
        System.out.println(secondProject.getDescription());

        thirdProject.setInitialCost(9.99);
        System.out.println(thirdProject.elevatorPitch());

        Portfolio firstPortfolio = new Portfolio("Initial Portfolio");
        Portfolio secondPortfolio = new Portfolio("Another Portfolio");
        Portfolio emptyPortfolio = new Portfolio("An empty portfolio");
        Project fourthProject = new Project("Fourth Project", "a grand project", 499.99);
        firstProject.setInitialCost(19.99);
        secondProject.setInitialCost(49.99);

        firstPortfolio.addProject(firstProject);
        firstPortfolio.addProject(secondProject);
        secondPortfolio.addProject(thirdProject);
        secondPortfolio.addProject(fourthProject);

        System.out.println(firstPortfolio.getPortfolioCost());
        System.out.println(secondPortfolio.getName());
        firstPortfolio.getPortfolioCost();
        secondPortfolio.showPortfolio();
        emptyPortfolio.showPortfolio();
    }
}