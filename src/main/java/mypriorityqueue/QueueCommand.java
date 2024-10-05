package mypriorityqueue;

import java.time.Instant;
import java.util.Stack;

// Command interface
public interface QueueCommand {
    Student execute();
    void undo();
}

// Concrete Classes
class AddElementCommand implements QueueCommand {
    private final StudentPriorityQueue queue;
    private Student student;

    AddElementCommand(StudentPriorityQueue queue, Student student) {
        this.queue = queue;
        this.student = student;
    }

    @Override
    public Student execute() {
        student.setInsertionTime(Instant.now());
        queue.offer(student);
        return student;
    }

    @Override
    public void undo() {
        student = queue.poll();
    }
}

class RemoveElementCommand implements QueueCommand {
    private final StudentPriorityQueue queue;
    private Student student;

    RemoveElementCommand(StudentPriorityQueue queue) {
        this.queue = queue;
    }

    @Override
    public Student execute() {
        return queue.poll();
    }

    @Override
    public void undo() {
        queue.offer(student);
    }
}

class PeekElementCommand implements QueueCommand {
    private final StudentPriorityQueue queue;

    PeekElementCommand(StudentPriorityQueue queue) {
        this.queue = queue;
    }

    @Override
    public Student execute() {
        return queue.peek();
    }

    @Override
    public void undo() {
    }

}

//Invoker
class QueueCommandInvoker {
    private final Stack<QueueCommand> commandHistory = new Stack<>();

    Student execute(QueueCommand command) {
        commandHistory.push(command);
        return command.execute();
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