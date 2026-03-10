import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.println("\n===== TASK MANAGER =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch(choice){

                case 1:
                    addTask();
                    break;

                case 2:
                    viewTasks();
                    break;

                case 3:
                    completeTask();
                    break;

                case 4:
                    deleteTask();
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid option");

            }
        }
    }

    static void addTask(){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Task Title: ");
        String title = sc.next();

        Task t = new Task(id, title);

        tasks.add(t);

        System.out.println("Task added successfully!");
    }

    static void viewTasks(){

        if(tasks.isEmpty()){
            System.out.println("No tasks available.");
            return;
        }

        for(Task t : tasks){

            String status = t.isCompleted ? "Completed" : "Pending";

            System.out.println("ID: " + t.id);
            System.out.println("Title: " + t.title);
            System.out.println("Status: " + status);
            System.out.println("----------------------");

        }
    }

    static void completeTask(){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Task ID to complete: ");
        int id = sc.nextInt();

        for(Task t : tasks){

            if(t.id == id){
                t.isCompleted = true;
                System.out.println("Task marked as completed!");
                return;
            }

        }

        System.out.println("Task not found.");
    }

    static void deleteTask(){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Task ID to delete: ");
        int id = sc.nextInt();

        for(Task t : tasks){

            if(t.id == id){
                tasks.remove(t);
                System.out.println("Task deleted successfully!");
                return;
            }

        }

        System.out.println("Task not found.");
    }

}
