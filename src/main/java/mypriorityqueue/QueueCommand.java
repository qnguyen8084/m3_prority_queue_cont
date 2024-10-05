package mypriorityqueue;

import java.sql.Statement;
import java.util.Stack;

// Command interface
public interface QueueCommand {
    void execute();
    void undo();
}


// Concrete Classes
class AddElementCommand implements QueueCommand {
    private StudentPriorityQueue queue;
    private Student student;

    AddElementCommand(StudentPriorityQueue queue, Student student) {
        this.queue = queue;
        this.student = student;
    }

    @Override
    public void execute() {
        queue.offer(student);
    }

    @Override
    public void undo() {
        student = queue.poll();
    }
}

class RemoveElementCommand implements QueueCommand {
    private StudentPriorityQueue queue;
    private Student student;

    RemoveElementCommand(StudentPriorityQueue queue) {
        this.queue = queue;
    }

    @Override
    public void execute() {
        this.student = queue.poll();
    }

    @Override
    public void undo() {
        queue.offer(student);
    }
}

class PeekElementCommand implements QueueCommand {
    private StudentPriorityQueue queue;
    private Student student;

    PeekElementCommand(StudentPriorityQueue queue) {
        this.queue = queue;
    }

    @Override
    public void execute() {
        this.student = queue.peek();
    }

    @Override
    public void undo() {
    }

}

//Invoker
class QueueCommandInvoker {
    private Stack<QueueCommand> commandHistory = new Stack<>();

    void executeOperation(QueueCommand command) {
        command.execute();
        commandHistory.push(command);
    }

    void undoOperation() {
        if (!commandHistory.isEmpty()) {
            QueueCommand lastOperation = commandHistory.pop();
            lastOperation.undo();
        } else {
            System.out.println("History is empty");
        }
    }

}