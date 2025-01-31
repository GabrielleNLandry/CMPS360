using System;
using System.Collections.Generic;

public class Task
{
    public int Id { get; set; }
    public string Description { get; set; }
    public bool IsCompleted { get; set; }

    public Task(int id, string description)
    {
        Id = id;
        Description = description;
        IsCompleted = false;
    }
}

class Program
{
    static void Main(string[] args)
    {
        List<Task> tasks = new List<Task>();
        int taskId = 1;

        while (true)
        {
            Console.Clear();
            Console.WriteLine("To-Do List Application");
            Console.WriteLine("1. Add a Task");
            Console.WriteLine("2. View Tasks");
            Console.WriteLine("3. Remove a Task");
            Console.WriteLine("4. Exit");
            Console.Write("Choose an option: ");
            string choice = Console.ReadLine();

            switch (choice)
            {
                case "1":
                    Console.Write("Enter task description: ");
                    string description = Console.ReadLine();
                    if (string.IsNullOrWhiteSpace(description))
                    {
                        Console.WriteLine("Task description cannot be empty.");
                    }
                    else
                    {
                        tasks.Add(new Task(taskId++, description));
                        Console.WriteLine("Task added.");
                    }
                    break;

                case "2":
                    Console.WriteLine("Task List:");
                    foreach (var task in tasks)
                    {
                        string status = task.IsCompleted ? "Completed" : "Not Completed";
                        Console.WriteLine($"{task.Id}. {task.Description} - {status}");
                    }
                    Console.ReadLine();
                    break;

                case "3":
                    Console.Write("Enter task ID to remove: ");
                    if (int.TryParse(Console.ReadLine(), out int taskIdToRemove))
                    {
                        var taskToRemove = tasks.Find(t => t.Id == taskIdToRemove);
                        if (taskToRemove != null)
                        {
                            tasks.Remove(taskToRemove);
                            Console.WriteLine("Task removed.");
                        }
                        else
                        {
                            Console.WriteLine("Task not found.");
                        }
                    }
                    else
                    {
                        Console.WriteLine("Invalid task ID.");
                    }
                    break;

                case "4":
                    return;

                default:
                    Console.WriteLine("Invalid option, please try again.");
                    break;
            }

            Console.WriteLine("Press Enter to continue...");
            Console.ReadLine();
        }
    }
}


