/*
 * Quy Nguyen
 * CS635
 * M3 - Priority Queue (continued)
 * 10/7/2024
 * QueueCommand.java
 */

package mypriorityqueue;

import java.time.Instant;
import java.util.Stack;

// Command interface
public abstract class Command {
    public abstract Student execute();
    public abstract void undo();
    public abstract boolean isUndoable();
}

// Concrete Classes
class AddElementCommand extends Command { // This is an undoable command
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
        queue.remove(student);
    }

    public boolean isUndoable() {
        return true;
    }
}


class RemoveHeadCommand extends Command{ // This is an undoable command
    private final StudentPriorityQueue queue;
    private Student student;

    RemoveHeadCommand(StudentPriorityQueue queue) {
        this.queue = queue;
    }

    @Override
    public Student execute() {
        this.student = queue.poll();
        return this.student;
    }

    @Override
    public void undo() {
        queue.offer(student);
    }

    public boolean isUndoable() {
        return true;
    }
}



class RemoveElementCommand extends Command{ // This is an undoable command
    private final StudentPriorityQueue queue;
    private Student student;

    RemoveElementCommand(StudentPriorityQueue queue, Student student) {
        this.queue = queue;
    }

    @Override
    public Student execute() {
        queue.remove(student);
        return student;
    }

    @Override
    public void undo() {
        queue.offer(student);
    }

    public boolean isUndoable() {
        return true;
    }
}

class PeekElementCommand extends Command { // This is not an undoable command
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

    public boolean isUndoable() {
        return false;
    }
}

//Invoker
class CommandInvoker {
    private final Stack<Command> commandHistory = new Stack<>();

    Student execute(Command command) {
        if (command.isUndoable()) {
            commandHistory.push(command);
        }
        return command.execute();
    }

    void undoOperation() {
        if (!commandHistory.isEmpty()) {
            Command lastOperation = commandHistory.pop();
            lastOperation.undo();
        } else {
            System.out.println("History is empty");
        }
    }
}